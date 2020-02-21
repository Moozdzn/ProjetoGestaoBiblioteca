package pt.europeia.Bibliotech.controllers;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import pt.europeia.Bibliotech.Main;


/**
 *Controlador da primeira view a ser mostrada quando o programa � iniciados
 */
public class FirstController {
	
	/**
	 * Bot�o que abre a view de login caso o utilizador j� esteja inscrito
	 */
	
	@FXML
	private void login() {
		Main.openLogin();
	}
	/**
	 * Bot�o que abre view de registo caso o utilizador n�o esteja inscrito
	 */
	@FXML
	private void create() {
		Main.openRegisto();
	}


}
