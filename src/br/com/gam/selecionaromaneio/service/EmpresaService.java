package br.com.gam.selecionaromaneio.service;

import java.sql.Connection;

import br.com.gam.selecionaromaneio.dao.EmpresaDao;
import br.com.gam.selecionaromaneio.entity.Empresa;

public class EmpresaService {
	private static EmpresaService empresaService;
	
	private EmpresaService(){}
	
	public static EmpresaService getInstance(){
		if (empresaService == null){
			empresaService = new EmpresaService();
		}
		return empresaService;
	}
	
	public Empresa buscarEmpresa(Connection conn, Empresa empresa)
			throws Exception{
		return EmpresaDao.getInstance().buscarEmpresa(conn, empresa);
	}
	
	

}
