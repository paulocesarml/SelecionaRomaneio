package br.com.gam.selecionaromaneio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.enuns.EIdDiaSemana;

public class EmpresaDao {
	
	private static EmpresaDao empresaDao;
	
	private EmpresaDao(){}
	
	public static EmpresaDao getInstance(){
		if (empresaDao == null){
			empresaDao = new  EmpresaDao();
		}
		return empresaDao;
	}
	
	public Empresa buscarEmpresa(Connection conn, Empresa empresa)
			throws Exception{
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("select ");
		sql.append("    cd_empresa cdEmpresa, ");
		sql.append("    nm_empresa nmEmpresa, ");
		sql.append("    id_horario idDiaSemana ");
		sql.append("from ");
		sql.append("    acesso.dc_empresa ");
		sql.append("where ");
		sql.append("    cd_empresa = ? ");
		
		try{
			
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, empresa.getCodigo());
			rs = ps.executeQuery();
			
			if (rs.next()){
				empresa.setCodigo(rs.getInt("cdEmpresa"));
				empresa.setNome(rs.getString("nmEmpresa"));
				empresa.setIdDiaSemana(EIdDiaSemana.valueOf(rs.getString("idDiasemana")));
			}else{
				throw new Exception("Não foi possível trazer empresa do banco.");
			}
			
			return empresa;
		}catch(Exception e){
			throw new Exception(e);
		}
	}	
}
