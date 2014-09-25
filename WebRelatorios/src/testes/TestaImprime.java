package testes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Cliente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestaImprime {
	public static void main(String[] args) {
		String sourceFileName3 = "C:\\Users\\Marcio\\Documents\\Projetos\\WebRelatorios\\src\\relatorios\\relatorio1.jrprint";

		
		ListaClientes cliList = new ListaClientes();
	    List<Cliente> dataList = cliList.getLista();

	    JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

	    Map parameters = new HashMap();
	    try {
	    	JasperFillManager.fillReportToFile(sourceFileName3, parameters, beanColDataSource);
	    } catch (JRException e) {
	         e.printStackTrace();
	    }
	  }
		
}
