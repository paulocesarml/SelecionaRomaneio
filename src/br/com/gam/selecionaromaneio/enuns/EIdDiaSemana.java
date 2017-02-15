package br.com.gam.selecionaromaneio.enuns;

public enum EIdDiaSemana {
	DIA_SEMANA(1, "DIA DA SEMANA"),
	FINAL_SEMANA(2, "FIM DE SEMANA");
	
	private Integer id;
	private String descricao;
	
	private EIdDiaSemana(Integer id, String descrica){
		this.id = id;
		this.descricao = descrica;
	}
	
	public Integer getValue(){
		return this.id;
	}
	
	@Override
	public String toString(){
		return id + "-" + descricao;
	}	
	
}
