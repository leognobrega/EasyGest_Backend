package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easygest.springboot.model.Fornecedor;
import com.easygest.springboot.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // LISTAR
    public List<Fornecedor> listar() {

        return repository.findAll();
    }

    // SALVAR
    public Fornecedor salvar(Fornecedor fornecedor) {

        return repository.save(fornecedor);
    }

    // BUSCAR POR ID
    public Fornecedor buscarPorId(Long codFornecedor) {

        return repository.findById(codFornecedor)
                .orElseThrow();
    }

    // ATUALIZAR
   public Fornecedor atualizar(
        Long codFornecedor,
        Fornecedor fornecedor) {

    Fornecedor fornecedorExistente =
            buscarPorId(codFornecedor);

    fornecedorExistente.setRazaoSocialFornecedor(
            fornecedor.getRazaoSocialFornecedor());

    fornecedorExistente.setNomeFornecedor(
            fornecedor.getNomeFornecedor());

    fornecedorExistente.setCnpjFornecedor(
            fornecedor.getCnpjFornecedor());

    fornecedorExistente.setEnderecoFornecedor(
            fornecedor.getEnderecoFornecedor());

    fornecedorExistente.setTelefoneFornecedor(
            fornecedor.getTelefoneFornecedor());

    fornecedorExistente.setEmailFornecedor(
            fornecedor.getEmailFornecedor());

    fornecedorExistente.setDataCadastroFornecedor(
            fornecedor.getDataCadastroFornecedor());

    return repository.save(fornecedorExistente);
}

    // DELETAR
    public void deletar(Long codFornecedor) {

        repository.deleteById(codFornecedor);
    }
}
