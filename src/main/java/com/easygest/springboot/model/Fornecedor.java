package com.easygest.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFornecedor;
    private String razaoSocialFornecedor;
    private String nomeFornecedor;
    private String cnpjFornecedor;
    private String enderecoFornecedor;
    private String telefoneFornecedor;
    private String emailFornecedor;
    private LocalDate dataCadastroFornecedor;
}