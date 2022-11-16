package com.example.testeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EnderecoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Endereco("Rua Mabilio Bernardon", 132, "Casa", "Lucas Araújo", "Passo Fundo", "Rio Grande do Sul", "99074370")));
            log.info("Preloading " + repository.save(new Endereco("Rua Mabilio Bernardon", 150, "Casa", "Lucas Araújo", "Passo Fundo", "Rio Grande do Sul", "99074370")));
            log.info("Preloading " + repository.save(new Endereco("Rua Paissandú", 424, "Loja", "Centro", "Passo Fundo", "Rio Grande do Sul", "99010100")));
            log.info("Preloading " + repository.save(new Endereco("Rua Peixoto Gomide", 502, "Ap 502", "Bela Vista", "São Paulo", "São Paulo","01311000")));
            log.info("Preloading " + repository.save(new Endereco("Avenida Rui Barbosa", 450, "", "Jardim Independência", "Sarandi", "Paraná", "87114020")));
        };
    }
}