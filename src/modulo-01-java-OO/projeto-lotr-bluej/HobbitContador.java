import java.util.*;

public class HobbitContador {
	public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
		int produtoPares = 1;
		int mmcPares = 0;
		int produtosMenosMmc = 0;
		if (arrayDePares == null)
			return 0;
		while (arrayDePares.contains(null)) // retira pares nulos
			arrayDePares.remove(null);
		for (ArrayList<Integer> pares : arrayDePares) {
			int primeiroNumero = pares.get(0);
			int segundoNumero = pares.get(1);
			mmcPares = new Calculador(primeiroNumero, segundoNumero).mmc();
			produtoPares = primeiroNumero * segundoNumero;
			produtosMenosMmc += produtoPares - mmcPares;
		}
		return produtosMenosMmc;
	}

	public int obterMaiorMultiploDeTresAte(int numero) {
		int maior = 0;
		for (int i = numero; i >= 0; i--) {
			if (i % 3 == 0 && i > maior) {
				maior = i;
				break;
			}
		}
		return maior;
	}

	public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
		ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
		for (int i = 3; i <= numero; i += 3) {
			if (i % 3 == 0)
				multiplos.add(i);
		}
		return multiplos;
	}

	private class Calculador {
		private int primeiroNumero, segundoNumero;

		public Calculador(int primeiroNumero, int segundoNumero) {
			this.primeiroNumero = primeiroNumero;
			this.segundoNumero = segundoNumero;
		}

		private int mmc() {
			if (segundoNumero == 0)
				return 0;
			int aux = primeiroNumero;
			while (primeiroNumero % segundoNumero != 0)
				primeiroNumero += aux;
			return primeiroNumero;
		}
	}
}
