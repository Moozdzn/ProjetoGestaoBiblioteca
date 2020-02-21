package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Biblioteca;
/**
 * 
 * Classe para obtenção de informação da tabela biblioteca da base de dados
 *
 */
public class BibliotecaDAO {
	/**
	 * Seleciona todas as bibliotecas da tabela
	 * @return Lista das bilbiotecas
	 */
	public static ObservableList<Biblioteca> getBibliotecas() {
		ObservableList<Biblioteca> bibliotecas = FXCollections.observableArrayList();
		String sql = "select * from Biblioteca;";
		Biblioteca biblio;

		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet biblios = stat.executeQuery();
			while (biblios.next()) {
				biblio = new Biblioteca(biblios.getString("idBiblioteca"), biblios.getString("Nome"),biblios.getInt("idUniversidade"));
				bibliotecas.add(biblio);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bibliotecas;
	}
	/**
	 * Metodo para executar um count do numero de bibliotecas
	 * @return Inteiro do numero de bibliotecas
	 */
	public static int getNrBibliotecas() {
		int bibliotecas = 0;
		String sql="select count(*) as bibliotecas from biblioteca;";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				bibliotecas = utils.getInt("bibliotecas");
				
}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bibliotecas;
	}
	
}
