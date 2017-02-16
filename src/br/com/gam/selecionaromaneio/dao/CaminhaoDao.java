package br.com.gam.selecionaromaneio.dao;

import java.sql.PreparedStatement;

import javax.naming.spi.DirStateFactory.Result;

import br.com.gam.selecionaromaneio.entity.Caminhao;

public class CaminhaoDao {
	private static CaminhaoDao caminhaoDao;
	
	private CaminhaoDao(){}
	
	public static CaminhaoDao getInstance(){
		if (caminhaoDao == null){
			caminhaoDao = new CaminhaoDao();
		}
		return caminhaoDao;
	}
	
	public Caminhao buscarCaminhao()
		throws Exception{
		
		PreparedStatement ps = null;
		Result rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("    id_horario_caminhao idDiaSemana, ");
		sql.append("    cd_caminhao_logico cdCaminhao, ");
		sql.append("    hr_encerramento_correia hrEncerramentoCorreia ");
		sql.append("from ");
		sql.append("    prddm.dc_horario_caminhao ");
		sql.append("where ");
		sql.append("    cd_empresa= ? ");
		try{
			
		}catch(Exception e){
			throw new Exception("Erro ao buscar o caminhao.");
		}
	}

}
