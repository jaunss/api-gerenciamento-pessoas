package com.joaogcm.api.restful.gerenciamento.pessoas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.restful.gerenciamento.pessoas.entity.Pessoa;
import com.joaogcm.api.restful.gerenciamento.pessoas.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/pessoas")
	public ResponseEntity<?> findAll() {
		List<Pessoa> pessoas = pessoaService.findAll();
		return ResponseEntity.ok().body(pessoas);
	}

	@GetMapping(value = "/{idPessoa}")
	public ResponseEntity<?> findById(@PathVariable Long idPessoa) {
		Pessoa pessoa = pessoaService.findById(idPessoa);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<?> insert(@RequestBody Pessoa pessoa) {
		pessoa = pessoaService.insert(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getIdPessoa())
				.toUri();
		return ResponseEntity.created(uri).body(pessoa);
	}

	@PutMapping(value = "/update/{idPessoa}")
	public ResponseEntity<?> update(@PathVariable Long idPessoa, @RequestBody Pessoa pessoa) {
		pessoa.setIdPessoa(idPessoa);
		pessoaService.update(pessoa);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{idPessoa}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "idPessoa") Long idPessoa) {
		pessoaService.deleteById(idPessoa);
		return ResponseEntity.noContent().build();
	}
}