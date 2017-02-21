package br.com.gam.selecionaromaneio.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.dao.ItemRomaneioDao;
import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.ItemRomaneio;
import br.com.gam.selecionaromaneio.entity.Romaneio;
import br.com.gam.selecionaromaneio.entity.Terminal;

public class ItemRomaneioService {
	private static ItemRomaneioService itemRomaneioService;
	
	private ItemRomaneioService(){}
	
	public static ItemRomaneioService getInstance(){
		if (itemRomaneioService == null){
			itemRomaneioService = new ItemRomaneioService();
		}
		return itemRomaneioService;
	}
	
	public List<ItemRomaneio> buscarItensRomaneio(Connection conn, Empresa empresa,
			List<Terminal> terminais)throws Exception{
		return ItemRomaneioDao.getInstance().buscarItensRomaneio(conn, empresa, terminais);
	}
	
	public List<ItemRomaneio> buscarItensRomaneioPor(Romaneio romaneio, List<ItemRomaneio> itens)
			throws Exception{
		List<ItemRomaneio> itensRomaneio = new ArrayList<ItemRomaneio>();
		for (ItemRomaneio itemRomaneio : itens){
			if ((itemRomaneio.getNumeroRomaneio() == romaneio.getNumero())&&
					(itemRomaneio.getSequenciaRomaneio() == romaneio.getSequencia())){
				itensRomaneio.add(itemRomaneio);
			}
		}
		if (itensRomaneio.size() > 0){
			return itensRomaneio;
		}else{
			throw new Exception("Sem itens para o romaneio"+
				romaneio.getNumero()+"/"+romaneio.getSequencia());
		}
	}

}
