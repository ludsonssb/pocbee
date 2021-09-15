package com.brandao.pocbee.domain.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaRequest {

        private String nome;
        private String cpf;
        private LocalDate dataNascimento;
        private String email;
}