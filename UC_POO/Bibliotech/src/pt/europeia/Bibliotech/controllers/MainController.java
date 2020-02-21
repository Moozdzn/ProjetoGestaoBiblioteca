package pt.europeia.Bibliotech.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import database.BibliotecaDAO;
import database.CategoriaDAO;
import database.LivrosDAO;
import database.UserDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.models.Biblioteca;
import pt.europeia.Bibliotech.models.Categoria;
import pt.europeia.Bibliotech.models.Livro;
import pt.europeia.Bibliotech.models.User;

/**
 * Controlador da view principal a ser mostrado após a verificação do login ser bem sucedida. 
 */

public class MainController {

	private javafx.collections.ObservableList<Livro> livro;

	private javafx.collections.ObservableList<User> user;

	@FXML
	private TableView<Livro> tableID;
	@FXML
	private TableColumn<Livro, String> nomeColumn;
	@FXML
	private TableColumn<Livro, String> autorColumn;
	@FXML
	private TableColumn<Livro, String> editoraColumn;
	@FXML
	private TableColumn<Livro, String> linguaColumn;
	@FXML
	private TableColumn<Livro, String> isbnColumn;
	@FXML
	private TableColumn<Livro, String> barcodeColumn;
	@FXML
	private TableColumn<Livro, String> anoColumn;
	@FXML
	private TableColumn<Livro, String> descricaoColumn;
	@FXML
	private TableColumn<Livro, String> generoColumn;

	@FXML
	private TableColumn<Livro, String>reservadoColumn;

	//@FXML
	//private TableColumn<Livro, Integer>idBiblioColumn;

	@FXML
	private Button infoReservar;

	@FXML
	private Button BAdicionar;
	@FXML
	private Button BRequisito;

	@FXML
	private Button vistaGeral;

	@FXML
	private Button historico;

	@FXML
	private ComboBox<Biblioteca> localBiblioteca;

	@FXML
	private ComboBox<Categoria> categoriaCB;

	@FXML
	private Label usernameL;

	@FXML
	private TextField checkNome;

	private int username;

	@FXML
	private CheckBox checkCategoria, checkLocal, checkName;

	private boolean nameSelected = false;
	private boolean categoriaSelected = false;
	private boolean localSelected = false;

	String campus = "";
	String categoria = "";
	String nome ="";

	public MainController(int username2) {
		this.username = username2;
	}

	/**
	 *Atualiza a tabela livros após um livro ter sido entregue á biblioteca após a finalização de uma reserva
	 */
	public void updateDataAposEntrega() {
		livro = LivrosDAO.getLivros();
		tableID.setItems(livro);
	}
	/**
	 * Método que atualiza a tabela livros conforme o argumento selecionado
	 * @param campus Recebe o campus selecionado
	 * @param categoria Recebe a categoria selecionada
	 * @param nome Recebe o nome do livro a pesquisar
	 */
	private void updateData(String Campus,String categoria,String nome) {

		if(localSelected) {
			if(Campus.equals("TODOS")) {
				livro = LivrosDAO.getLivros();
			}	
			else {
				livro = LivrosDAO.getLivrosBiblio(Campus);	
			}
		}
		else if (categoriaSelected) {
			livro = LivrosDAO.getLivrosCategor(categoria);
		}
		else if(nameSelected) {
			livro = LivrosDAO.getLivrosNome(nome);
		}
		else {
			livro = LivrosDAO.getLivros();
		}


		tableID.setItems(livro);
	}
	/**
	 * Método que inicializa a view
	 */

