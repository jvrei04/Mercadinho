package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import DAO.ProdutoVendaDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Produto;
import Model.ProdutoVenda;
import Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private TableColumn<Produto, String> columnProduto;

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

    
    private static Produto produtoVenda = new Produto ();
    double totalVenda;
    double desconto;
    
    private ArrayList<Produto> ArrayProdutos = new ArrayList<>();
    @FXML
    void actionCadastrar(ActionEvent event) {
    	 
    	    	Venda venda = new Venda();
    	    	VendaDAO vendaDAO = new VendaDAO();
    	    	Cliente cliente = new Cliente();
    	    	ClienteDAO clienteDAO = new ClienteDAO();
    	    	Produto produto = new Produto();
    	    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	    	ProdutoVenda produtoVenda = new ProdutoVenda();
    	    	ProdutoVendaDAO produtoVendaDAO = new ProdutoVendaDAO();
    	    	ArrayList<Cliente> clientes = new ArrayList<>();
    	    	ArrayList<Produto> produtos = new ArrayList<>();
    	    	
    	    	cliente.setCpf(txtCPF.getText());
    	    	clientes = clienteDAO.search(cliente);
    	    	cliente = clientes.get(0);
    	    	
    	    	
    	    	venda.setIdFuncionario(controllerLogin.funcionario.getId());
    	    	venda.setIdCliente(cliente.getId());
    	    	venda.setFormaPagamento(choiceFormaPGTO.getValue().toString());
    	    	venda.setDesconto(""+ desconto);
    	    	venda.setPrecoTotal(txtValorTotal.getText());
    	    	vendaDAO.create(venda);
    	    	
    	    	
    	    	for (int i = 0; i <ArrayProdutos.size();i++) {
    	    		String idProduto;
    	    	produto = ArrayProdutos.get(i);
    	    	produtos = produtoDAO.search(produto);
    	    	produto = produtos.get(0);
    	    	idProduto = produto.getIdProduto();
    	    	produto = ArrayProdutos.get(i);
    	    	produto.setIdProduto(idProduto);
    	    	produtoVenda.setIdproduto(idProduto);
    	    	produtoVenda.setQuantidade(produto.getEstoque());
    	    	
    	    	produtoVenda.setIdvenda(vendaDAO.readId());
    	    	produtoVendaDAO.create(produtoVenda);
    	    	
    	    	
    	        
    	         txtCliente.setText(null);
    	         txtCPF.setText(null);
    	          txtProduto.setText(null);
    	           txtCodigo.setText(null);
    	           txtPrecoUN.setText(null);
    	           txtValorTotal.setText(null);
    	             txtDesconto.setText(null);
    	             txtQuantidade.setText(null);
    	             txtValorTotal.setText(null);
    	    }
    	    	ArrayProdutos = null;
    	    }
    

    @FXML
    void actionAdicionar(ActionEvent event) {
    	produtoVenda.setNome(txtProduto.getText());
    	produtoVenda.setEstoque(txtQuantidade.getText());
    	produtoVenda.setPrecoUn(txtPrecoUN.getText());
    	produtoVenda.setPrecoUn(txtValorTotal.getText());
    	produtoVenda.setIdProduto(""+ ArrayProdutos.size());
    	String valor = txtValorTotal.getText();
    	valor = valor.replace(",",".");
    	double precoTotal = Double.parseDouble(valor);
    	
    	totalVenda = totalVenda + precoTotal;
    	valor = String.format("%.2f", totalVenda);
    	txtValorTotal.setText(valor);
    	
    	
    	valor = txtDesconto.getText();
    	valor = valor.replace(",",".");
    	double valordesconto = Double.parseDouble(valor);
    	desconto = desconto + valordesconto;
    	
    	
    	
    	ArrayProdutos.add(produtoVenda);
    	
    	carregarTableProdutos(ArrayProdutos);
    	

    }
    
    @FXML
    void actionCancelar(ActionEvent event) {
    	txtCliente.setText("");
 	   txtCPF.setText("");
 	   txtVendedor.setText("");
 	    txtProduto.setText("");
 	     txtCodigo.setText("");
 	     txtPrecoUN.setText("");
 	      txtValorTotal.setText("");
 	    txtDesconto.setText("");
 	      txtQuantidade.setText("");        
 	     txtValorTotal.setText("");
 	      choiceFormaPGTO.setValue(null);
 	    	Stage stage = (Stage) btCancelar.getScene().getWindow();
 	   	stage.close();
 	   
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
    @FXML
    void actionDesconto(KeyEvent event) {
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto.setNome(txtProduto.getText());
    	ArrayList<Produto> produtos = new ArrayList<>();
    	produtos = produtoDAO.search(produto);
    	produto = produtos.get(0);
    	double quantidade = Double.parseDouble(txtQuantidade.getText());
    	double precoUN = Double.parseDouble(produto.getPrecoUn()) ;
    	
    	if(quantidade >= 15) {
    		double desconto = (precoUN * quantidade) * 0.05;
    		double precoTotal = precoUN * quantidade - desconto;
    		txtDesconto.setText(""+ String.format("%.2f", desconto));
    		txtValorTotal.setText(""+ String.format("%.2f", desconto));
    	}else if(quantidade < 15) {
    		double precoTotal = precoUN * quantidade;
    		txtDesconto.setText("0,00");
    		txtValorTotal.setText(""+ String.format("%.2f", precoTotal));
    	
    	}
    	else{
    		txtValorTotal.setText(null);
    		txtDesconto.setText(null);
    		txtValorTotal.setText(null);
    		
    	}
    	}
    
    private void carregarTableProdutos(ArrayList<Produto> ArrayProdutos) {
    	ObservableList <Produto> produtosVendidos = FXCollections.observableArrayList(ArrayProdutos);
    	
    	columnIndice.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
    	columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
    	
    	tableProdutos.setItems(produtosVendidos);
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
