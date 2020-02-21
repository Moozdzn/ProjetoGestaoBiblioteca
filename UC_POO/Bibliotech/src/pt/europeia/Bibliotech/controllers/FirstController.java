package pt.europeia.Bibliotech.controllers;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import pt.europeia.Bibliotech.Main;


/**
 *Controlador da primeira view a ser mostrada quando o programa é iniciados
 */
public class FirstController {
	
	/**
	 * Botão que abre a view de login caso o utilizador já esteja inscrito
	 */
	
	@FXML
	private void login() {
		Main.openLogin();
	}
	/**
	 * Botão que abre view de registo caso o utilizador não esteja inscrito
	 */
	@FXML
	private void create() {
		Main.openRegisto();
	}


}
