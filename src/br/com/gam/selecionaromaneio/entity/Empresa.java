package br.com.gam.selecionaromaneio.entity;

import br.com.gam.selecionaromaneio.enuns.EIdDiaSemana;

public class Empresa {

	private Integer codigo;
	private String nome;
	private EIdDiaSemana idDiaSemana;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public EIdDiaSemana getIdDiaSemana() {
		return idDiaSemana;
	}
	public void setIdDiaSemana(EIdDiaSemana idDiaSemana) {
		this.idDiaSemana = idDiaSemana;
	}
	
}
