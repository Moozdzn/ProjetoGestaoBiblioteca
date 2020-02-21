package pt.europeia.Bibliotech.controllers;

import javafx.event.ActionEvent;
import database.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pt.europeia.Bibliotech.models.Livro;
/**
 * Controlador que gere a view do requisito que permite finalizar a reserva de um livro com os metodos correspondntes
 */
public class RequisitoController {

	private MainController mainController;
	
	@FXML
	private Text nomeLivro;

	@FXML
	private Text infoReservaNome;

	@FXML
	private Text infoDtInicial;

	@FXML
	private Text infoDtFinal;
	
	private String name = "";
	
	private String barcode ="";
	
	private boolean reservado;
	
	/**
	   * Recebe o livro selecionado para entregar bem como o MainController para atualizar a tabela de livros
	   */
	public RequisitoController(Livro livro,MainController mainController) {
		 name = livro.getName();
		 barcode = livro.getBarcode();
		 reservado = livro.isReservado();
		 this.mainController = mainController;
	}
	/**
	   * Inicializa a view
	   */
	@FXML
	private void initialize(){
	
	String dtInicial = ReservaDAO.getDataInicial(barcode);
	String dtFinal = ReservaDAO.getDataFinal(barcode);
	String user = ReservaDAO.getUser(barcode);
	
	nomeLivro.setText("Livro: " + name);
	infoReservaNome.setText("Reservado por: " + user);
	infoDtInicial.setText("Data de Início: " + dtInicial);
	infoDtFinal.setText("Data Limite: " + dtFinal);
	
	}
	/**
	   * Botão que confirma o final da reserva, atualizando as informações na base de dados e fecha a view
	   */
	@FXML
	void livroEntregue(ActionEvent event) {
		ReservaDAO.livroEntregue(barcode);
		reservado = false;
		ReservaDAO.setLivroReservado(0, barcode);
		mainController.updateDataAposEntrega();
		
		((Stage)nomeLivro.getScene().getWindow()).close();
	}


}
