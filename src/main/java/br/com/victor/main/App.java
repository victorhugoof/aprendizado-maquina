package br.com.victor.main;

import br.com.victor.motor.Backpropagation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Classe responsável por startar a aplicação
 */
public class App extends Application {

	public static void main(String[] args) {
//		launch(args);
		Backpropagation.executa("#####...#...#..#....#.#....#.#....#.#....#.#....#.#...#.#####..");
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = FXMLLoader.load(getClass().getResource("/br/com/victor/views/main/Principal.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Aprendizado de Máquina");
		stage.show();
	}

}
