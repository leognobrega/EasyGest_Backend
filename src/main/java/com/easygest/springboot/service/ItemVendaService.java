package com.easygest.springboot.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.ItemVenda;
import com.easygest.springboot.model.Produto;
import com.easygest.springboot.model.Venda;
import com.easygest.springboot.repository.ItemVendaRepository;
import com.easygest.springboot.repository.ProdutoRepository;
import com.easygest.springboot.repository.VendaRepository;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public List<ItemVenda> listar() {
        return repository.findAll();
    }

    public ItemVenda salvar(ItemVenda itemVenda) {

        itemVenda.setSubtotal(
                itemVenda.getValorUnitario()
                        .multiply(BigDecimal.valueOf(itemVenda.getQuantidade()))
        );

        Produto produtoBanco =
                produtoRepository.findById(itemVenda.getProduto().getCodProduto())
                        .orElseThrow();

        produtoBanco.setQuantidadeAtual(
                produtoBanco.getQuantidadeAtual()
                        .subtract(BigDecimal.valueOf(itemVenda.getQuantidade()))
        );

        produtoRepository.save(produtoBanco);

        Venda vendaBanco =
                vendaRepository.findById(itemVenda.getVenda().getCodVenda())
                        .orElseThrow();

        BigDecimal totalAtual = vendaBanco.getValorTotal();

        if (totalAtual == null) {
            totalAtual = BigDecimal.ZERO;
        }

        vendaBanco.setValorTotal(
                totalAtual.add(itemVenda.getSubtotal())
        );

        vendaRepository.save(vendaBanco);

        return repository.save(itemVenda);
    }

    public void deletar(Long codItemVenda) {
        repository.deleteById(codItemVenda);
    }
}