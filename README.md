# Trabalho G2 - Programação Orientada a Objetos Avançado

Alunos: Augusto Tumelero Mesquita e Michel Borille

Esse repositório contem uma API REST desenvolvida em Spring Boot e utilizando o banco da dados em memória H2.
A API possui os métodos GET, POST, DELETE e UPDATE.
É possível fazer a busca dos dados tanto por Id quanto por CEP, porém não é possível excluir ou atualizar registros usando o CEP como parâmetro, pois mais de um registro de endereço pode ter o mesmo CEP.
