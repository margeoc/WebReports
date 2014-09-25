package testes;
import java.util.ArrayList;
import java.util.Date;

import modelo.Cliente;



public class ListaClientes {
	public ArrayList<Cliente> getLista() {
	      ArrayList<Cliente> dataBeanList = new ArrayList<Cliente>();

	      dataBeanList.add(produce(1, "Andre", new java.util.Date()));
	      dataBeanList.add(produce(2, "sdf", new java.util.Date()));
	      dataBeanList.add(produce(3, "safas", new java.util.Date()));
	      dataBeanList.add(produce(4, "wrwer", new java.util.Date()));
	      dataBeanList.add(produce(5, "dfgdd", new java.util.Date()));
	      

	      return dataBeanList;
	   }

	   /**
	    * This method returns a DataBean object,
	    * with name and country set in it.
	    */
	   private Cliente produce(int codigo, String nome, Date data) {
		   Cliente cli = new Cliente();
	       cli.setCodigo(codigo);
	       cli.setNome(nome);
	       cli.setDataCadastro(data);	      
	      return cli;
	   }
}
