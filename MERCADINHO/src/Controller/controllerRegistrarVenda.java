package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import Model.Cliente;
import Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class controllerRegistrarVenda implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btRegistrar;

    @FXML
    private ChoiceBox<String> choiceFormaPGTO;

    @FXML
    private TableColumn<Produto, String> columnIndice;

    @FXML
    private TableColumn<Produto, String> columnNome;

    @FXML
    private TableColumn<Produto, String> columnPrecoTotal;

    @FXML
    private TableColumn<Produto, String> columnPrecoUn;

    @FXML
    private TableColumn<Produto, String> columnQuantidade;

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDesconto;

    @FXML
    private TextField txtPrecoUN;

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtTipoUN;

    @FXML
    private TextField txtValorTotal;

    @FXML
    private TextField txtVendedor;

    @FXML
    void actionCadastrar(ActionEvent event) {

    }

    @FXML
    void actionCancelar(ActionEvent event) {

    }

    @FXML
    void actionCPFclick(MouseEvent event) {
    	if(txtCliente.getText().length() > 3) {
    		ClienteDAO clienteDAO = new ClienteDAO();
    		Cliente cliente = new Cliente ();
    		cliente.setNome(txtCliente.getText());
    		ArrayList<Cliente> clientes = new ArrayList<>();
    		clientes = clienteDAO.search(cliente);
    		cliente = clientes.get(0);
    		txtCPF.setText(cliente.getCpf());
    	}
    }

    @FXML
    void actionCPFtype(KeyEvent event) {
    	if(txtCliente.getText().length() > 3) {
    		ClienteDAO clienteDAO = new ClienteDAO();
    		Cliente cliente = new Cliente ();
    		cliente.setNome(txtCliente.getText());
    		ArrayList<Cliente> clientes = new ArrayList<>();
    		clientes = clienteDAO.search(cliente);
    		cliente = clientes.get(0);
    		txtCPF.setText(cliente.getCpf());
    	}else {
    		txtCPF.setText(null);
    	}
    }
    @FXML
    void actionProdutoClick(MouseEvent event) {
    	if(txtProduto.getText().length() > 3) {
    		ProdutoDAO produtoDAO = new ProdutoDAO();
    		Produto produto = new Produto ();
    		produto.setNome(txtProduto.getText());
    		ArrayList<Produto> produtos = new ArrayList<>();
    		produtos = produtoDAO.search(produto);
    		produto = produtos.get(0);
    		txtCodigo.setText(produto.getCodBarra());
    		
    		
    		String precoUn;
    		precoUn = produto.getPrecoUn();
    		double valorTotal = Double.parseDouble(precoUn);
    		precoUn = String.format("%.2f" , valorTotal);
    		txtPrecoUN.setText("R$ " + precoUn);
    	}
    }

    @FXML
    void actionProdutoType(KeyEvent event) {
    	if(txtProduto.getText().length() > 3) {
    		ProdutoDAO produtoDAO = new ProdutoDAO();
    		Produto produto = new Produto ();
    		produto.setNome(txtProduto.getText());
    		ArrayList<Produto> produtos = new ArrayList<>();
    		produtos = produtoDAO.search(produto);
    		produto = produtos.get(0);
    		txtCodigo.setText(produto.getCodBarra());
    	
    		String precoUn;
    		precoUn = produto.getPrecoUn();
    		double valorTotal = Double.parseDouble(precoUn);
    		precoUn = String.format("%.2f" , valorTotal);
    		txtPrecoUN.setText("R$ " + precoUn);
    	}else {
    		txtCodigo.setText(null);
    	}
    }
    
    

    public void initialize(URL arg0, ResourceBundle arg1) {
    	//TODO Auto-generate method stub
    	choiceFormaPGTO.getItems().add("Debito");
    	choiceFormaPGTO.getItems().add("Dinheiro");
    	choiceFormaPGTO.getItems().add("Pix");
    	txtVendedor.setText(controllerLogin.funcionario.getNome());
    	
    	
    	
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	ArrayList<String> nomesProdutos = new ArrayList<String>();
    	nomesProdutos = produtoDAO.readProdutoByNome();
    	String[] produto = new String [nomesProdutos.size()];
    	
    	for (int i = 0; i < nomesProdutos.size(); i++) {
    		produto[i] = nomesProdutos.get(i);
    	}
    	TextFields.bindAutoCompletion(txtProduto, produto);
    	
    	
    	ClienteDAO clienteDAO = new ClienteDAO();
    	ArrayList<String> nomeCliente = new ArrayList<String>();
    	nomeCliente = clienteDAO.readClienteByNome();
    	String[] cliente = new String [nomeCliente.size()];
    	
    	for (int i = 0; i < nomeCliente.size(); i++) {
    		cliente[i] = nomeCliente.get(i);
    	}
    	TextFields.bindAutoCompletion(txtCliente, cliente);
    	
    	
    	
    	
}
}
