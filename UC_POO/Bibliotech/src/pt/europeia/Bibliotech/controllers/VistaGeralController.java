package pt.europeia.Bibliotech.controllers;

import database.BibliotecaDAO;

import database.LivrosDAO;
import database.UserDAO;
import database.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Controlador que gere a view VistaGeral que permite aos docentes terem uma visualiza��o geral da bilbioteca.Acesso a v�rias informa��es como o numero de livros presentes, alunos e docentes.
 * @author Diogo Santos
 * @author Hugo Varela
 * @author Jo�o Cardo
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
		nrBibliotecas.setText("N� de Bibliotecas Individuais: " + nrBiblio +".");
		nrDocentes.setText("Numero de Docentes: "+ UserDAO.getNrDocentes()+ ".");
		nrUsers.setText("N�mero de utilizadores: " + UserDAO.getNrAlunos() + ".");
		nrLivros.setText("N�mero de livros(Total): " + LivrosDAO.getNrLivros()+ ".");
		nrLivrosReservados.setText("N�mero de livros reservados: " + ReservaDAO.getNrReservas() + ".");


	}
}
