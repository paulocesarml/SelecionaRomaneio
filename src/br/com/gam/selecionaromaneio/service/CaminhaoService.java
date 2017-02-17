package br.com.gam.selecionaromaneio.service;

import java.util.ArrayList;
import java.util.List;

import br.com.gam.selecionaromaneio.dao.CaminhaoDao;
import br.com.gam.selecionaromaneio.entity.Caminhao;

public class CaminhaoService {
	private static CaminhaoService caminhaoService = null;
	
	private CaminhaoService(){
		listaCaminhao = CaminhaoDao.getInstance().buscarListaCaminhao(conn, empresa);
	}
	
	private List<Caminhao> listaCaminhao = new ArrayList<Caminhao>();
	
	public static CaminhaoService getInstance(){
		if (caminhaoService==null){
			caminhaoService=new CaminhaoService();
		}
		return caminhaoService;
	}
	
	public Caminhao buscarCaminhaoPor(int numeroCaminhao)
			throws Exception{
		for (Caminhao caminhao : listaCaminhao){
			if (caminhao.getCodigo() == numeroCaminhao){
				return caminhao;
			}
		}
		throw new Exception("Caminhao nao esta na lista");
	}

}
