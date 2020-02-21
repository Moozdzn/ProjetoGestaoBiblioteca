package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.ResHistory;

/**
 * 
 * Classe para obtenção de informação da tabela ResHistory da base de dados
 *
 */
public class ResHistoryDAO {

	public static ObservableList<ResHistory> getHistorics(int idUser) {
		ObservableList<ResHistory> reses = FXCollections.observableArrayList();
		String sql = "SELECT L.Título, L.Autor, L.Editora, L.Codigo_de_barras, B.Nome, R.DataLevantamento FROM livros as L INNER JOIN reserva as R ON R.Codigo_de_barras = L.Codigo_de_barras  INNER JOIN biblioteca as B ON B.idBiblioteca = R.idBiblioteca WHERE R.idUser=?;" ; 

		ResHistory reserva;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, idUser );
			ResultSet historics = stat.executeQuery();
			while (historics.next()) {
				reserva = new ResHistory(historics.getString("L.Título"),
									 historics.getString("L.Autor"),
									 historics.getString("L.Editora"),
									 historics.getString("L.Codigo_de_Barras"),
									 historics.getString("B.Nome"),
									 historics.getString("R.DataLevantamento"));
				reses.add(reserva);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reses;
	}
}