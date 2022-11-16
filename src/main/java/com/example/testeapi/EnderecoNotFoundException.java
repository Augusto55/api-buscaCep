package com.example.testeapi;

public class EnderecoNotFoundException extends RuntimeException {
    EnderecoNotFoundException(Long id) {
        super("Não foi possível encontrar o endereço " + id);
    }
}
