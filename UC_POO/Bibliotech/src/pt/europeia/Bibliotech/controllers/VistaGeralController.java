package pt.europeia.Bibliotech.controllers;

import database.BibliotecaDAO;

import database.LivrosDAO;
import database.UserDAO;
import database.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Controlador que gere a view VistaGeral que permite aos docentes terem uma visualização geral da bilbioteca.Acesso a várias informações como o numero de livros presentes, alunos e docentes.
 * @author Diogo Santos
 * @author Hugo Varela
 * @author João Cardo
 *
 */

public class VistaGeralController {

	@FXML
	private Text nrBibliotecas;

	@FXML
	private Text nrDocentes;

	@FXML
	private Text nrUsers;

	@FXML
	private Text nrLivros;

	@FXML
	private Text nrLivrosReservados;
	/**
	   * Inicializa a view
	   */
	@FXML
	private void initialize () {
		int nrBiblio = BibliotecaDAO.getNrBibliotecas() -1;
		nrBibliotecas.setText("Nº de Bibliotecas Individuais: " + nrBiblio +".");
		nrDocentes.setText("Numero de Docentes: "+ UserDAO.getNrDocentes()+ ".");
		nrUsers.setText("Número de utilizadores: " + UserDAO.getNrAlunos() + ".");
		nrLivros.setText("Número de livros(Total): " + LivrosDAO.getNrLivros()+ ".");
		nrLivrosReservados.setText("Número de livros reservados: " + ReservaDAO.getNrReservas() + ".");


	}
}
