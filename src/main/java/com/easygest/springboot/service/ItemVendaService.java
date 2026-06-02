package com.easygest.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.easygest.springboot.model.ItemVenda;
import com.easygest.springboot.repository.ItemVendaRepository;

public class ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    public List<ItemVenda> listar() {
        return repository.findAll();
    }

    public ItemVenda salvar(ItemVenda itemVenda) {
        return repository.save(itemVenda);
    }

    public ItemVenda buscarPorId(Long codItemVenda) {
        return repository.findById(codItemVenda)
                .orElseThrow();
    }

    public void deletar(Long codItemVenda) {
        repository.deleteById(codItemVenda);
    }
}