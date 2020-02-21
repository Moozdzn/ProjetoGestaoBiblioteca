package pt.europeia.Bibliotech;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pt.europeia.Bibliotech.controllers.FirstController;
import pt.europeia.Bibliotech.controllers.LoginController;
import pt.europeia.Bibliotech.controllers.MainController;
import pt.europeia.Bibliotech.controllers.RegisterBookController;
import pt.europeia.Bibliotech.controllers.RegistoController;
import pt.europeia.Bibliotech.controllers.ResHistoryController;
import pt.europeia.Bibliotech.controllers.ReservarController;
import pt.europeia.Bibliotech.models.Livro;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
* Bibliotech implementa um aplicação que gere os livros da bibliotecas de uma faculdade. Trata reservas e requisitos. 
* Está ligada a API da Google Books para uma fácil inserção de livros na base de dados da própria biblioteca.
*
* @author  Diogo Santos, Hugo Varela, João Cardo
* @version 0.5
* @since   2018-09-15
*/

public class Main extends Application {

	private static Stage mainStage;

	@Override
	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		mainStage.setScene(new Scene(new Pane()));
		// openMain();
		openView();
		mainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void openView() {
		Object controller = new FirstController();
		String urlStr = "views/FirstView.fxml";
		openWindow(controller, urlStr);
	}

	public static void openRegisterBook(int username) {
		Object controller = new RegisterBookController(username);
		String urlStr = "views/RegisterBookView.fxml";
		openWindow(controller, urlStr);
	}

	public static void openLogin() {

		Object controller = new LoginController();
		String urlStr = "views/LoginView.fxml";
		openWindow(controller, urlStr);
	}
	public static void openResHistory(int username) {
		Object controller = new ResHistoryController(username);
		String urlStr = "views/ResHistory.fxml";
		openWindow(controller, urlStr);
	}

	public static void openRegisto() {

		Object controller = new RegistoController();
		String urlStr = "views/registoView.fxml";
		openWindow(controller, urlStr);
	}

	/*
	 * public static void openMain() { Object controller = new MainController();
	 * String urlStr = "views/MainView.fxml"; openWindow(controller, urlStr); }
	 */
	public static void openMain(int username) {
		Object controller = new MainController(username);
		String urlStr = "views/MainView.fxml";
		openWindow(controller, urlStr);
	}

	public static void openReservar(Livro livro,int username) {
		Object controller = new ReservarController(livro,username);
		String urlStr = "views/ReservarView.fxml";
		openWindow(controller, urlStr);
	}

	private static void openWindow(Object controller, String urlStr) {
		try {
			URL path = Main.class.getResource(urlStr);
			FXMLLoader loader = new FXMLLoader(path);
			loader.setController(controller);
			Parent root = loader.load();

			Scene scene = mainStage.getScene();
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			scene.setRoot(root);
			mainStage.sizeToScene();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
