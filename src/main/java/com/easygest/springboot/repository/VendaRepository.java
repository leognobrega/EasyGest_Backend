package com.easygest.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easygest.springboot.model.Venda;

public interface VendaRepository
        extends JpaRepository<Venda, Long> {
}