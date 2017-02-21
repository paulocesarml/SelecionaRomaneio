package br.com.gam.selecionaromaneio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.ItemRomaneio;
import br.com.gam.selecionaromaneio.entity.Terminal;
import br.com.gam.selecionaromaneio.service.TerminalService;

public class ItemRomaneioDao {
	private static ItemRomaneioDao itemRomaneioDao;
	
	private ItemRomaneioDao(){}
	
	public static ItemRomaneioDao getInstance(){
		if (itemRomaneioDao == null){
			itemRomaneioDao = new ItemRomaneioDao();
		}
		return itemRomaneioDao;
	}
	
	public List<ItemRomaneio> buscarItensRomaneio(Connection conn, Empresa empresa,
			List<Terminal> terminais)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemRomaneio> itensRomaneio = new ArrayList<ItemRomaneio>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ");
		sql.append("    nron_i numero, ");
		sql.append("    seqv_i sequencia, ");
		sql.append("    quai_i unidades, ");
		sql.append("    cd_rom_terminal numeroTerminal ");
		sql.append("from ");
		sql.append("    paulocesar.dciosd ");
		sql.append("where ");
		sql.append("    cd_empresa = ? ");
		sql.append("and tipn_i = 'V' ");
		sql.append("and tipv_i = 1 ");
		
		try{
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, empresa.getCodigo());
			rs = ps.executeQuery();
			while (rs.next()){
				ItemRomaneio itemRomaneio = new ItemRomaneio();
				itemRomaneio.setNumeroRomaneio(rs.getInt("numero"));
				itemRomaneio.setSequenciaRomaneio(rs.getInt("sequencia"));
				itemRomaneio.setQuantidadeUnidades(rs.getInt("unidades"));
				itemRomaneio.setTerminal(
						TerminalService.getInstance().buscarTerminalPor(rs.getInt("numeroTerminal"), terminais));
				
				itensRomaneio.add(itemRomaneio);
			}
			return itensRomaneio;
		}catch(Exception e){
			throw new Exception(e);
		}
	}
}
