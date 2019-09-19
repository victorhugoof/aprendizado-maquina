package br.com.victor.motor;

import br.com.victor.math.BigDecimalMath;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Backpropagation {

	public static void executa(String input) {
		List<Double> lista = new ArrayList<>();

		for (char c : input.toCharArray()) {
			Double in = 0D;

			if (c == '#') {
				in = 1D;
			} else if (c == '.') {
				in = -1D;
			}

			lista.add(in);
		}

		if (lista.size() != QUANTIDADE_ENTRADA) {
			throw new RuntimeException("Entrada inválida: " + lista.size());
		}

		Backpropagation backpropagation = new Backpropagation(lista.toArray(new Double[0]), new Double[]{0D, 0D, 0D, 1D, 0D, 0D, 0D});

		System.out.println("FIM");
	}

	private static Integer QUANTIDADE_ENTRADA = 63;
	private static Integer QUANTIDADE_SAIDA = 7;
	private static Double[][] v; 	/** Pesos 63x63 */
	private static Double[][] w; 	/** Pesos intermediario 63x7 */

	private Double[] x; 			/** Entrada 63 */

	private Double[] z;				/** Camada intermediaria 63 */
	private Double[] zIn;

	private Double[] y;				/** Saida 7 */
	private Double[] yIn;

	private Double[] t;			/** Target para treinamento */

	private Backpropagation(Double[] entrada, Double[] alvo) {
		this.x = entrada;

		this.z = new Double[QUANTIDADE_ENTRADA];
		this.zIn = new Double[QUANTIDADE_ENTRADA];

		this.y = new Double[QUANTIDADE_SAIDA];
		this.yIn = new Double[QUANTIDADE_SAIDA];

		this.t = alvo;

		if (Objects.isNull(v) &&  Objects.isNull(w)) {
			this.v = new Double[QUANTIDADE_ENTRADA][QUANTIDADE_ENTRADA];
			this.w = new Double[QUANTIDADE_ENTRADA][QUANTIDADE_SAIDA];

			inicializaPesosAleatorio(v);
			inicializaPesosAleatorio(w);
		}

		calculaSaida();

		if (Objects.nonNull(alvo)) {
			calculaAlvo();
		}
	}

	/**
	 * Método que calcula alvo
	 */
	private void calculaAlvo() {
		while (!t.equals(y)) {

			for (Double ze : z) {
				System.out.print(ze + " | ");
			}
			System.out.println("");

			for (Double ye : y) {
				System.out.print(ye + " | ");
			}
			System.out.println("");
			System.out.println("------------------");

			arrumaPesos();
			calculaSaida();
			return;
		}
	}
	private void arrumaPesos() {
		Double[] erroW = new Double[y.length];
		for (int k = 0; k < y.length; k++) {
			Double target = t[k];
			Double saida = y[k];
			Double saidaIn = yIn[k];

			erroW[k] = (target - saida) * funcaoDerivadaSigmoide(saidaIn);
		}

		for (int k = 0; k < y.length; k++) {
			for (int j = 0; j < w.length; j++) {
				w[j][k] = w[j][k] + (erroW[k] * z[j]);
			}
		}

		Double erroV[] = new Double[z.length];
		for (int j = 0; j < z.length; j++) {
			Double inJ = 0D;

			for (int k = 0; k < y.length; k++) {
				inJ += w[j][k];
			}
			erroV[j] = inJ;
		}

		for (int j = 0; j < z.length; j++) {
			for (int i = 0; i < v.length; i++) {
				v[i][j] = v[i][j] + (erroV[j] * x[i]);
			}
		}

	}

	/**
	 * Método que calcula
	 */
	private void calculaSaida() {
		calculaCamada(z, zIn, x, v);
		calculaCamada(y, yIn, z, w);
	}

	/**
	 * Calcula uma camada destino informando a entrada e pesos
	 * @param destino
	 * @param entrada
	 * @param pesos
	 */
	private void calculaCamada(Double[] destino, Double destinoIn[], Double[] entrada, Double[][] pesos) {
		for (int j = 0; j < destino.length; j++) {
			Double in = 0D;

			for (int i = 0; i < entrada.length; i++) {
				Double ent = entrada[i];
				Double peso = pesos[i][j];

				in += (ent * peso);
			}

			destinoIn[j] = in;
			destino[j] = funcaoSigmoide(in);
		}
	}

	/**
	 * Inicializa os pesos
	 */
	private void inicializaPesosAleatorio(Double[][] pesos) {

		for (int i = 0; i < pesos.length; i++) {
			for (int j = 0; j < pesos[0].length; j++) {
				pesos[i][j] = Double.valueOf(Math.random());
			}
		}
	}

	/**
	 * Inicializa os pesos
	 */
	private void logPesos(Double[][] pesos) {

		for (int i = 0; i < pesos.length; i++) {
			for (int j = 0; j < pesos[0].length; j++) {
				System.out.print(pesos[i][j] + " | ");
			}
		}

		System.out.println("");
		System.out.println("-----------------------------------------------------------------");
	}

	/**
	 * Calcula funcao sigmoide
	 * @param x
	 * @return
	 */
	private Double funcaoSigmoide(Double x) {
		Double exp = Math.exp(BigDecimal.valueOf(x).negate().doubleValue());
		Double value = (2 / (1 + exp)) - 1;
		return value;
	}

	/**
	 * Derivada
	 * @param x
	 * @return
	 */
	private Double funcaoDerivadaSigmoide(Double x) {
		BigDecimal sigmoide = BigDecimal.valueOf(funcaoSigmoide(x));
		return BigDecimal.valueOf(0.5).multiply(BigDecimal.ONE.add(sigmoide)).multiply(BigDecimal.ONE.subtract(sigmoide)).setScale(4, RoundingMode.HALF_EVEN).doubleValue();

	}
}
