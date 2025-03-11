package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import DAO.ProdutoDAO;

import DAO.VendaDAO;
import Model.Cliente;
import Model.Fornecedor;
import Model.Produto;

import Model.Venda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private static Stage stage;
	private static Scene Login;
	private static Scene main;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			primaryStage.setTitle("Mercadinho - Login");
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/View/viewLogin.fxml"));
			Login = new Scene(fxmlLogin);
			
			
			//Parent fxmlMain = FXMLLoader.load(getClass().getResource("/View/viewMain.fxml"));
			//main = new Scene(fxmlMain);
			
			stage.getIcons().add(new Image (getClass().getResourceAsStream("/Icons/images.png")));
			
			
			
			primaryStage.setScene(Login);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScreen(String tela) {
		if(tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
			stage.setTitle("Menu pricipal");
		}else if(tela.equals("login")) {
			stage.setScene(Login);
			stage.centerOnScreen();
			stage.setTitle("Mercadinho - Login");
		}
	}
	
	public static void TelaHome() throws IOException {
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/View/viewMain.fxml"));
		Parent TelaHome = fxmlHome.load();
		main = new Scene(TelaHome);
		
		
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	public static void TelaCliente() throws IOException {
		FXMLLoader fxmlCliente = new FXMLLoader();
		fxmlCliente.setLocation(Main.class.getResource("/View/viewCliente.fxml"));
		Parent TelaCliente = fxmlCliente.load();
		main = new Scene(TelaCliente);
		
		
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
		}
	
	private static Stage cadCliente;
	public static void TelaCadastroCliente()throws IOException{
		FXMLLoader fxmlCadastroCliente = new FXMLLoader();
		fxmlCadastroCliente.setLocation(Main.class.getResource("/View/viewCadastroCliente.fxml"));
		Parent cadastroCliente = fxmlCadastroCliente.load();
		Scene scene2 = new Scene(cadastroCliente);
		
		
		cadCliente = new Stage();
		cadCliente.setTitle("Register/Edit Customers");
		cadCliente.initModality(Modality.WINDOW_MODAL);
		cadCliente.setScene(scene2);
		cadCliente.centerOnScreen();
		cadCliente.showAndWait();		
		
	}
	private static Stage venda;
	public static void TelaRegistroVenda()throws IOException{
		FXMLLoader fxmlRegistrarVenda = new FXMLLoader();
		fxmlRegistrarVenda.setLocation(Main.class.getResource("/View/viewRegistrarVenda.fxml"));
		Parent registrarVenda = fxmlRegistrarVenda.load();
		Scene scene2 = new Scene(registrarVenda);
		
		
		venda = new Stage();
		venda.setTitle("Customer registration/editing");
		venda.initModality(Modality.WINDOW_MODAL);
		venda.setScene(scene2);
		venda.centerOnScreen();
		venda.showAndWait();		
		
	}

	
	public static void main(String[] args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		
		
//   metodo de pesquisa 
		
	Cliente cliente = new Cliente();
	ClienteDAO clienteDAO = new ClienteDAO();
	ArrayList <Cliente> clientes = new ArrayList<>();
	cliente.setCpf("12345678901");
	clientes.addAll(clienteDAO.search(cliente));
	
		
	for (int i = 0 ; i < clientes.size(); i++) {
		cliente = clientes.get(i);
		System.out.println("");
		System.out.println(cliente.getId()+ "|");
		System.out.println(cliente.getNome()+ "|");
		System.out.println(cliente.getDataNasc()+ "|");
		System.out.println(cliente.getEmail()+ "|");
		System.out.println(cliente.getEndereco()+ "|");
		System.out.println(cliente.getGenero()+ "|");
		System.out.println(cliente.getTelefone()+ "|");
	}							
  launch(args);
	}
}


