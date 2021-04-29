package com.joaogcm.api.restful.gerenciamento.pessoas.dto;

import java.io.Serializable;

public class PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public PessoaDTO() {
		
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}