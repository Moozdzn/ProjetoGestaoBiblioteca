package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Categoria;
/**
 * 
 * Classe para obtenção de informação da tabela categoria da base de dados
 *
 */
public class CategoriaDAO {
	/**
	 * Seleciona todas as categorias que se encontram na base de dados
	 * @return Lista de todas as categorias
	 */
	public static ObservableList<Categoria> getCategorias() {
		ObservableList<Categoria> categorias = FXCollections.observableArrayList();
		String sql = "select * from categoria;";
		Categoria catego;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet categors = stat.executeQuery();
			while (categors.next()) {
				catego = new Categoria(categors.getString("idCategoria"));
				categorias.add(catego);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorias;
	}
}
