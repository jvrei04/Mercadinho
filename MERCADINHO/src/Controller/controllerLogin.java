package Controller;

import java.io.IOException;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import Util.Alerts;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class controllerLogin {

	@FXML
	private Button btLogin;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUser;
	
	 public static Funcionario funcionario = new Funcionario();

	@FXML
	void actionLogin(ActionEvent event)throws IOException {
		
		FuncionarioDAO funcionarioDAO= new FuncionarioDAO ();
		
		funcionario = funcionarioDAO.autenticarUser(txtUser.getText(), txtPassword.getText());
		
		
		if (funcionario.getCpf()== null) {
			Alerts.showAlert("Erro!", "Erro de login!", "verifique se as informações estão corretas e tente novamete!", AlertType.ERROR);
		}else if(txtUser.getText() == "" || txtPassword.getText() =="") {
			
			Alerts.showAlert("Erro!", "Erro de login!", "Preencha as informações de login para acessar!",AlertType.ERROR);
		
		
		}else if (funcionario.getCpf().equals (txtUser.getText()) && funcionario.getSenha().equals( txtPassword.getText())) {
		Alerts.showAlert("Login bem sucedido", "Seja bem vindo " + funcionario.getNome(), "Agora que acessou vá trabalhar!", AlertType.INFORMATION);
		txtUser.setText("");
		txtPassword.setText("");
		Main.TelaHome();
	}else {
		Alerts.showAlert("Erro!", "Erroooooo!", "Erro", AlertType.ERROR);

	

		
		
//		if(txtUser.getText() == "" && txtPassword.getText() == "") {
//			Alerts.showAlert("Erro", "Erro de login", "Verifique se as informacoes estao corretas!", AlertType.ERROR);	

		
	}
}
}




