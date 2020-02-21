package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Livro;
import pt.europeia.Bibliotech.models.User;
/**
 * 
 * Classe para obtenção de informação da tabela livro  da base de dados
 *
 */
public class LivrosDAO {
	/**
	 * Seleciona todos os livros da tabela 
	 * @return Lista de livros
	 */
	public static ObservableList<Livro> getLivros() {
		ObservableList<Livro> livro = FXCollections.observableArrayList();
		String sql = "select * from livros;";
		Livro util;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet livros = stat.executeQuery();
			while (livros.next()) {
				util = new Livro( livros.getString("Título"),
						livros.getString("Autor"),
						livros.getString("Editora"), 
						livros.getString("Língua"), 
						livros.getString("ISBN"),
						livros.getString("codigo_de_barras"),
						livros.getString("Data de publicação"),
						livros.getString("Descrição"),
						livros.getString("idCategoria"),  
						livros.getString("idBiblioteca"),
						livros.getBoolean("Reservado"));
				livro.add(util);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
	/**
	 * Seleciona todos os livros de uma determinada biblioteca
	 * @param idBiblioteca id da biblioteca donde se vai selecionar os livros
	 * @return Lista de livros
	 */
	public static ObservableList<Livro> getLivrosBiblio(String idBiblioteca) {
		ObservableList<Livro> livro = FXCollections.observableArrayList();
		String sql = "Select * from livros where idBiblioteca = \'"+ idBiblioteca +"\' order by 'Título' asc;";
		Livro util;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet livros = stat.executeQuery();
			while (livros.next()) {
				util = new Livro( livros.getString("Título"),
						livros.getString("Autor"),
						livros.getString("Editora"), 
						livros.getString("Língua"), 
						livros.getString("ISBN"),
						livros.getString("codigo_de_barras"),
						livros.getString("Data de publicação"),
						livros.getString("Descrição"),
						livros.getString("idCategoria"),  
						livros.getString("idBiblioteca"),
						livros.getBoolean("Reservado"));
				livro.add(util);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
	/**
	 * Seleciona todos os livros de uma determinada categoria
	 * @param idCategoria id da categoria donde se vai selecionar os livros
	 * @return Lista de Livros
	 */
	public static ObservableList<Livro> getLivrosCategor(String idCategoria) {
		ObservableList<Livro> livro = FXCollections.observableArrayList();
		String sql =  "Select * from livros where idCategoria = \'" + idCategoria + "\';";
		Livro util;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet livros = stat.executeQuery();
			while (livros.next()) {
				util = new Livro( livros.getString("Título"),
						livros.getString("Autor"),
						livros.getString("Editora"), 
						livros.getString("Língua"), 
						livros.getString("ISBN"),
						livros.getString("codigo_de_barras"),
						livros.getString("Data de publicação"),
						livros.getString("Descrição"),
						livros.getString("idCategoria"),  
						livros.getString("idBiblioteca"),
						livros.getBoolean("Reservado"));
				livro.add(util);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
	/**
	 * Seleciona Livros que corresponde a um certo titulo
	 * @param nomeLivro nome do livro a pesquisar na base de dados
	 * @return Lista de Livros
	 */
	public static ObservableList<Livro> getLivrosNome(String nomeLivro) {
		ObservableList<Livro> livro = FXCollections.observableArrayList();
		String sql =  "Select * from livros where Título like \'%" + nomeLivro + "%\';";
		Livro util;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet livros = stat.executeQuery();
			while (livros.next()) {
				util = new Livro( livros.getString("Título"),
						livros.getString("Autor"),
						livros.getString("Editora"), 
						livros.getString("Língua"), 
						livros.getString("ISBN"),
						livros.getString("codigo_de_barras"),
						livros.getString("Data de publicação"),
						livros.getString("Descrição"),
						livros.getString("idCategoria"),  
						livros.getString("idBiblioteca"),
						livros.getBoolean("Reservado"));
				livro.add(util);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}
	
	
/**
 * Método para inserir um novo livro na base de dados
 * @param livros Objeto livro com as informações a inserir na base de dados
 */
	public static void newLivro(Livro livros) {
		String sql = "Insert into livros values(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = singleton.getConnector().getConnection();
				PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, livros.getName());
			stat.setString(2, livros.getAuthor());
			stat.setString(3, livros.getPublisher());
			stat.setString(4, livros.getLanguage());
			stat.setString(5, livros.getIsbn());
			stat.setString(6, livros.getBarcode());
			stat.setString(7, livros.getPublishYear());
			stat.setString(8, livros.getDescription());
			stat.setString(9, livros.getGenre());
			stat.setString(10, livros.getIdBiblioteca());
			stat.setBoolean(11, livros.isReservado());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Seleciona o numero de livros na tabela de base de dados
	 * @return numero de livros total
	 */
	public static int getNrLivros() {
		int livros = 0;
		String sql="select count(*) as livros from livros;";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				livros = utils.getInt("livros");
				
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}
	
	//public static void 

	

}
