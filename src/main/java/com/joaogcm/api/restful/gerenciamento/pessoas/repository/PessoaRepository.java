package com.joaogcm.api.restful.gerenciamento.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.restful.gerenciamento.pessoas.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}