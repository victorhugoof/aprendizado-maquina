package br.com.victor.motor;

/**
 * Responsável por calcular a rede
 */
public class Motor {

	protected static float TAXA_APRENDIZADO = 0.2f;
	protected static int TAMANHO_ENTRADA = 63;
	protected static int TAMANHO_INTERMEDIARIA = 63;
	protected static int TAMANHO_SAIDA = 7;

	protected Camada[] camadas;

	protected Motor() {
		camadas = new Camada[2];
		camadas[0] = new Camada(TAMANHO_ENTRADA, TAMANHO_INTERMEDIARIA); //entrada x intermediaria
		camadas[1] = new Camada(TAMANHO_INTERMEDIARIA, TAMANHO_SAIDA); //intermediaria x saida
	}

	protected float[] buscaSaida(float[] entrada) {
		float[] ativacoes = entrada;

		for (int i = 0; i < camadas.length; i++) {
			ativacoes = camadas[i].executa(ativacoes);
		}
		return ativacoes;
	}

	protected void executaTreino(float[] entrada, float[] alvo) {
		float[] saida = buscaSaida(entrada);
		float[] error = new float[saida.length];

		for (int i = 0; i < error.length; i++) {
			error[i] = alvo[i] - saida[i];
		}

		for (int i = camadas.length - 1; i >= 0; i--) {
			error = camadas[i].treina(error, TAXA_APRENDIZADO);
		}
	}

}
