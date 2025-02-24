package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Venda;

public class VendaDAO {
	
	public void create (Venda venda) {
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Insert into Venda values(? , ? , ? , ?, ?,?)");
			
			stmt.setString(1,venda.getIdCliente());
			stmt.setString(2, venda.getIdFuncionario());
			stmt.setString(3, venda.getFormaPagamento());
			stmt.setString(4,venda.getDesconto());
			stmt.setString(5,venda.getDataVenda());
			stmt.setString(6,venda.getPrecoTotal());
			
			stmt.executeUpdate();
			System.out.println("Cadastro com sucesso!");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
	}
		public void update (Venda venda) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("Update Venda set FK_idCliente = ?, FK_idFuncionario = ?, formaDePagamento = ?, desconto = ?, dataVenda = ?, precoTotal = ? where idVenda = ?");
				stmt.setString(1, venda.getIdCliente());
				stmt.setString(2, venda.getIdFuncionario());
				stmt.setString(3, venda.getFormaPagamento());
				stmt.setString(4, venda.getDesconto());					
				stmt.setString(5, venda.getDataVenda());
				stmt.setString(6, venda.getPrecoTotal());
				
				stmt.setString(7, venda.getId());
				
				
				stmt.executeUpdate();
				System.out.println("Atualizado com sucesso!");
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao atualizar! ", e );
			}finally {
				ConnectionDatabase.closeConnection(con, stmt);
			}
			
		}
			
			
			public void delete(Venda venda) {
				
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from Venda where idVenda = ?");
			
			stmt.setString(1, venda.getId());
			
			
			
			
			
			stmt.executeUpdate();
			System.out.println("Excluido com sucesso!");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao excluir! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
	}
			public ArrayList<Venda> read(){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Venda> vendas = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Venda");
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						Venda venda = new Venda();
						
						venda.setId(rs.getString(1));
						venda.setIdCliente(rs.getString(2));
						venda.setIdFuncionario(rs.getString(3));
						venda.setFormaPagamento(rs.getString(4));
						venda.setDesconto(rs.getString(5));
						venda.setDataVenda(rs.getString(6));
						venda.setPrecoTotal(rs.getString(7));
						
						
						
						
						vendas.add(venda);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return vendas;
			}
			
			public ArrayList<Venda> search(Venda venda1){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Venda> vendas = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Venda where formaDePagamento like ? or idVenda like ?");
					stmt.setString(1, "%"+venda1.getFormaPagamento()+"%");
					stmt.setString(2, "%"+venda1.getId()+"%");
					
					
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						Venda venda = new Venda();
						
						venda.setId(rs.getString(1));
						venda.setIdCliente(rs.getString(2));
						venda.setIdFuncionario(rs.getString(3));
						venda.setFormaPagamento(rs.getString(4));
						venda.setDesconto(rs.getString(5));
						venda.setDataVenda(rs.getString(6));
						venda.setPrecoTotal(rs.getString(7));
						
						
						
						vendas.add(venda);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return vendas;
			}
	
	
}
