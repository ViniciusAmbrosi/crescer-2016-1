import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest {
	@Test
	public void retorna180DiferencaProtudosMinimoMultiplo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(15, 18)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 180);
	}

	@Test
	public void retorna0DiferencaProtudosMinimoMultiplo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(4, 5)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna660DiferencaProtudosMinimoMultiplo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(12, 60)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 660);
	}

	@Test
	public void retorna840DiferencaProtudosMinimoMultiplo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(15, 18)));
		divida.add(new ArrayList<>(Arrays.asList(4, 5)));
		divida.add(new ArrayList<>(Arrays.asList(12, 60)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 840);
	}

	@Test
	public void retorna0ArrayListVazio() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna0PrimeiroValorDoParZero() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(0, 18)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna0SegundoValorDoParZero() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(4, 0)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna0AmbosValorerDoParZero() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(0, 0)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna840ComParesComZero() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(15, 18)));
		divida.add(new ArrayList<>(Arrays.asList(0, 18)));
		divida.add(new ArrayList<>(Arrays.asList(4, 5)));
		divida.add(new ArrayList<>(Arrays.asList(4, 0)));
		divida.add(new ArrayList<>(Arrays.asList(12, 60)));
		divida.add(new ArrayList<>(Arrays.asList(0, 0)));
		assertTrue(hobbitContador.calcularDiferenca(divida) == 840);
	}

	@Test
	public void retorna0ArrayListNulo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = null;
		assertTrue(hobbitContador.calcularDiferenca(divida) == 0);
	}

	@Test
	public void retorna840ComParesComZeroEParNulo() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
		divida.add(new ArrayList<>(Arrays.asList(15, 18)));
		divida.add(new ArrayList<>(Arrays.asList(0, 18)));
		divida.add(new ArrayList<>(Arrays.asList(4, 5)));
		divida.add(new ArrayList<>(Arrays.asList(4, 0)));
		divida.add(new ArrayList<>(Arrays.asList(12, 60)));
		divida.add(new ArrayList<>(Arrays.asList(0, 0)));
		divida.add(null);
		assertTrue(hobbitContador.calcularDiferenca(divida) == 840);
	}

	@Test
	public void retorna9MaiorMultiplo10() {
		HobbitContador hobbitContador = new HobbitContador();
		assertTrue(hobbitContador.obterMaiorMultiploDeTresAte(10) == 9);
	}

	@Test
	public void retorna18MaiorMultiplo20() {
		HobbitContador hobbitContador = new HobbitContador();
		assertTrue(hobbitContador.obterMaiorMultiploDeTresAte(20) == 18);
	}

	@Test
	public void retorna0MaiorMultiplo0() {
		HobbitContador hobbitContador = new HobbitContador();
		assertTrue(hobbitContador.obterMaiorMultiploDeTresAte(0) == 0);
	}

	@Test
	public void retorna0369MultiplosDeTres10() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<Integer> multiplo = hobbitContador.obterMultiplosDeTresAte(10);
		assertTrue(multiplo.get(0) == 0);
		assertTrue(multiplo.get(1) == 3);
		assertTrue(multiplo.get(2) == 6);
		assertTrue(multiplo.get(3) == 9);
	}

	@Test
	public void retorna0MultiplosDeTres0() {
		HobbitContador hobbitContador = new HobbitContador();
		ArrayList<Integer> multiplo = hobbitContador.obterMultiplosDeTresAte(0);
		assertTrue(multiplo.get(0) == 0);
	}
}
