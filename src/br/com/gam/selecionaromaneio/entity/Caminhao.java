package br.com.gam.selecionaromaneio.entity;

import br.com.gam.selecionaromaneio.enuns.EIdDiaSemana;

public class Caminhao {

	private EIdDiaSemana idDiaSemana;
	private Integer codigo;
	private Integer horaEncerramentoCorreia;
	
	public EIdDiaSemana getIdDiaSemana() {
		return idDiaSemana;
	}
	public void setIdDiaSemana(EIdDiaSemana idDiaSemana) {
		this.idDiaSemana = idDiaSemana;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getHoraEncerramentoCorreia() {
		return horaEncerramentoCorreia;
	}
	public void setHoraEncerramentoCorreia(Integer horaEncerramentoCorreia) {
		this.horaEncerramentoCorreia = horaEncerramentoCorreia;
	}

	
}
