package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easygest.springboot.model.ItemVenda;

public interface ItemVendaRepository
        extends JpaRepository<ItemVenda, Long> {
}
