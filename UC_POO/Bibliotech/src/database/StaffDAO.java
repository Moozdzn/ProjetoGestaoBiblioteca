package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Aluno;
import pt.europeia.Bibliotech.models.Staff;
/**
 * 
 * Classe para obtenção de informação da tabela staff da base de dados
 *
 */
public class StaffDAO {
	/**
	 * Método para receber todos os membros de staff da faculdade
	 * @return Lista de Staff
	 */
	
	public static ObservableList<Staff> getStaff() {
        ObservableList<Staff> staff =FXCollections.observableArrayList();
        String sql="select * from staff;";
        Staff util;

        try {
            Connection conn=singleton.getConnector().getConnection();
            PreparedStatement stat=conn.prepareStatement(sql);
            ResultSet utils=stat.executeQuery();
            while(utils.next()) {
            util=new Staff(utils.getInt("idStaff"),utils.getString("Nome"),utils.getString("Data de Nascimento"),utils.getString("Cargo"));
            staff.add(util);
            
            }

        }
         catch (SQLException e) {
                e.printStackTrace();
            }
            return staff;
    }
}
