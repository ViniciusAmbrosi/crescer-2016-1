import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest {

	@Before
	public void tearDown() {
		System.gc();
		System.runFinalization();
	}

	private ArrayList<Dwarf> factoryDwarfs(int anoes) {
		ArrayList<Dwarf> dwarfs = new ArrayList<>();
		for (int i = 0; i < anoes; i++) {
			dwarfs.add(new Dwarf("Anao" + i));
		}
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
		DataTerceiraEra dateTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Imortal", dateTerceiraEra);
		for (Elfo elfo : exercitoDeElfos.getExercito().values()) {
			if (mataQuantos-- <= 0)
				break;
			for (int i = 0; i < 92; i++)
				elfo.atirarFlecha(dwarf);
		}
	}

	private boolean ataqueFoiIntercalado(ArrayList<Elfo> elfos) {
		Elfo previous = new Elfo("testador");
		for (Elfo elfo : elfos)
			if (elfo.getClass().equals(previous.getClass()))
				return false;
		return true;
	}

	@Test
	public void dezElfosAtacam6Anoes() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void dezElfosNoturnosAtacam6Anoes() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnao() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void passaListaDwarfNulo() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void passaExercitoVazio() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void passa0Anoes() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void passaUmElfoNulo() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacar() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 200);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void intercalaElfoNoturnoAtaca() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void zeroElfosVerdes() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void zeroElfosNoturnos() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void cincoElfosMortos() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(10, 15);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void todosElfosMortos() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 5);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void dezElfosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void dezElfosNoturnosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnaoNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void passaListaDwarfNuloNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void passaExercitoVazioNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void passa0AnoesNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void passaUmElfoNuloNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacarNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(200, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void intercalaElfoNoturnoAtacaNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void zeroElfosVerdesNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void zeroElfosNoturnosNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}

	@Test
	public void cincoElfosMortosNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(15, 10);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ataqueFoiIntercalado(ordemAtaque));
	}

	@Test
	public void todosElfosMortosNoturnosPrimeiro() {
		Estrategia strat = new AtaqueIntercalado();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 0);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtaque.isEmpty());
	}
}
