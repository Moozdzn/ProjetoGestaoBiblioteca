package pt.europeia.Bibliotech.controllers;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import database.BibliotecaDAO;
import database.CategoriaDAO;
import database.LivrosDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.models.Biblioteca;
import pt.europeia.Bibliotech.models.Categoria;
import pt.europeia.Bibliotech.models.Livro;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;;

/**
 * Controlador da view RegisterBook com os métodos correspondentes
 */

public class RegisterBookController {

	public Livro lv;
	private int username;

	@FXML
	private TextField isbnNr, nomeTxt, autorTxt, editoraTxt, idiomaTxt, dataTxt, barcodeTxt;

	@FXML
	private TextArea descricaoTxt;

	@FXML
	private ComboBox<Biblioteca> localBibliotecaBC;

	@FXML
	private ComboBox<Categoria> categoriaCB;
	/**
	 * Recebe o número de utilizador da sessão atual
	 * @param username5 numero de utilizador da sessão atual
	 */
	public RegisterBookController(int username5) {
		this.username = username5;
	}
	public int username() {
		return username;
	}
	/**
	 * Inicializa a view
	 */
	@FXML
	private void initialize() {
		localBibliotecaBC.getItems().clear();
		localBibliotecaBC.getItems().addAll(BibliotecaDAO.getBibliotecas());
		categoriaCB.getItems().clear();
		categoriaCB.getItems().addAll(CategoriaDAO.getCategorias());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Adicionar um livro");
		alert.setContentText(
				"Pode adicionar o livro de duas maneiras : \n 1º- Ao Inserir o ISBN os campos abaixos serão austomaticamente preenchidos. \n 2º- Pode preencher os campos manualmente e gerar um código de barras. ");
		alert.showAndWait();

	}
	/**
	 * Botão que inicializa a pesquisa á base de dados da Google Books apartir da API com o ISBN introduzido pelo utilizador
	 */
	@FXML
	private void search() {
		String rawISBN = isbnNr.getText();
		String s = "";
		String authors = "";
		String title = "";
		String description = "";
		String publisher = "";
		String publishedDate = "";
		String language = "";

		try {
			long ISBN = Long.parseLong(rawISBN);
			URL oracle = new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:" + ISBN + "");
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);
				s += inputLine;
			}
			in.close();

		} catch (IOException e) {

		}
		JsonObject obj = new JsonParser().parse(s).getAsJsonObject();

		JsonObject volumeInfo = obj.get("items").getAsJsonArray().get(0).getAsJsonObject().get("volumeInfo")
				.getAsJsonObject();

		if (volumeInfo.has("authors")) {
			authors = volumeInfo.get("authors").toString();
			StringBuilder sb = new StringBuilder(authors);
			sb.deleteCharAt(0);
			sb.deleteCharAt((sb.length() - 1));
			String autor = sb.toString();
			autorTxt.setText(autor);
		}
		if (volumeInfo.has("title")) {
			title = volumeInfo.get("title").toString();
			nomeTxt.setText(title);
		}
		if (volumeInfo.has("publisher")) {
			publisher = volumeInfo.get("publisher").toString();
			editoraTxt.setText(publisher);
		}
		if (volumeInfo.has("publishedDate")) {
			publishedDate = volumeInfo.get("publishedDate").toString();
			dataTxt.setText(publishedDate);
		}
		if (volumeInfo.has("description")) {
			description = volumeInfo.get("description").toString();
			descricaoTxt.setText(description);
		}
		if (volumeInfo.has("language")) {
			language = volumeInfo.get("language").toString();
			idiomaTxt.setText(language);
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setContentText("Qualquer Informação em falta não está disponível online.");
		alert.showAndWait();
	}
/**
 * Gera o código de barras do novo livro
 */
	@FXML
	private void generate() {
		boolean check = false;
		try {
			localBibliotecaBC.getValue().getIdBiblioteca();
			check = true;
		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Não selecionou o campus");
			alert.showAndWait();
		}
		if (check) {
			String campus = localBibliotecaBC.getValue().getIdBiblioteca();
			barcodeTxt.setText( campus + "-" + getBarcode());
		}

	}
/**
 * Botao que confirma as informações do livro e adiciona as mesmas á base de dados apartir do objeto livro
 */
	@FXML
	private void confirm() {
		System.out.println("working");

		String nome = "";
		String autor = "";
		String editora = "";
		String idioma = "";
		String iSBN = "";
		String categoria = "";
		String barcode = "";
		String data = "";
		String descricao = "";
		String campus = localBibliotecaBC.getSelectionModel().getSelectedItem().toString();
		String idBiblioteca = "BN";
		try {

			nome = nomeTxt.getText();
			autor = autorTxt.getText();
			editora = editoraTxt.getText();
			idioma = idiomaTxt.getText();
			iSBN = isbnNr.getText();
			barcode = barcodeTxt.getText();
			data = dataTxt.getText();
			categoria = categoriaCB.getSelectionModel().getSelectedItem().toString();
			descricao = descricaoTxt.getText();

		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Um campo essencial está em falta.");
			alert.showAndWait();
		}
		lv = new Livro( nome, autor, editora, idioma, iSBN,barcode, data, descricao, categoria,idBiblioteca, false);
		LivrosDAO.newLivro(lv);
		Main.openMain(username);
	}
/**
 * gera um número inteiro, parte do códiog de barras
 * @return um número inteiro
 */
	public static String getBarcode() {
		double min, max;
		min = 10000;
		max = 99999;
		int x = (int) (Math.random() * ((max - min) + 1) + min);
		String strI = Integer.toString(x);
		return strI;
	}


}
