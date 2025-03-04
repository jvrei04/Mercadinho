package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDatabase {
	private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:63471;encrypt=false;databaseName=Mercadinho;user=sa;password=Senailab05";
	private static final String user = "Sa";
	private static final String password = "Senailab05";
	
	/**
	 * Método responsável por conectar ao banco de dados.
	 * 
	 * @return - Sem retorno	
	 * 
	 * 
	 */
	
	public static Connection getConnection() {
		try {
			Class.forName(Driver);
			System.out.println("Conexao bem sucedida!");
			return DriverManager.getConnection(URL, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao conectar!",e);
		}
		
		
		
		
	}
	/**
	 * Método responsável por fechar a conexão com o banco de dados.
	 * @param con - Objeto do tipo Connection que será fechado.
	 * @param stmt - Objeto do tipo PreparedStatement que será fechado.
	 */
	public static void closeConnection(Connection con) {
		
			try {
				if (con != null) {
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			System.out.println("Conexao fechada!");
	}
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		
		closeConnection(con);
		
			try {
				if(stmt != null) {
				stmt.close();
				} 
				}
				 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	/**
	 * Método responsável por fechar a conexão com o banco de dados.
	 * @param con - Objeto do tipo Connection que será fechado.
	 * @param stmt - Objeto do tipo PreparedStatement que será fechado.
	 * @param rs - Objeto do tipo ResultSet que será fechado.
	 */
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		
		closeConnection(con, stmt);
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}
}
