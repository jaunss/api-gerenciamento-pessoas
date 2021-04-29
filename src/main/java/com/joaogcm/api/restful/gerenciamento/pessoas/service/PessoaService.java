package com.joaogcm.api.restful.gerenciamento.pessoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joaogcm.api.restful.gerenciamento.pessoas.entity.Pessoa;
import com.joaogcm.api.restful.gerenciamento.pessoas.repository.PessoaRepository;
import com.joaogcm.api.restful.gerenciamento.pessoas.service.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas;
	}

	public Pessoa findById(Long idPessoa) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
		return pessoa.orElseThrow(
				() -> new ResourceNotFoundException("Pessoa com o id: " + idPessoa + " não foi encontrada."));
	}

	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		try {
			Pessoa pes = findById(pessoa.getIdPessoa());
			updateData(pes, pessoa);
			return pessoaRepository.save(pessoa);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Pessoa pes, Pessoa pessoa) {
		pes.setNomePessoa(pessoa.getNomePessoa());
		pes.setSobrenomePessoa(pessoa.getSobrenomePessoa());
		pes.setCpfPessoa(pessoa.getCpfPessoa());
		pes.setDataNascimentoPessoa(pessoa.getDataNascimentoPessoa());
	}

	public void deleteById(Long id) {
		try {
			findById(id);
			pessoaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
}