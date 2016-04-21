import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NoturnosPorUltimoTest {

	@Before
	public void tearDown() {
		System.gc();
		System.runFinalization();
	}

	private ArrayList<Dwarf> factoryDwarfs(int anoes) {
		ArrayList<Dwarf> dwarfs = new ArrayList<>();
		for (int i = 0; i < anoes; i++)
			dwarfs.add(new Dwarf("Anao" + i));
		return dwarfs;
	}

	private ExercitoDeElfos factoryElfosVerdesPrimeiro(int elfosVerdes, int elfosNoturnos) {
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		for (int i = 0; i < elfosVerdes; i++)
			exercitoDeElfos.alistaElfo(new ElfoVerde("ElfoVerde" + i));
		for (int i = 0; i < elfosNoturnos; i++)
			exercitoDeElfos.alistaElfo(new ElfoNoturno("ElfoNortuno" + i));
		return exercitoDeElfos;
	}

	private ExercitoDeElfos factoryElfosNoturnosPrimeiro(int elfosNoturnos, int elfosVerdes) {
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		for (int i = 0; i < elfosNoturnos; i++)
			exercitoDeElfos.alistaElfo(new ElfoNoturno("ElfoNoturno" + i));
		for (int i = 0; i < elfosVerdes; i++)
			exercitoDeElfos.alistaElfo(new ElfoVerde("ElfoVerde" + i));
		return exercitoDeElfos;
	}

	private void mataElfos(ExercitoDeElfos exercitoDeElfos, int mataQuantos) {
		DataTerceiraEra dte = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Imortal", dte);
		for (Elfo elfo : exercitoDeElfos.getExercito().values()) {
			if (mataQuantos-- <= 0)
				break;
			for (int i = 0; i < 92; i++)
				elfo.atirarFlecha(dwarf);
		}
	}

	private boolean sohElfosVerde(ArrayList<Elfo> elfos, int quantosElfosVerdes) { // Recebe
																					// qtd
																					// de
																					// ElfoVerdes
																					// e
																					// ve
																					// se
																					// até
																					// n
																					// é
																					// verde
		for (Elfo elfo : elfos) {
			if (quantosElfosVerdes-- <= 0)
				return true;
			if (!(elfo instanceof ElfoVerde))
				return false;
		}
		return true;
	}

	@Test
	public void dezElfosAtacam6Anoes() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 7)); // Enviaqtd de ElfoVerdes e
													// ve se até n é verde
		assertEquals(10, ordemAtaque.size()); // Verifica se os noturnos tambem
												// atacaram, vendo a quantidade
												// total de elfos na ordem de
												// atk.
	}

	@Test
	public void dezElfosNoturnosAtacam6Anoes() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnao() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 5));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void passaListaDwarfNulo() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passaExercitoVazio() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passa0Anoes() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 10));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passaUmElfoNulo() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 7));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacar() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 200);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 1));
		assertEquals(201, ordemAtaque.size());
	}

	@Test
	public void umElfoNoturnoAtaca() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 1));
		assertEquals(2, ordemAtaque.size());
	}

	@Test
	public void zeroElfosVerdes() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(5, ordemAtaque.size());
	}

	@Test
	public void zeroElfosNoturnos() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 5));
		assertEquals(5, ordemAtaque.size());
	}

	@Test
	public void cincoElfosMortos() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 15);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void dezElfosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 7));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void dezElfosNoturnosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnaoNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 5));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void passaListaDwarfNuloNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passaExercitoVazioNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passa0AnoesNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 10));
		assertEquals(0, ordemAtaque.size());
	}

	@Test
	public void passaUmElfoNuloNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 7));
		assertEquals(10, ordemAtaque.size());
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacarNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(200, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 1));
		assertEquals(201, ordemAtaque.size());
	}

	@Test
	public void umElfoNoturnoAtacaNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 1));
		assertEquals(2, ordemAtaque.size());
	}

	@Test
	public void zeroElfosVerdesNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(5, ordemAtaque.size());
	}

	@Test
	public void zeroElfosNoturnosNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 5));
		assertEquals(5, ordemAtaque.size());
	}

	@Test
	public void cincoElfosMortosNoturnosPrimeiro() {
		Estrategia strat = new NoturnosPorUltimo();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(15, 0);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(sohElfosVerde(ordemAtaque, 0));
		assertEquals(10, ordemAtaque.size());
	}
}
