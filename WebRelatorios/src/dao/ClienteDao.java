package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.ConnectionFactory;

import modelo.Cliente;

public class ClienteDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ClienteDao(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
	
	public List<Cliente> listar(String dataInicial, String dataFinal){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date dataI = null; 
		java.sql.Date dataF = null;
		List<Cliente> cliente = new ArrayList<Cliente>();
		String query = "select * from clientes where data_cadastro  between ? and ? ";
		
		try {
			int index = 0;
			pstmt = conn.prepareStatement(query);
			try {
				pstmt.setDate(++index, dataI = new java.sql.Date(format.parse(dataInicial).getTime()) );
				pstmt.setDate(++index, dataF = new java.sql.Date(format.parse(dataFinal).getTime()) );
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int columnIndex=0;
				Cliente cli = new Cliente();
				int id_Cliente = rs.getInt(++columnIndex);
				String name = rs.getString(++columnIndex);
				Date data_cadastro = rs.getDate(++columnIndex);
				
				
				//Preenche o cliente
				cli.setCodigo(id_Cliente);
				cli.setNome(name);
				cli.setDataCadastro(data_cadastro);
				
				//Adiciona
				cliente.add(cli);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
		
		return cliente;
	}
	
}
