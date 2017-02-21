package br.com.gam.selecionaromaneio.service;

import java.sql.Connection;
import java.util.List;

import br.com.gam.selecionaromaneio.dao.RomaneioDao;
import br.com.gam.selecionaromaneio.entity.Caminhao;
import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.ItemRomaneio;
import br.com.gam.selecionaromaneio.entity.Romaneio;
import br.com.gam.selecionaromaneio.entity.Terminal;

public class RomaneioService {
	private static RomaneioService romaneioService;
	
	private RomaneioService(){}
	
	public static RomaneioService getInstance(){
		if (romaneioService == null){
			romaneioService = new RomaneioService();
		}
		return romaneioService;
	}
	
	public List<Romaneio> buscarListaRomaneio(Connection conn, Empresa empresa, 
			List<Caminhao> caminhao, List<Terminal> terminais, List<ItemRomaneio> itensRomaneio) throws Exception{
		return RomaneioDao.getInstance().buscarListaRomaneio(conn, empresa, caminhao, terminais, itensRomaneio);
	}
}
