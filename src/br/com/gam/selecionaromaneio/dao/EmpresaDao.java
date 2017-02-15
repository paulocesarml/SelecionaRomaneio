package br.com.gam.selecionaromaneio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.gam.selecionaromaneio.entity.Empresa;

public class EmpresaDao {
	
	private static EmpresaDao empresaDao;
	
	private EmpresaDao(){}
	
	public static EmpresaDao getInstance(){
		if (empresaDao == null){
			empresaDao = new  EmpresaDao();
		}
		return empresaDao;
	}
	
	public Empresa buscarEmpresa(Connection conn)
			throws Exception{
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		
		
		
	}
	
}
