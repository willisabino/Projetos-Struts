package bra.com.maon;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Main {

	public static final String relatorio = "relatorio/teste01.jrxml";
	
	public static void main(String[] args) throws JRException {
		relatorio();
	}
	
	public static void relatorio() throws JRException {
		
		JasperReport compilado = JasperCompileManager.compileReport(relatorio);
		
		//Primeiro Relatorio compilo; Segundo é um hashmap; terceiro Conexao com o banco, se necessário
		JasperPrint print = JasperFillManager.fillReport(compilado, null, new JREmptyDataSource());
		
		JasperViewer.viewReport(print, true);
		
	}

}
