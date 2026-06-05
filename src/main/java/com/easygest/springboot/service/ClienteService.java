package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Cliente;
import com.easygest.springboot.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    // LISTAR TODOS
    public List<Cliente> listar() {

        return repository.findAll();
    }

    // SALVAR
    public Cliente salvar(Cliente cliente) {

        return repository.save(cliente);
    }

    // BUSCAR POR ID
    public Cliente buscarPorId(Long codCliente) {

        return repository.findById(codCliente)
                .orElseThrow();
    }

    // ATUALIZAR
    public Cliente atualizar(Long codCliente, Cliente cliente) {

    Cliente clienteExistente =
            buscarPorId(codCliente);

    clienteExistente.setNomeCliente(cliente.getNomeCliente());
    clienteExistente.setCpfCliente(cliente.getCpfCliente());
    clienteExistente.setEnderecoCliente(cliente.getEnderecoCliente());
    clienteExistente.setTelefoneCliente(cliente.getTelefoneCliente());
    clienteExistente.setEmailCliente(cliente.getEmailCliente());
    clienteExistente.setStatusCliente(cliente.getStatusCliente());
    clienteExistente.setDataCadastro(cliente.getDataCadastro());

    return repository.save(clienteExistente);
}

    // DELETAR
    public void deletar(Long codCliente) {

        repository.deleteById(codCliente);
    }
}