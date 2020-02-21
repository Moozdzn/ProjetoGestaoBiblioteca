package pt.europeia.Bibliotech.controllers;

import javafx.event.ActionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import database.LivrosDAO;
import database.ReservaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Text;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.controllers.MainController;
import pt.europeia.Bibliotech.models.Livro;
import pt.europeia.Bibliotech.models.Reserva;

import java.util.Date;

/**
 * Controlador que gere a view ReservarController que permite ao utilizador reservar um livro de cada vez
 */

public class ReservarController<MainController> {

	private javafx.collections.ObservableList<Reserva> currentReserva;

	@FXML
	private Text autorL;

	@FXML
	private Text tituloL;

	@FXML
	private Text isbnL;

	@FXML
	private Text publisherL;

	@FXML
	private Text publisherDateL;

	@FXML
	private Text languageL;

	@FXML
	private Text genreL;

	@FXML
	private Text barcodeL,reservadoL,textDias;

	@FXML
	private Text disponibilidadeL;

	@FXML
	private ComboBox<Integer> diasReserva;


	private String name;
	private String author;
	private String publisher;
	private String language;
	private String isbn;
	private String barcode;
	private String publishDate;
	private String description;
	private String genre;
	private String idBiblioteca;
	private boolean reservado;
	private int username;


	Reserva reservas;

	Date dt = new Date();
	DateTime dtOrg = new DateTime(dt);

	String b = dtOrg.toString("dd/MM/yyyy");


	private boolean reservado1; // true = não disponível ; false = disponível

	/**
	 * Contructor do controlador.
	 * @param livro recebe o objeto do livro selecionado 
	 * @param username3 recebe o numero do utilizador da sessão atual
	 */

	public ReservarController(Livro livro,int username3) {

		name = livro.getName();
		author = livro.getAuthor();
		publisher = livro.getPublisher();
		language = livro.getLanguage();
		isbn = livro.getIsbn();
		barcode = livro.getBarcode();
		publishDate = livro.getPublishYear();
		description = livro.getDescription();
		genre = livro.getGenre();
		idBiblioteca = livro.getIdBiblioteca();
		reservado = livro.isReservado();
		this.username = username3;

	}
	/**
	   * Inicializa a view
	   */
	@FXML
	private void initialize(){

		currentReserva = ReservaDAO.getReservas(barcode);
		String dtFinal= "";
		if (reservado) {for(int aux = 0; aux <currentReserva.size();aux++) {
			if(currentReserva.get(aux).getCodigoDeBarras().equals(barcode)) {
				dtFinal = currentReserva.get(aux).getDtFinal();
			}
		}
		}

		String reservadoString;
		
		if (reservado)reservadoString = "Sim";
		else reservadoString = "Não";
		disponibilidadeL.setVisible(reservado);
		textDias.setVisible(!reservado);
		diasReserva.setVisible(!reservado);


		diasReserva.getItems().removeAll(diasReserva.getItems());
		diasReserva.getItems().addAll( 1, 2, 3, 4, 5, 6, 7);

		autorL.setText(author);
		tituloL.setText(name);
		isbnL.setText("ISBN: " + isbn);
		publisherL.setText("Publisher: "+ publisher);
		publisherDateL.setText("PublishDate: "+publishDate);
		languageL.setText("Language: "+ language);
		genreL.setText("Genre: "+ genre);
		reservadoL.setText("Reservado: " + reservadoString);
		disponibilidadeL.setText("Disponível a: "+ dtFinal);




	}
	/**
	   *Retorna á view anterior
	   */
	@FXML
	void goback(ActionEvent event) {
		Main.openMain(username);
	}
	/**
	   * Botão que confirma a reserva e atualiza as informações na base de dados
	   */
	@FXML
	void reservarFinal(ActionEvent event ) {
		
		int dias = diasReserva.getSelectionModel().getSelectedItem();
		DateTime dtPlus = dtOrg.plusDays(dias);
		String a = dtPlus.toString("dd/MM/yyyy");
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Confirmar reserva");
		alert.setContentText("Pretende reservar o livro " + name + " até ao dia " + a);
		Optional <ButtonType> result = alert.showAndWait();
		
		if(result.get()==ButtonType.OK) {
		reservas = new Reserva(username,barcode,idBiblioteca,b,a);
		ReservaDAO.newReserva(reservas);
		
		ReservaDAO.setLivroReservado(1, barcode);
		Main.openMain(username);
		}
		else {
			Main.openMain(username);
		}

		
	}
}
