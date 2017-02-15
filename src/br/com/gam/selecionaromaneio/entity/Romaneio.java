package br.com.gam.selecionaromaneio.entity;

import java.util.List;

public class Romaneio {
	
	private List<Terminal> terminais;
	private Integer quantidadeUnidades;
	private Caminhao caminhao;
	
	public List<Terminal> getTerminais() {
		return terminais;
	}
	public void setTerminais(List<Terminal> terminais) {
		this.terminais = terminais;
	}
	public Integer getQuantidadeUnidades() {
		return quantidadeUnidades;
	}
	public void setQuantidadeUnidades(Integer quantidadeUnidades) {
		this.quantidadeUnidades = quantidadeUnidades;
	}
	public Caminhao getCaminhao() {
		return caminhao;
	}
	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}
	
	
}

