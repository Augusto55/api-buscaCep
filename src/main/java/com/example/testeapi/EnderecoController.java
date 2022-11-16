package com.example.testeapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EnderecoController {


    private final EnderecoRepository repository;

    EnderecoController(EnderecoRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/enderecos")
    List<Endereco> all() {
        return repository.findAll();
    }

    @PostMapping("/enderecos")
    Endereco newEndereco(@RequestBody Endereco newEndereco) {
        return repository.save(newEndereco);
    }

    @GetMapping("/enderecos/buscaId/{id}")
    Endereco one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException(id));
    }

    @GetMapping("/enderecos/buscaCep/{cep}")
    List<Endereco> one(@PathVariable String cep) {
        return repository.findByCep(cep.replace("-",""));
               //.orElseThrow(() -> new EnderecoNotFoundException(cep));
    }


    @PutMapping("/enderecos/{id}")
    Endereco replaceEndereco(@RequestBody Endereco newEndereco, @PathVariable Long id) {

        return repository.findById(id)
                .map(endereco -> {
                    endereco.setRua(newEndereco.getRua());
                    endereco.setNumero(newEndereco.getNumero());
                    endereco.setComplemento(newEndereco.getComplemento());
                    endereco.setBairro(newEndereco.getBairro());
                    endereco.setCidade(newEndereco.getCidade());
                    endereco.setEstado(newEndereco.getEstado());
                    endereco.setCep(newEndereco.getCep());
                    return repository.save(endereco);
                })
                .orElseGet(() -> {
                    newEndereco.setId(id);
                    return repository.save(newEndereco);
                });
    }

    @DeleteMapping("/enderecos/{id}")
    void deleteEndereco(@PathVariable Long id) {
        repository.deleteById(id);
    }
}