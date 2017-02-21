package br.com.gam.selecionaromaneio.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.dao.TerminalDao;
import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.entity.ItemRomaneio;
import br.com.gam.selecionaromaneio.entity.Romaneio;
import br.com.gam.selecionaromaneio.entity.Terminal;

public class TerminalService {
	private static TerminalService terminalService;
	
	private TerminalService(){}
	
	public static TerminalService getInstance(){
		if (terminalService == null){
			terminalService = new TerminalService();
		}
		return terminalService;
	}
	
	public List<Terminal> buscarListaTerminal(Connection conn, Empresa empresa)
			throws Exception{
		return TerminalDao.getInstance().buscarListaTerminal(conn, empresa);
	}
	

	public Terminal buscarTerminalPor(int numeroTerminal, List<Terminal> terminais)
			throws Exception{
		for (Terminal terminal : terminais){
			if (terminal.getCodigo() == numeroTerminal){
				return terminal;
			}
		}
		throw new Exception("Terminal nao esta na lista");
	}

	public List<Terminal> buscarTerminaisPor(Romaneio romaneio)
			throws Exception{
		List<Terminal> terminais = new ArrayList<Terminal>();
		for (ItemRomaneio itemRomaneio : romaneio.getItensRomaneio()){
			terminais.add(itemRomaneio.getTerminal());
		}
		if (terminais.size() > 0){
			return terminais;
		}else{
			throw new Exception("Nenhum terminal para o romaneio.");
		}
	}
}
