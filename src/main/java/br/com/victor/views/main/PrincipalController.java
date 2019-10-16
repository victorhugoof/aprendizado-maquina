package br.com.victor.views.main;

import br.com.victor.motor.Rede;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

/**
 * Controlador da tela principal
 */
public class PrincipalController {

	@FXML
	private TextArea txtEntrada;

	@FXML
	public void identifica() {
		String letra = txtEntrada.getText().replaceAll("\n", "");

		try {
			showMessage(Rede.executa(letra));
		} catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	@FXML
	public void executaTreino() {
		try {
			Rede.treina();
			showMessage("Treino finalizado");
		} catch (Exception e) {
			showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	@FXML
	public void abrirArquivo() {
		FileChooser fileChooser = new FileChooser();
		File file = new File("/");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo de Texto (.txt)","*.txt"));

		fileChooser.setInitialDirectory(file);
		File selecionado = fileChooser.showOpenDialog(null);

		if (Objects.nonNull(selecionado)) {
			lerArquivo(selecionado);
		}
	}

	private void showMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}

	private void lerArquivo(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String texto = null;

			while ((texto = reader.readLine()) != null) {
				txtEntrada.appendText(texto + "\r\n");
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
