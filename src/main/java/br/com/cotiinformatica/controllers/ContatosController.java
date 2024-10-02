package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ContatoRequestDto;
import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.repositories.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")

public class ContatosController {
	
	@PostMapping
	public String post(@RequestBody ContatoRequestDto request) throws Exception{
		
		var contato = new Contato();
		
		contato.setIdContato(Integer.parseInt(request.getIdContato().toString()));
		contato.setNome(request.getNome());
		contato.setEmail(request.getEmail());
		contato.setTelefone(request.getTelefone());
		
		var contatoRepository = new ContatoRepository();
		contatoRepository.create(contato);
		
		return "Cliente cadastrado com sucesso";
		
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable Integer id, @RequestBody ContatoRequestDto request) throws Exception {
		
		var contatoRepository = new ContatoRepository();
		var contato = contatoRepository.getById(id);
		
		if(contato != null) {
			contato.setNome(request.getNome());
			contato.setEmail(request.getEmail());
			contato.setTelefone(request.getTelefone());
			
			contatoRepository.update(contato);
			
			return "Contato atualizado com sucesso.";
		}
		else {
			return "Contato não encontrado. Verifique o ID informado.";
		}
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Integer id) throws Exception {
		
		var contatoRepository = new ContatoRepository();
		var contato = contatoRepository.getById(id);
		
		if(contato != null) {
			contatoRepository.delete(id);
			return "Contato excluído com sucesso.";
		}
		else {
			return "Contato não encontrado. Verifique o ID informado.";
		}
	}
	
	@GetMapping
	public List<Contato> get() throws Exception {
		
		var contatoRepository = new ContatoRepository();
		return contatoRepository.getAll();
		
	}
	@GetMapping("{id}")
	public ResponseEntity<Contato> getById(@PathVariable Integer id) throws Exception {
		
		var contatoRepository = new ContatoRepository();
		var contato = contatoRepository.getById(id);
		
		if(contato != null) {
			return ResponseEntity.ok(contato);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
}
