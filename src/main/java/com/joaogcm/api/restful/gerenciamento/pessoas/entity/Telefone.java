package com.joaogcm.api.restful.gerenciamento.pessoas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.joaogcm.api.restful.gerenciamento.pessoas.enums.TipoTelefone;

@Entity
@Table(name = "tb_telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefone;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoTelefone tipoTelefone;

	private String numeroTelefone;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	public Telefone() {

	}

	public Long getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numeroTelefone;
	}

	public void setNumero(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTelefone == null) ? 0 : idTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (idTelefone == null) {
			if (other.idTelefone != null)
				return false;
		} else if (!idTelefone.equals(other.idTelefone))
			return false;
		return true;
	}
}