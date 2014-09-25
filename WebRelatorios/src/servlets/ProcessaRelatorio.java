package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JasperUtil;
import dao.ClienteDao;

/**
 * Servlet implementation class ProcessaRelatorio
 */
public class ProcessaRelatorio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ProcessaRelatorio() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet executada");
		
		//Compila o arquivo jrxml para gerar jasper
		new JasperUtil().compilaRelatorio();
		
				
		//captura os dados da tela
		String dataInicial = request.getParameter("dataInicial");
		String dataFinal = request.getParameter("dataFinal");
		
		//Passa os parâmetros para o método gerar o pdf
		new JasperUtil().preencheRelatorio(request, response, dataInicial, dataFinal);		
		
	}

}
