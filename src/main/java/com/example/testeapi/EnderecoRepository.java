package com.example.testeapi;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByCep(String cep);
}
