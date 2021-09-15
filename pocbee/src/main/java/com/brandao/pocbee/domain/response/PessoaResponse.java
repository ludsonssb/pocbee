package com.brandao.pocbee.domain.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaResponse {

        private String nome;
        private String cpf;
        private LocalDate dataNascimento;
        private String email;
}
