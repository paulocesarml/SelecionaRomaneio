package br.com.gam.selecionaromaneio.view;

import br.com.gam.dataBase.dao.DataBase;
import br.com.gam.selecionaromaneio.entity.Empresa;
import br.com.gam.selecionaromaneio.service.EmpresaService;
import javafx.application.Application;
import javafx.stage.Stage;

public class Princpal extends Application{
	
	private static Empresa empresa;
	private static DataBase dataBase;

	public static void main(String[] args) {		
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		empresa = new Empresa();
		empresa.setCodigo(1);
		dataBase = new DataBase("1");
		empresa = EmpresaService.getInstance().buscarEmpresa(dataBase.getConnection(), empresa);	
	}
	

}
