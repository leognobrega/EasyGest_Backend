package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Cliente;
import com.easygest.springboot.model.Venda;
import com.easygest.springboot.repository.ClienteRepository;
import com.easygest.springboot.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Venda> listar() {
        return repository.findAll();
    }


    public Venda salvar(Venda venda) {

    Cliente clienteBanco = clienteRepository
            .findById(venda.getCliente().getCodCliente())
            .orElseThrow();

    venda.setCliente(clienteBanco);

    return repository.save(venda);
}

    public Venda buscarPorId(Long codVenda) {
        return repository.findById(codVenda)
                .orElseThrow();
    }

    public void deletar(Long codVenda) {
        repository.deleteById(codVenda);
    }
}