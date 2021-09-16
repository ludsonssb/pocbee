package com.brandao.pocbee.service;

import com.brandao.pocbee.domain.request.PessoaRequest;
import com.brandao.pocbee.domain.response.PessoaResponse;
import com.google.api.services.bigquery.Bigquery;
import com.google.cloud.bigquery.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    public PessoaResponse buscarPessoaPorId(String cpf) throws InterruptedException {

        BigQuery bigQuery = BigQueryOptions.getDefaultInstance().getService();

       String query = "select * from `pocbee01.poc_bee.pessoas` where CPF =" + cpf;
       String insert = "insert into `pocbee01.poc_bee.pessoas` values (12321321, \"21312312\", \"2021-09-14\", \"bee@pocbeeeqweqw.com\")";
        PessoaResponse pessoaResponse = new PessoaResponse();

        QueryJobConfiguration queryJobConfiguration = QueryJobConfiguration.newBuilder(query).build();

        QueryJobConfiguration queryJobConfigurationT = QueryJobConfiguration.newBuilder(insert).build();

        bigQuery.create(JobInfo.of(queryJobConfigurationT));

        for(FieldValueList row : bigQuery.query(queryJobConfiguration).iterateAll()){

            pessoaResponse.setCpf(row.get("CPF").getStringValue());
            pessoaResponse.setEmail(row.get("EMAIL").getStringValue());
            pessoaResponse.setNome(row.get("NOME").getStringValue());
            //pessoaResponse.setDataNascimento(row.get("DATA_NASCIMENTO").getStringValue());
            //return pessoaResponse;
        }
        return pessoaResponse;
    }

    public PessoaResponse cadastroPessoa(PessoaRequest pessoaRequest) {

        return null;
    }

    public Optional<PessoaResponse> atualizaPessoaPorCpf(String cpf, PessoaRequest pessoaRequest) {

        return null;
    }

    public void deletarPessoaPorCpf(String cpf) {
    }
}
