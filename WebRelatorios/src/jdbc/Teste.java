package jdbc;

public class Teste {
	public static void main(String[] args) {
		ConnectionFactory con = new ConnectionFactory();
		con.getConnection();
		System.out.println("Conectado");
	}
}
