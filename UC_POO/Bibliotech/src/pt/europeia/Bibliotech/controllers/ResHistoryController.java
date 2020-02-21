package pt.europeia.Bibliotech.controllers;

import database.ResHistoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.models.Livro;
import pt.europeia.Bibliotech.models.ResHistory;
import pt.europeia.Bibliotech.models.Reserva;
/**
 * Controlador que gere a view ResHistory que permite ao utilizador ver as suas reservas atuais
 */
public class ResHistoryController {
	
	private int username;
	
	private javafx.collections.ObservableList<ResHistory> resLog;
	
	public ResHistoryController(int username)
	{
		this.username=username;
	}
	
	@FXML
	private TableView<ResHistory> tableReserva;
	@FXML
	private TableColumn<ResHistory, String> nomeColumn;
	@FXML
	private TableColumn<ResHistory, String> AutorColumn;
	@FXML
	private TableColumn<ResHistory, String> EditoraColumn;
	@FXML
	private TableColumn<ResHistory, String> BarcodeColumn;
	@FXML
	private TableColumn<ResHistory, String> BibliotecaColumn;
	@FXML
	private TableColumn<ResHistory, String> DataResColumn;

	/**
	   * Inicializa a view
	   */
	@FXML
	private void initialize() {
		

		nomeColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("titulo"));
		AutorColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("autor"));
		EditoraColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("editora"));
		BarcodeColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("barcode"));
		BibliotecaColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("uNome"));
		DataResColumn.setCellValueFactory(new PropertyValueFactory<ResHistory, String>("dataMax"));
		
		resLog = ResHistoryDAO.getHistorics(username);

		tableReserva.setItems(resLog);
	}
	/**
	 * Retorna á view anterior
	 */
	public void goBack()
	{
		Main.openMain(username);
	}
	
		
	
		
	
}
