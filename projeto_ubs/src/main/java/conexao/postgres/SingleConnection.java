package conexao.postgres;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5433/projetoubs";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection conexao = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar(){
		try {
			if(conexao == null) {
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, user, password);
				conexao.setAutoCommit(false);
				System.out.println("conectou");
			}else{
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conexao;
	}
}
