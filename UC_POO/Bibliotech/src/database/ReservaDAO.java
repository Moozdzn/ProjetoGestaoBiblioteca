package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Livro;
import pt.europeia.Bibliotech.models.Reserva;

/**
 * 
 * Classe para obtenção de informação da tabela reserva da base de dados
 *
 */
public class ReservaDAO {
	/**
	 * insere uma nova reserva na tabela
	 * @param reservas Objeto com as informaçoes da reserva a inserir na tabela
	 */
	public static void newReserva(Reserva reservas) {
		String sql = "Insert into reserva values(?,?,?,?,?)";
		try (Connection conn = singleton.getConnector().getConnection();
				PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, reservas.getUser());
			stat.setString(2, reservas.getCodigoDeBarras());
			stat.setString(3, reservas.getIdBiblioteca());
			stat.setString(4, reservas.getDtInicial());
			stat.setString(5, reservas.getDtFinal());	
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * Define se o livro se encontra na base de dados
 * @param reservado Recebe 1 ou 0 
 * @param barcode codigo de barras unico a cada livro
 */
	public static void setLivroReservado(int reservado,String barcode) {
		String sql = "Update livros set Reservado = " + reservado + " where `codigo_de_barras` =\""+ barcode + "\";";
		try (Connection conn = singleton.getConnector().getConnection();
				PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Defini que o livro foi entregue e a reserva finalizada, apaga a entrada da tabela reserva
	 * @param barcode codigo de barras unico a cada livro
	 */
	public static void livroEntregue(String barcode) {
		String sql = "delete from reserva where `codigo_de_barras` =\""+ barcode + "\";";
		try (Connection conn = singleton.getConnector().getConnection();
				PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
/**
 * Recebe todas as informaçoes de uma reserva individual
 * @param barcode codigo de barras unico a cada livro
 * @return Lista de Reservas
 */
	public static ObservableList<Reserva> getReservas(String barcode) {
		String sql = "select * from reserva where `codigo_de_barras` =\""+ barcode + "\";";
		ObservableList<Reserva> newReserva = FXCollections.observableArrayList();
		Reserva util;
		try {
			Connection conn = singleton.getConnector().getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet reservas = stat.executeQuery();

			while (reservas.next()) {		
				util = new Reserva( reservas.getInt("idUser"),
						reservas.getString("codigo_de_barras"),
						reservas.getString("idBiblioteca"), 
						reservas.getString("DataLevantamento"), 
						reservas.getString("Prazo_Maximo")); 
				newReserva.add(util);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return newReserva;
	}
/**
 * Metodo para receber o numero total de reservas atuais
 * @return Inteiro com o numero atual de reservas
 */
	public static int getNrReservas() {
		int reservas = 0;
		String sql="select count(*) as reservas from reserva;";

		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				reservas = utils.getInt("reservas");			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	/**
	 * Método para obter a data inicial de uma determinada reserva
	 * @param barcode codigo de barras unico a cada livro
	 * @return String dtInicial
	 */
	public static String getDataInicial(String barcode) {
		String dtInicial = "";
		String sql="select DataLevantamento from reserva where `codigo_de_barras` =\""+ barcode + "\";";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				dtInicial = utils.getString("DataLevantamento");			
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return dtInicial;
	}
	/**
	 * Método para obter a data final de uma determinada reserva
	 * @param barcode codigo de barras unico a cada livro
	 * @return String dtFinal
	 */
	public static String getDataFinal(String barcode) {
		String dtFinal = "";
		String sql="select Prazo_Maximo from reserva where `codigo_de_barras` =\""+ barcode + "\";";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				dtFinal = utils.getString("Prazo_Maximo");			
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return dtFinal;
	}
	/**
	 * Método para obter o utilizador responsavel por uma determinada reserva
	 * @param barcode codigo de barras unico a cada reserva
	 * @return String do user
	 */
	public static String getUser(String barcode) {
		String user = "";
		String sql="select idUser from reserva where `codigo_de_barras` =\""+ barcode + "\";";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				user = utils.getString("idUser");			
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}





}

