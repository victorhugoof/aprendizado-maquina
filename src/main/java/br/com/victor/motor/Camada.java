package br.com.victor.motor;

import java.util.Arrays;
import java.util.Random;

/**
 * Cada camada da rede (entrada X peso X saida)
 */
public class Camada {

	private float[] entrada;
	private float[] saida;
	private float[][] pesos;
	private float[][] deltas;
	private Random random;

	public Camada(int entrada, int saida) {
		this.saida = new float[saida];
		this.entrada = new float[entrada];
		this.pesos = new float[entrada][saida];
		this.deltas = new float[entrada][saida];
		this.random = new Random();

		inicializaPesosRandom();
	}

	private void inicializaPesosRandom() {
		for (int i = 0; i < pesos.length; i++) {
			for (int j = 0; j < pesos[i].length; j++) {
				pesos[i][j] = (random.nextFloat() - 0.5f) * 2f;
			}
		}
	}

	public float[] executa(float[] ativacoes) {
		System.arraycopy(ativacoes, 0, entrada, 0, ativacoes.length);

		for (int i = 0; i < saida.length; i++) {
			for (int j = 0; j < entrada.length; j++) {
				saida[i] += pesos[j][i] * entrada[j];
			}
			saida[i] = ativacao(saida[i]);
		}

		return Arrays.copyOf(saida, saida.length);
	}

	public float[] treina(float[] error, float taxaAprendizado) {
		float[] proximoErro = new float[entrada.length];

		for (int i = 0; i < saida.length; i++) {
			float delta = error[i] * derivada(saida[i]);

			for (int j = 0; j < entrada.length; j++) {
				proximoErro[j] += pesos[j][i] * delta;

				float dw = entrada[j] * delta * taxaAprendizado;
				pesos[j][i] += deltas[j][i] + dw;
				deltas[j][i] = dw;
			}
		}

		return proximoErro;
	}

	public float ativacao(float x) {
		return (float) (1 / (1 + Math.exp(-x)));
	}

	public float derivada(float x) {
		return x * (1 - x);
	}

}
