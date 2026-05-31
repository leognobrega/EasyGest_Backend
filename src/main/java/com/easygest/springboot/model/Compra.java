package com.easygest.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCompra;
    private Integer pedido;
    private String item;
    private LocalDate dataCompra;
    private LocalDate dataRecebimento;
    private Float valor;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "codFornecedor")
    private Fornecedor fornecedor;
}