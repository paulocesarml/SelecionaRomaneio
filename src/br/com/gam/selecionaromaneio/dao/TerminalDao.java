package br.com.gam.selecionaromaneio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.Terminal;

public class TerminalDao {
	private static TerminalDao terminalDao;
	
	private TerminalDao(){}
	
	public static TerminalDao getInstance(){
		if (terminalDao == null){
			terminalDao = new TerminalDao();
		}
		return terminalDao;
	}
	
	public List<Terminal> buscarListaTerminal(Connection conn, Empresa empresa)
			throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Terminal> listaTerminal = new ArrayList<Terminal>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("    cd_rom_terminal cdRomTerminal, ");
		sql.append("    nr_caixa_fila_separacao nrCaixaFilaSeparacao ");
		sql.append("from ");
		sql.append("    paulocesar.dc_rom_terminal ");
		sql.append("where ");
		sql.append("    cd_empresa = ? ");
		
		try{
			ps=conn.prepareStatement(sql.toString());
			ps.setInt(1, empresa.getCodigo());
			rs=ps.executeQuery();
			while (rs.next()){
				Terminal terminal = new Terminal();
				terminal.setCodigo(rs.getInt("cdRomTerminal"));
				terminal.setQantidadeMaxBuffer(rs.getInt("nrCaixaFilaSeparacao"));
				
				listaTerminal.add(terminal);
			}
			
			return listaTerminal;
		}catch(Exception e){
			throw new Exception(e);
		}
	}
}
