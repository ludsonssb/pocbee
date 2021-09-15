package com.brandao.pocbee.controller;

import com.brandao.pocbee.domain.request.PessoaRequest;
import com.brandao.pocbee.domain.response.PessoaResponse;
import com.brandao.pocbee.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("{cpf}")
    public ResponseEntity<PessoaResponse> buscarPorId(@PathVariable String cpf) throws InterruptedException {
        PessoaResponse pessoa = pessoaService.buscarPessoaPorId(cpf);
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(@RequestBody PessoaRequest pessoaRequest) {
        PessoaResponse pessoaSalva = pessoaService.cadastroPessoa(pessoaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @PutMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<PessoaResponse> alterar(@PathVariable String cpf, @RequestBody PessoaRequest pessoaRequest) {
        Optional<PessoaResponse> pessoaSalva = pessoaService.atualizaPessoaPorCpf(cpf, pessoaRequest);
        return  ResponseEntity.ok(pessoaSalva.get());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{cpf}")
    public void excluirPorCpf(@PathVariable String cpf){
        pessoaService.deletarPessoaPorCpf(cpf);
    }

}
