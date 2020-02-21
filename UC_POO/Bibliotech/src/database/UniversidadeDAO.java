package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Universidade;
/**
 * 
 * Classe para obtenção de informação da tabela universidade da base de dados
 *
 */
public class UniversidadeDAO {
/**
 * Método para obter as informações de todas as faculdades na base de dados
 * @return Lista das faculdades
 */
	public static ObservableList<Universidade> getUniversidades() {
		ObservableList<Universidade> universidades = FXCollections.observableArrayList();
		String sql = "select * from Universidade;";
		Universidade univ;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet univs = stat.executeQuery();
			while (univs.next()) {
				univ = new Universidade(univs.getInt("idUniversidade"), univs.getString("nome"));
				universidades.add(univ);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return universidades;
	}

}
