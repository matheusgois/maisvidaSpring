package br.com.projetomais.mais.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.projetomais.mais.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{	

}
