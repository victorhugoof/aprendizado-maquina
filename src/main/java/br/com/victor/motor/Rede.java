package br.com.victor.motor;

import java.util.Objects;

/**
 * Classe que faz a interceptação entre o motor e o controller
 */
public class Rede extends Motor {

	private static int MAX_ITERACOES = 10000;
	private static Motor bp = new Motor();
	private static int count = 0;

	private static final float[] LETRA_A = new float[]{1, 0, 0, 0, 0, 0, 0};
	private static final float[] LETRA_B = new float[]{0, 1, 0, 0, 0, 0, 0};
	private static final float[] LETRA_C = new float[]{0, 0, 1, 0, 0, 0, 0};
	private static final float[] LETRA_D = new float[]{0, 0, 0, 1, 0, 0, 0};
	private static final float[] LETRA_E = new float[]{0, 0, 0, 0, 1, 0, 0};
	private static final float[] LETRA_J = new float[]{0, 0, 0, 0, 0, 1, 0};
	private static final float[] LETRA_K = new float[]{0, 0, 0, 0, 0, 0, 1};

	public static String executa(String inputText) throws Exception {
		return letra(bp.buscaSaida(converteEntrada(inputText)));
	}

	public static void treina() throws Exception {
		for (int i = 0; i <= 100; i++) {
			treinaLetraA();
			treinaLetraB();
			treinaLetraC();
			treinaLetraD();
			treinaLetraE();
			treinaLetraJ();
			treinaLetraK();
		}
	}

	private static void treinaLetraA() throws Exception {
		executaTreino("..##......#......#.....#.#....#.#...#####..#...#..#...#.###.###", LETRA_A);
		executaTreino("...#......#.....#.#....#.#...#...#..#####.#.....###...##.#...#.", LETRA_A);
		executaTreino("...#......#.....#.#....#.#...#...#..#####.#.....##.....###...##", LETRA_A);
	}

	private static void treinaLetraB() throws Exception {
		executaTreino("######..#....#.#....#.#....#.#####..#....#.#....#.#....#######.", LETRA_B);
		executaTreino("######.#.....##.....##.....#######.#.....##.....##.....#######.", LETRA_B);
		executaTreino("######..#....#.#....#.#####..#....#.#....#.#....#.#....#######.", LETRA_B);
	}

	private static void treinaLetraC() throws Exception {
		executaTreino("..#####.#....##......#......#......#......#.......#....#..####.", LETRA_C);
		executaTreino("..###...#...#.#.....##......#......#......#.....#.#...#...###..", LETRA_C);
		executaTreino("..###.#.#...###.....##......#......#......#.....#.#...#...###..", LETRA_C);
	}

	private static void treinaLetraD() throws Exception {
		executaTreino("#####...#...#..#....#.#....#.#....#.#....#.#....#.#...#.#####..", LETRA_D);
		executaTreino("#####..#....#.#.....##.....##.....##.....##.....##....#.#####..", LETRA_D);
	}

	private static void treinaLetraE() throws Exception {
		executaTreino("#######.#....#.#......#.#....###....#.#....#......#....########", LETRA_E);
		executaTreino("########......#......#......#####..#......#......#......#######", LETRA_E);
		executaTreino("#######.#....#.#..#...####...#..#...#......#......#....########", LETRA_E);
	}

	private static void treinaLetraJ() throws Exception {
		executaTreino("...####.....#......#......#......#......#..#...#..#...#...###..", LETRA_J);
		executaTreino(".....#......#......#......#......#......#..#...#..#...#...###..", LETRA_J);
		executaTreino("....###.....#......#......#......#......#......#..#...#...###..", LETRA_J);
	}

	private static void treinaLetraK() throws Exception {
		executaTreino("###..##.#..#...#.#....##.....##.....#.#....#..#...#...#.###..##", LETRA_K);
		executaTreino("#.....##...#..#..#...#.#....##.....#..#...#...#..#....#.#.....#", LETRA_K);
		executaTreino("###..##.#...#..#..#...#.#....##.....#.#....#..#...#...#.###..##", LETRA_K);
	}

	public static void executaTreino(String inputText, float... saida) throws Exception {

		boolean parada = false;
		float[] entrada = converteEntrada(inputText);

		while (!parada) {
			count++;
			bp.executaTreino(entrada, saida);
			float[] retorno = bp.buscaSaida(entrada);

			geraCaixaLog(count, entrada, retorno);
			parada = equal(retorno, saida) || count > MAX_ITERACOES;
		}
	}

	private static float[] converteEntrada(String inputText) throws Exception {
		if (inputText.length() != TAMANHO_ENTRADA) {
			throw new Exception("Entrada inválida");
		}

		char[] input = inputText.toCharArray();
		float[] entrada = new float[TAMANHO_ENTRADA];

		for (int i = 0; i < entrada.length; i++) {
			if (input[i] == '#') {
				entrada[i] = 1;
			} else if (input[i] == '.') {
				entrada[i] = -1;
			} else {
				entrada[i] = 0;
			}
		}

		return entrada;
	}

	private static boolean equal(float[] saida, float[] alvo) {
		if (saida.length != alvo.length) {
			return false;
		}

		boolean equal = true;
		for (int i = 0; i < saida.length; i++) {
			equal = equal && (Math.round(saida[i]) == Math.round(alvo[i]));
		}

		return equal;
	}

	private static String split(float[] r) {
		String resultado = "";
		for (float i : r) {
			resultado += Math.round(i) + ", ";
		}
		resultado = resultado.substring(0, resultado.length() - 2);
		return resultado;
	}

	private static String separador(int lenght, String text) {
		String separador = "+";
		String adicional = "-";
		String add = separador;

		if (Objects.nonNull(text)) {
			separador = text;
			adicional = " ";
			add = "|";
			lenght = lenght - text.length() + 1;
		}

		for (int i = 0; i < lenght - 2; i++) {
			separador += adicional;
		}
		return separador + add;
	}

	private static void geraCaixaLog(int count, float[] entrada, float[] retorno) {
		String logEntrada = String.format("| Entrada: %s |", split(entrada));
		int length = logEntrada.length();
		String logSaida = separador(length, String.format("| Saída: %s", letra(retorno)));
		String separador = separador(length, null);
		String contador = separador(length, "| #" + count);

		System.out.println(separador);
		System.out.println(contador);
		System.out.println(logEntrada);
		System.out.println(logSaida);
		System.out.println(separador);
	}

	private static String letra(float[] buscaSaida) {
		String letra = "NÃO IDENTIFICADO";

		if (equal(buscaSaida, LETRA_A)) {
			letra = "LETRA A";
		} else if (equal(buscaSaida, LETRA_B)) {
			letra = "LETRA B";
		} else if (equal(buscaSaida, LETRA_C)) {
			letra = "LETRA C";
		} else if (equal(buscaSaida, LETRA_D)) {
			letra = "LETRA D";
		} else if (equal(buscaSaida, LETRA_E)) {
			letra = "LETRA E";
		} else if (equal(buscaSaida, LETRA_J)) {
			letra = "LETRA J";
		} else if (equal(buscaSaida, LETRA_K)) {
			letra = "LETRA K";
		}

		return String.format("%s (%s)", letra, split(buscaSaida));
	}

}
