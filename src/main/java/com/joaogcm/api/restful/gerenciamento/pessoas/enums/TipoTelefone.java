package com.joaogcm.api.restful.gerenciamento.pessoas.enums;

public enum TipoTelefone {

	HOME(1, "Casa"),
	MOBILE(2, "Celular"),
	COMMERCIAL(3, "Comercial");

	private Integer status;
	private String descricao;

	private TipoTelefone(Integer status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoTelefone getTipo(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TipoTelefone tipo : TipoTelefone.values()) {
			if (codigo.equals(tipo.getStatus())) {
				return tipo;
			}
		}

		throw new IllegalArgumentException("Código inválido: ID = " + codigo);
	}
}