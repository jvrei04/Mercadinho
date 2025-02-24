package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Cliente;

public class ClienteDAO {
	public void create(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("Insert into Cliente values(? , ? , ? , ? , ? , ? , ?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getDataNasc());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getTelefone());
			
			stmt.executeUpdate();
			System.out.println("Cadastro com sucesso!");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
		
	}
	public ArrayList<Cliente> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Cliente");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setDataNasc(rs.getString(4));
				cliente.setEmail(rs.getString(5));
				cliente.setGenero(rs.getString(6));
				cliente.setEndereco(rs.getString(7));
				cliente.setTelefone(rs.getString(8));
				
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	
	
	public void update(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("Update Cliente set nomeCliente = ? , cpfCliente = ?, dataDeNascimento = ?, emailCliente = ?, generoCliente = ?, enderecoCliente = ?, telefoneCliente = ? where idCliente = ? or cpfCliente = ?");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getDataNasc());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getTelefone());
			stmt.setString(8, cliente.getId());
			stmt.setString(9, cliente.getCpf());
			
			
			
			
			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao atualizar! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	
	public void delete(Cliente cliente) {
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

try {
	stmt = con.prepareStatement("delete from Cliente where idCliente = ? or cpfCliente = ?");
	
	stmt.setString(1, cliente.getId());
	stmt.setString(2, cliente.getCpf());
	
	
	
	
	stmt.executeUpdate();
	System.out.println("Excluido com sucesso!");
	

} catch (SQLException e) {
	// TODO Auto-generated catch block
	throw new RuntimeException("Erro ao excluir! ", e );
}finally {
	ConnectionDatabase.closeConnection(con, stmt);
}
}
	public ArrayList<Cliente> search(Cliente cliente1){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Cliente where cpfCliente like ? or nomeCliente like ?");
			stmt.setString(1, "%"+cliente1.getCpf()+"%");
			stmt.setString(2, "%"+cliente1.getNome()+"%");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setDataNasc(rs.getString(4));
				cliente.setEmail(rs.getString(5));
				cliente.setGenero(rs.getString(6));
				cliente.setEndereco(rs.getString(7));
				cliente.setTelefone(rs.getString(8));
				
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
}
