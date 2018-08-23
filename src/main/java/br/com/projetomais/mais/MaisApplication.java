package br.com.projetomais.mais;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.projetomais.mais.repository.PessoaRepository;


@SpringBootApplication
public class MaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaisApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(PessoaRepository repository) {
        return args -> {
            Stream.of("João", "Claudio", "Marcos", "Marcelo", "Caio",
                      "Romenia", "Carla", "Juliana", "Vanessa").forEach(name -> {
                Pessoa pessoa = new Pessoa();
                pessoa.setName(name);
                repository.save(pessoa);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
