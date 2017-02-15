package br.com.gam.selecionaromaneio.entity;

public class Terminal {

	private Integer codigo;
	private Integer qantidadeMaxBuffer;
	private Integer tempoPorUnidades;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getQantidadeMaxBuffer() {
		return qantidadeMaxBuffer;
	}
	public void setQantidadeMaxBuffer(Integer qantidadeMaxBuffer) {
		this.qantidadeMaxBuffer = qantidadeMaxBuffer;
	}
	public Integer getTempoPorUnidades() {
		return tempoPorUnidades;
	}
	public void setTempoPorUnidades(Integer tempoPorUnidades) {
		this.tempoPorUnidades = tempoPorUnidades;
	}
	
}
