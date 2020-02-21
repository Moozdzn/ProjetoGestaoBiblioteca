package pt.europeia.Bibliotech.controllers;

import database.AlunoDAO;
import database.StaffDAO;
import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import pt.europeia.Bibliotech.Main;
import pt.europeia.Bibliotech.models.Aluno;
import pt.europeia.Bibliotech.models.Staff;
import pt.europeia.Bibliotech.models.User;
/**
 * Controlador da view que regista os membros da faculdade na base de dados da biblioteca com os métodos correspondentes
 */
public class RegistoController {


	@FXML
	private TextField numeroEstR;

	@FXML
	private Text nomeProprioR, birthR,cursoAF;

	@FXML
	private CheckBox docenteCheck, estudanteCheck;
	@FXML
	private PasswordField passwordR;

	private boolean docenteSelected = false;
	private boolean estudanteSelected = false;
	boolean found = false;
	private javafx.collections.ObservableList<Aluno> alunos;
	private javafx.collections.ObservableList<Staff> staff;
	private javafx.collections.ObservableList<User> users;

	
	/**
	   * O utilizador pode ser aluno ou docente, estas duas checkbox fazem essa diferenciação
	   */
	@FXML
	void docenteIsChecked(MouseEvent event) {
		estudanteCheck.setSelected(!docenteCheck.isSelected());
}
/**
 * O utilizador pode ser aluno ou docente, estas duas checkbox fazem essa diferenciação
 * 
 */
	@FXML
	void estudanteIsChecked(MouseEvent event) {
		docenteCheck.setSelected(!estudanteCheck.isSelected());
	}
	/**
	   * Com base na checkbox selecionada, vai buscar as informações da pessoa que se esta a registar á base de dados da faculdade para a mesma os confirmar.
	   */
	@FXML
	void checkPPL(ActionEvent event) {
		try {
			found=false;
			alunos = AlunoDAO.getAlunos();
			staff = StaffDAO.getStaff();
			int numero = Integer.parseInt(numeroEstR.getText());
			if(estudanteCheck.isSelected()) {
				for (int aux=0; aux<alunos.size(); aux++) {
					if (numero==alunos.get(aux).getIdAluno()) {
						nomeProprioR.setText(alunos.get(aux).getNome());
						birthR.setText(alunos.get(aux).getDataNascimento());
						cursoAF.setText(alunos.get(aux).getCurso());
						found = true;
					}
				}
			}
			else if (docenteCheck.isSelected()) {
				for (int aux=0; aux<staff.size(); aux++) {
					System.out.println(staff.get(aux).getNome()+ nomeProprioR.getText());
					if (numero==staff.get(aux).getIdStaff()) {	
						nomeProprioR.setText(staff.get(aux).getNome());
						birthR.setText(staff.get(aux).getDataNascimento());
						cursoAF.setText(staff.get(aux).getCargo());
						found= true;
					}
				}
			}
			else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Escolha docente ou aluno numas das caixas em baixo");
				alert.showAndWait();
				found=true;
			}
			if(!found) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Número não encontrado.\nVerifique o seu número e tente outra vez.\nSe o problema persistir Staff dirija-se aos Recurso Humanos, aluno dirija-se á secretaria da faculdade");
				alert.showAndWait();
			}
		}
		catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Introduza apenas números.");
			alert.showAndWait();
		}
	}

	/**
	   * Botão que confirma a inscrição na base de dados da biblioteca e abre a view do login
	   */
	@FXML
	private void signup() {
		int numero = Integer.parseInt(numeroEstR.getText());
		String password = passwordR.getText();
		
		User users = new User(numero,password,false);
		UserDAO.newUtil(users);

		Main.openLogin();
	}
}
