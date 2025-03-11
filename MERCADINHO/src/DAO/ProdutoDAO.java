package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Produto;

public class ProdutoDAO {
	public void create (Produto produto) {
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("Insert into Produto values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,produto.getIdFornecedor());
			stmt.setString(2,produto.getNome());
			stmt.setString(3, produto.getCodBarra());
			stmt.setString(4, produto.getLote());
			stmt.setString(5,produto.getDataFab());
			stmt.setString(6,produto.getDataVal());
			stmt.setString(7,produto.getMarca());
			stmt.setString(8,produto.getCategoria());
			stmt.setString(9,produto.getUnidadeMedida());
			stmt.setString(10,produto.getPrecoUn());
			stmt.setString(11,produto.getEstoque());
			
			
			
			
			stmt.executeUpdate();
			System.out.println("Cadastro com sucesso!");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
	}
		public void update (Produto produto) {
			Connection con = ConnectionDatabase.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("Update Produto set nome = ?, codBarra = ?, lote = ?,dataFab = ?,dataVal = ?,marca = ?,categoria = ?,unidadeDeMedida = ?,precoUnitario = ?,estoque = ?,where id = ?");
				stmt.setString(1, produto.getNome());
				stmt.setString(2, produto.getCodBarra());
				stmt.setString(3, produto.getLote());
				stmt.setString(4,produto.getDataFab());
				stmt.setString(5,produto.getDataVal());
				stmt.setString(6,produto.getMarca());
				stmt.setString(7,produto.getCategoria());
				stmt.setString(8,produto.getUnidadeMedida());
				stmt.setString(9,produto.getPrecoUn());
				stmt.setString(10,produto.getEstoque());;
				
				stmt.setString(11, produto.getIdProduto());
				
				stmt.executeUpdate();
				System.out.println("Atualizado com sucesso!");
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao atualizar! ", e );
			}finally {
				ConnectionDatabase.closeConnection(con, stmt);
			}
			
		}
			
			
			public void delete(Produto produto) {
				
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from Produto where idProduto = ? ");
			
			stmt.setString(1, produto.getIdProduto());
			
			stmt.executeUpdate();
			System.out.println("Excluido com sucesso!");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao excluir! ", e );
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
		
	}
			public ArrayList<Produto> read(){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Produto> produtos = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Produto");
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						Produto produto = new Produto();
						
						produto.setIdProduto(rs.getString(1));
						produto.setIdFornecedor(rs.getString(2));
						produto.setNome(rs.getString(3));
						produto.setCodBarra(rs.getString(4));
						produto.setLote(rs.getString(5));
						produto.setDataFab(rs.getString(6));
						produto.setDataVal(rs.getString(7));
						produto.setMarca(rs.getString(8));
						produto.setCategoria(rs.getString(9));
						produto.setUnidadeMedida(rs.getString(10));
						produto.setPrecoUn(rs.getString(11));
						produto.setEstoque(rs.getString(12));
						
						
						
						produtos.add(produto);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return produtos;
			}
			
			public ArrayList<Produto> search(Produto produto1){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Produto> produtos = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Produto where idProduto like ? or nome like ?");
					stmt.setString(1, "%"+produto1.getIdProduto()+"%");
					stmt.setString(2, "%"+produto1.getNome()+"%");
					
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						Produto produto = new Produto();
						
						produto.setIdProduto(rs.getString(1));
						produto.setIdFornecedor(rs.getString(2));
						produto.setNome(rs.getString(3));
						produto.setCodBarra(rs.getString(4));
						produto.setLote(rs.getString(5));
						produto.setDataFab(rs.getString(6));
						produto.setDataVal(rs.getString(7));
						produto.setMarca(rs.getString(8));
						produto.setCategoria(rs.getString(9));
						produto.setUnidadeMedida(rs.getString(10));
						produto.setPrecoUn(rs.getString(11));
						produto.setEstoque(rs.getString(12));
						
						
						
						produtos.add(produto);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return produtos;
			}
			public ArrayList<Produto> getByEstoque(){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Produto> produtos = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Produto where estoque < 15");
					rs = stmt.executeQuery();
					
					int i = 1;
					
					while(rs.next()) {
						Produto produto = new Produto();
						
						produto.setIdProduto(""+i);
						produto.setIdFornecedor(rs.getString(2));
						produto.setNome(rs.getString(3));
						produto.setCodBarra(rs.getString(4));
						produto.setLote(rs.getString(5));
						produto.setDataFab(rs.getString(6));
						produto.setDataVal(rs.getString(7));
						produto.setMarca(rs.getString(8));
						produto.setCategoria(rs.getString(9));
						produto.setUnidadeMedida(rs.getString(10));
						produto.setPrecoUn(rs.getString(11));
						produto.setEstoque(rs.getString(12));
						
						i++;
						
						produtos.add(produto);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return produtos;
			}
			public ArrayList<Produto> getByDataVal(){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<Produto> produtos = new ArrayList<>();
				
				try {
					stmt = con.prepareStatement("select * from Produto where datediff (DD, GETDATE(), dataVal) < 60 order by dataVal");
					rs = stmt.executeQuery();
					
					int i = 1;
					
					while(rs.next()) {
						Produto produto = new Produto();
						
						produto.setIdProduto(""+i);
						produto.setIdFornecedor(rs.getString(2));
						produto.setNome(rs.getString(3));
						produto.setCodBarra(rs.getString(4));
						produto.setLote(rs.getString(5));
						produto.setDataFab(rs.getString(6));
						produto.setDataVal(rs.getString(7));
						produto.setMarca(rs.getString(8));
						produto.setCategoria(rs.getString(9));
						produto.setUnidadeMedida(rs.getString(10));
						produto.setPrecoUn(rs.getString(11));
						produto.setEstoque(rs.getString(12));
						
						i++;
						
						produtos.add(produto);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException("Erro ao ler informações!", e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return produtos;
			}
			
			public ArrayList<String> readProdutoByNome(){
				Connection con = ConnectionDatabase.getConnection();
				PreparedStatement stmt = null;
				ResultSet rs = null;
				ArrayList<String> produtos = new ArrayList<>();
				try {
					stmt = con.prepareStatement("SELECT nome FROM Produto");
					rs = stmt.executeQuery();
					
					while (rs.next()) {
						String nome;
						nome = rs.getString(1);
						produtos.add(nome);
					}
				} catch (SQLException e) {
					throw new RuntimeException("Erro ao ler os produtos!",e);
				}finally {
					ConnectionDatabase.closeConnection(con, stmt, rs);
				}
				return produtos;
			}
}
