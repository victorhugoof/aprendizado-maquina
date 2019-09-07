package br.com.victor.views.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador da tela principal
 */
public class PrincipalController implements Initializable {

	@FXML
	private TextArea txtEntrada;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		txtEntrada.setText("Hello World!");
	}

}
