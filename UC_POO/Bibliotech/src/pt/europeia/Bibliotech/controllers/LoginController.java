package pt.europeia.Bibliotech.controllers;

import java.awt.event.ActionEvent;
import java.net.URL;

import database.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.models.User;
/**
 * Controlador da view Login com os métodos correspondentes
 */
public class LoginController {
	private javafx.collections.ObservableList<User> users;
	private boolean login = false;
	
	
	@FXML
	private TextField usernameTF;
	@FXML
	private PasswordField passwordPF;

	/**
	   * Botão que efetua a verificação de login
	   */
	@FXML
	private void login() {
		int username = Integer.parseInt(usernameTF.getText());
		String password = passwordPF.getText();
		
		users = UserDAO.getUsers();
			
		for (int aux=0; aux<users.size(); aux++) {
			
			if (username==users.get(aux).getIdUser()) {
				if(password.equals(users.get(aux).getPassword())) {
					login = true;
					Main.openMain(username);
					}
				}
			}
		if(!login) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Wrong pass or login.\n Please try again");
			alert.showAndWait();
}

	} 
	
	/**
	   * Botão de retorno
	   */
	@FXML
	private void back() {
		Main.openView();
	}

}
