package com.easygest.springboot.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Produto;
import com.easygest.springboot.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // LISTAR TODOS
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // SALVAR
    public Produto salvar(Produto produto) {

        verificarEstoque(produto);

        return produtoRepository.save(produto);
    }

    // BUSCAR POR CÓDIGO
    public Produto buscarPorCod(Long codProduto) {

        return produtoRepository.findById(codProduto)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado."));
    }

    // ATUALIZAR
    public Produto atualizar(Long codProduto, Produto novo) {

        Produto existente = buscarPorCod(codProduto);

        existente.setNomeProduto(novo.getNomeProduto());
        existente.setTipoProduto(novo.getTipoProduto());
        existente.setPesoProduto(novo.getPesoProduto());
        existente.setCustoProduto(novo.getCustoProduto());
        existente.setPrecoProduto(novo.getPrecoProduto());
        existente.setStatusProduto(novo.getStatusProduto());
        existente.setDataCompraProduto(novo.getDataCompraProduto());
        existente.setDataValidadeProduto(novo.getDataValidadeProduto());
        existente.setDataVendaProduto(novo.getDataVendaProduto());
        existente.setDataFabricacaoProduto(novo.getDataFabricacaoProduto());
        existente.setFornecedor(novo.getFornecedor());

        // CAMPOS DE ESTOQUE
        existente.setQuantidadeAtual(novo.getQuantidadeAtual());
        existente.setEstoqueMinimo(novo.getEstoqueMinimo());

        // FORNECEDOR
        existente.setFornecedor(novo.getFornecedor());

        verificarEstoque(existente);

        return produtoRepository.save(existente);
    }

    // EXCLUIR
    public void excluir(Long codProduto) {

        produtoRepository.deleteById(codProduto);
    }

    // REGRA DE NEGÓCIO
    private void verificarEstoque(Produto produto) {

        if (produto.getQuantidadeAtual() != null
                && produto.getEstoqueMinimo() != null
                && produto.getQuantidadeAtual().compareTo(
                        BigDecimal.valueOf(produto.getEstoqueMinimo())) < 0) {

            System.out.println(
                    "ALERTA: Estoque baixo para o produto "
                            + produto.getNomeProduto());
        }
    }
}