	@FXML
	private void initialize() {

		if(checkUser(username)) {
			BRequisito.setVisible(false);
			BAdicionar.setVisible(false);
			vistaGeral.setVisible(false);
		}
		else {
			infoReservar.setVisible(false);
			BAdicionar.setVisible(true);
			vistaGeral.setVisible(true);
		}


		usernameL.setText("Utilizador: "+username);
		localBiblioteca.getItems().clear();
		localBiblioteca.getItems().addAll(BibliotecaDAO.getBibliotecas());
		localBiblioteca.getSelectionModel().selectLast(); //mudar 
		campus = localBiblioteca.getValue().getIdBiblioteca();

		categoriaCB.getItems().clear();
		categoriaCB.getItems().addAll(CategoriaDAO.getCategorias());
		categoriaCB.getSelectionModel().selectFirst();
		categoria = categoriaCB.getValue().getIdCategoria();

		nomeColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("name"));
		autorColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("author"));
		editoraColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("publisher"));
		linguaColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("language"));
		isbnColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("isbn"));
		barcodeColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("barcode"));
		anoColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("publishYear"));
		descricaoColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("description"));
		generoColumn.setCellValueFactory(new PropertyValueFactory<Livro, String>("genre"));
		reservadoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReservado()));
		reservadoColumn.setCellFactory(column -> {
			return new TableCell<Livro, String>() {
				@Override
				protected void updateItem(String item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
						setStyle("");
					} else {
						setText(item);
						Livro auxLivro = getTableView().getItems().get(getIndex());
						if (auxLivro.isReservado())
							setStyle("-fx-background-color: #ff4500");
						else
							setStyle("-fx-background-color: #32CD32");
					}
				}
			};
		});
		updateData(campus,categoria,nome);

	}
	/**
	 * Só podendo estar um termo de pesquisa selecionado, verifica se os restantes estão "tickados" e retira para selecionar o este.
	 */

	@FXML
	void categoriaIsChecked(MouseEvent event) {
		if (categoriaSelected) checkCategoria.setSelected(!checkCategoria.isSelected());
		else {
			categoriaSelected = true;
			localSelected = false;
			nameSelected = false;
			checkLocal.setSelected(!checkCategoria.isSelected());
			checkName.setSelected(!checkCategoria.isSelected());
		}
	}
	/**
	 * Só podendo estar um termo de pesquisa selecionado, verifica se os restantes estão "tickados" e retira para selecionar o este.
	 */
	@FXML
	void localIsChecked(MouseEvent event) {
		if(localSelected) checkLocal.setSelected(!checkLocal.isSelected());
		else {
			categoriaSelected = false;
			localSelected = true;
			nameSelected = false;
			checkName.setSelected(!checkLocal.isSelected());
			checkCategoria.setSelected(!checkLocal.isSelected());
		}
	}
	/**
	 * Só podendo estar um termo de pesquisa selecionado, verifica se os restantes estão "tickados" e retira para selecionar o este.
	 */
	@FXML
	void nameIsChecked(MouseEvent event) {
		if(nameSelected) checkName.setSelected(!checkName.isSelected());
		else {
			categoriaSelected = false;
			localSelected = false;
			nameSelected = true;
			checkCategoria.setSelected(!checkName.isSelected());
			checkLocal.setSelected(!checkName.isSelected());
		}
	}
	/**
	 * Faz o pedido a base de dados do/dos livros que correspondem á pesquisa efetuada
	 */
	@FXML
	void search(ActionEvent event) {
		campus = localBiblioteca.getValue().getIdBiblioteca();
		categoria = categoriaCB.getValue().getIdCategoria();
		nome = checkNome.getText();
		updateData(campus,categoria,nome);

	}
	public int username() {
		return username;
	}
	/**
	 * Faz logout da sessão atual
	 */
	@FXML
	private void logout() {
		Main.openLogin();
	}
	/**
	 *Abre o histórico de reservas atuais do utilizador com sessão iniciada
	 */
	@FXML
	private void click() {
		Main.openResHistory(username);
	}
	/**
	   Abre a view que permite adicionar livros á base de dados
	 */
	@FXML
	private void add() {
		Main.openRegisterBook(username);
	}
	/**
	 * Abre a view que permite reservar o livro selecionado apartir da tabela
	 */
	@FXML
	private void reservar() {

		Livro livro=tableID.getSelectionModel().getSelectedItem();
		Main.openReservar(livro,username);
	}

	/**
	 * Abre a vista geral de administrador com informações sobre a/as bibliotecas
	 */
	@FXML
	void openVG(ActionEvent event) {
		openVistaGeral("vistaGeral");

	}
	/**
	 * Abre a view do requisito que permite ao docente finalizar uma reserva no ato da entrega de um livro
	 */
	@FXML
	void openRequisito(ActionEvent event) {

		if(tableID.getSelectionModel().getSelectedItem().getReservado().equals("Sim")) {
			Livro livro=tableID.getSelectionModel().getSelectedItem();
			openRequisito("requisito",livro);
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Livro não está reservado.");
			alert.showAndWait();
		}

	}
	/**
	 * Permite a abertura da view VistaGeral como pop-up sem fechar a atual
	 */

	public static void openVistaGeral(String sceneName) {
		Stage newWindow = new Stage();
		Node node = getNode(sceneName, new VistaGeralController());
		Scene scene = new Scene((Parent)node);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}
	/**
	 * Permite a abertura da view Requisito como pop-up sem fechar a atual
	 * @param sceneName
	 * @param livro objeto passado para a view requisito que corresponde ao livro que vai ser entregue
	 */
	public void openRequisito(String sceneName, Livro livro) {
		Stage newWindow = new Stage();
		Node node = getNode(sceneName, new RequisitoController(livro, this));
		Scene scene = new Scene((Parent)node);
		newWindow.setResizable(false);
		newWindow.setScene(scene);
		newWindow.show();
	}

	public static Node getNode(String name, Object obj) {
		Node node = null;
		try {
			URL path = Main.class.getResource("views/" + name +".fxml");
			FXMLLoader loader = new FXMLLoader(path);
			loader.setController(obj);
			node = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return node;
	}
	/**
	 * Sendo as view de aluno e docente diferentes, faz a verificação apartir da base de dados para selecionar a view com os botões corretos
	 *
	 *@param username
	 *@return 
	 */

	private boolean checkUser(int username) {
		user = UserDAO.getUsers();
		for(int aux=0;aux<user.size();aux++) {
			if(user.get(aux).getIdUser()==username) {
				if(user.get(aux).getCargo())
					return true;
			}
		}
		return false;
	}

}
