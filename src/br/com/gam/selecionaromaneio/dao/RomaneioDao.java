package br.com.gam.selecionaromaneio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.entity.Caminhao;
import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.Romaneio;

public class RomaneioDao {
	private static RomaneioDao romaneioDao = null;
	
	private RomaneioDao(){}
	
	public static RomaneioDao getInstance(){
		if (romaneioDao==null){
			romaneioDao=new RomaneioDao();
		}
		
		return romaneioDao;
	}

	
	public List<Romaneio> buscarListaRomaneio(Connection conn, Empresa empresa, Caminhao caminhao)
			throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Romaneio> listaRomaneio = new ArrayList<Romaneio>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("    nron_n numero, ");
		sql.append("    seqv_n sequencia, ");
		sql.append("    nrot_n caminhao, ");
		sql.append("    totn_n qtItens ");
		sql.append("from ");
		sql.append("    paulocesar.dcnotd ");
		sql.append("where ");
		sql.append("    cd_empresa = ? ");
		
		try{
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, empresa.getCodigo());
			rs=ps.executeQuery();
			while (rs.next()){
				Romaneio romaneio = new Romaneio();
				romaneio.setNumero(rs.getInt("numero"));
				romaneio.setSequencia(rs.getInt("sequencia"));
				
			}
		}catch(Exception e){
			throw new Exception(e);
		}
	}
}
