package util;

import java.io.IOException;
import java.sql.Date;

//import java.util.ArrayList;
//import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import modelo.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import dao.ClienteDao;


public class JasperUtil {
//	C:\Users\Marcio\Documents\Projetos\relatorios
//	C:\Users\Marcio\git\WebRelatoriosLocalRep\WebRelatorios\src\relatorios
	private String pathFile = "C:\\Users\\Marcio\\Documents\\Projetos\\relatorios\\";
	private String sourceFileName = pathFile+"novoRelatorio.jrxml";
	private String sourceFileName2 = pathFile+"novoRelatorio.jasper";
	//private String sourceFileName3 = pathFile+"novoRelatorio.jrxml";
	//private String sourceFileName = "C:\\Users\\Marcio\\Documents\\Projetos\\WebRelatorios\\src\\relatorios\\relatorio1.jrxml";
	//private String sourceFileName2 = "C:\\Users\\Marcio\\Documents\\Projetos\\WebRelatorios\\src\\relatorios\\relatorio1.jasper";
	//private String sourceFileName3 = "C:\\Users\\Marcio\\Documents\\Projetos\\WebRelatorios\\src\\relatorios\\relatorio1.jrprint";

	
	public void compilaRelatorio(){
		System.out.println("Compilando relatorio...");
		try {
			//1 Passo - Compilar o arquivo xml em um jasper
			JasperCompileManager.compileReportToFile(sourceFileName);
			System.out.println("Compilação concluída!!! ...");			
		} catch (JRException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void preencheRelatorio(HttpServletRequest request, HttpServletResponse response, String dataInicial, String dataFinal){
		//Cria um novo clienteDao, gerando uma conexão automatica
		ClienteDao cliDao = new ClienteDao();
		
		//Cria o dataSourse para o jasper
	    List<Cliente> dataList = cliDao.listar(dataInicial, dataFinal);
	    
	    //passa o datarSorce 
	    JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(dataList);		
		Map parameters = new HashMap();
	      try {
	    	 //Transforma em pdf  
	    	 byte[] pessoa = JasperRunManager.runReportToPdf(sourceFileName2, parameters, beanDataSource); 
	    	 JasperFillManager.fillReportToFile(sourceFileName2, parameters, beanDataSource);
	         mostrarRelatorio(pessoa, response);
	     
	      } catch (JRException e) {
	         System.out.println(e.getMessage());
	      }
	}
	

	public void mostrarRelatorio(byte[] relatorio, HttpServletResponse response){
		try {
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			out.write(relatorio);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private Date converteData(Date data){
		return new java.sql.Date(data.getTime());		
	}
}
