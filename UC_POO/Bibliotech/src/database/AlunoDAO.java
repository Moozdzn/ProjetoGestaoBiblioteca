package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.europeia.Bibliotech.models.Aluno;
import pt.europeia.Bibliotech.models.User;
/**
 * 
 * Classe para obtenção de informação da tabela aluno da base de dados
 *
 */
public class AlunoDAO {
	
	
	/**
	 * Seleciona todos os alunos da base de dados
	 * @return Lista de Alunos
	 */
	public static ObservableList<Aluno> getAlunos() {
        ObservableList<Aluno> alunos =FXCollections.observableArrayList();
        String sql="select * from aluno;";
        Aluno util;

        try {
            Connection conn=singleton.getConnector().getConnection();
            PreparedStatement stat=conn.prepareStatement(sql);
            ResultSet utils=stat.executeQuery();
            while(utils.next()) {
            util=new Aluno(utils.getInt("idAluno"),utils.getString("Nome"),utils.getString("Data de Nascimento"),utils.getString("Curso"));
            alunos.add(util);
            
            }

        }
         catch (SQLException e) {
                e.printStackTrace();
            }
            return alunos;
    }
	
}
