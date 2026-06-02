package com.easygest.springboot.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemVenda;

    @ManyToOne
    @JoinColumn(name = "codVenda")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "codProduto")
    private Produto produto;

    private Integer quantidade;

    private BigDecimal valorUnitario;
}