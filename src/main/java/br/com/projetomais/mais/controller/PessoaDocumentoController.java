package br.com.projetomais.mais.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetomais.mais.Pessoa;
import br.com.projetomais.mais.repository.PessoaRepository;

@RestController
public class PessoaDocumentoController {
	
	private PessoaRepository repository;
	
	public PessoaDocumentoController(PessoaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/pessoa-doc")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Pessoa> pessoaDocumentos(){
		return repository.findAll().stream()
                .filter(this::isDocumento)
                .collect(Collectors.toList());
	}
	
	private boolean isDocumento(Pessoa pessoa) {
        return !pessoa.getName().equals("AMC Gremlin") &&
                !pessoa.getName().equals("Triumph Stag") &&
                !pessoa.getName().equals("Ford Pinto") &&
                !pessoa.getName().equals("Yugo GV");
    }
		

}
