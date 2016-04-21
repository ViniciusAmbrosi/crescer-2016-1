import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArteDaGuerraTest {

	@Before
	public void tearDown() {
		System.gc();
		System.runFinalization();
	}

	/* já recebe valor de elfos esperados em cima de intençoes de atk */
	private boolean ordemAtqEhValida(ArrayList<Elfo> ordem, double totalElfosNoturnosEsperados) {
		int elfosNoturnosAtacaram = 0;
		for (Elfo elfo : ordem)
			if (elfo instanceof ElfoNoturno)
				elfosNoturnosAtacaram++;
		if (elfosNoturnosAtacaram == totalElfosNoturnosEsperados)
			return true;
		else
			return false;
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
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Imortal", dataTerceiraEra);
		for (Elfo elfo : exercitoDeElfos.getExercito().values()) {
			if (mataQuantos-- <= 0)
				break;
			for (int i = 0; i < 92; i++)
				elfo.atirarFlecha(dwarf);
		}
	}

	@Test
	public void dezElfosAtacam6Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void dezElfosNoturnosAtacam6Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnao() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void passaListaDwarfNulo() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passaExercitoVazio() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passa0Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passaUmElfoNulo() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(7, 3);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacar() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 200);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 60));
	}

	@Test
	public void nenhumElfoNoturnoAtaca() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void zeroElfosVerdes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 2));
	}

	@Test
	public void zeroElfosNoturnos() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void cincoElfosMortos() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosVerdesPrimeiro(0, 15);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void dezElfosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void dezElfosNoturnosAtacam6AnoesNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnaoNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void passaListaDwarfNuloNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passaExercitoVazioNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passa0AnoesNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void passaUmElfoNuloNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(3, 7);
		exercitoDeElfos.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacarNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(200, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 60));
	}

	@Test
	public void nenhumElfoNoturnoAtacaNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void zeroElfosVerdesNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 2));
	}

	@Test
	public void zeroElfosNoturnosNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 0));
	}

	@Test
	public void cincoElfosMortosNoturnosPrimeiro() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos exercitoDeElfos = factoryElfosNoturnosPrimeiro(15, 0);
		mataElfos(exercitoDeElfos, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		exercitoDeElfos.agrupaPorStatus();
		strat.atacar(exercitoDeElfos.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtaque = strat.getOrdemDoUltimoAtaque();
		assertTrue(ordemAtqEhValida(ordemAtaque, 3));
	}
}
