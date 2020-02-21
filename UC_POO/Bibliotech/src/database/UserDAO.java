package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.User;
/**
 * 
 * Classe para obtenção de informação da tabela user da base de dados
 *
 */
public class UserDAO {
/**
 * Método que recebe uma lista de todos os utilizadores na base de dados
 * @return Lista de utilizadores
 */
	public static ObservableList<User> getUsers() {
		ObservableList<User> users =FXCollections.observableArrayList();
		String sql="select * from user;";
		User util;

		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				util=new User(utils.getInt("idUser"),utils.getString("password"),utils.getBoolean("cargo"));
				users.add(util);

			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * Introduz um novo utilizador na base de dados da biblioteca
	 * @param users Objeto user com as informaçoes a inserir
	 */
	public static void newUtil(User users) {
		String sql="Insert into user values(?,?,?)";
		try (Connection conn = singleton.getConnector().getConnection();
				PreparedStatement stat	= conn.prepareStatement(sql)) {
			stat.setInt(1, users.getIdUser());
			stat.setString(2, users.getPassword());
			stat.setBoolean(3, users.getCargo());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
	/**
	 * Método para receber o numero de alunos que estao inscritos na base de dados da bibliotecas
	 * @return Numero inteiro de alunos
	 */
	public static int getNrAlunos() {
		int users = 0;
		String sql="select count(*) as alunos from user where cargo = 1;";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				users = utils.getInt("alunos");
				
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * Método para receber o numero de docentes inscritos na faculdade
	 * @return Numero inteiro de docentes
	 */
	public static int getNrDocentes() {
		int users = 0;
		String sql="select count(*) as docentes from user where cargo = 0;";
		
		try {
			Connection conn=singleton.getConnector().getConnection();
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet utils=stat.executeQuery();
			while(utils.next()) {
				users = utils.getInt("docentes");			
}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}


