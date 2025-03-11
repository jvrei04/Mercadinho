package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.ProdutoDAO;
import Model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    public void initialize(URL arg0, ResourceBundle arg1) {
    	//TODO Auto-generate method stub
    	choiceFormaPGTO.getItems().add("Debito");
    	choiceFormaPGTO.getItems().add("Dinheiro");
    	choiceFormaPGTO.getItems().add("Pix");
    	
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	ArrayList<String> nomesProdutos = new ArrayList<String>();
    	nomesProdutos = produtoDAO.readProdutoByNome();
    	String[] produto = new String [nomesProdutos.size()];
    	
    	for (int i = 0; i < nomesProdutos.size(); i++) {
    		produto[i] = nomesProdutos.get(i);
    	}
    	TextFields.bindAutoCompletion(txtProduto, produto);
}
}
