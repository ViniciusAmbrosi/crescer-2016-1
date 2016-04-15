import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArteDaGuerraTest {

	private ArrayList<Dwarf> factoryDwarfs(int anoes) {
		ArrayList<Dwarf> dwarfs = new ArrayList<>();
		for (int i = 0; i < anoes; i++)
			dwarfs.add(new Dwarf("Anao" + i));
		return dwarfs;
	}

	private ExercitoDeElfos factoryElfos(int elfosVerdes, int elfosNoturnos) {
		ExercitoDeElfos ede = new ExercitoDeElfos();
		for (int i = 0; i < elfosVerdes; i++)
			ede.alistaElfo(new ElfoVerde("ElfoVerde" + i));
		for (int i = 0; i < elfosNoturnos; i++)
			ede.alistaElfo(new ElfoNoturno("ElfoNortuno" + i));
		return ede;
	}

	private void mataElfos(ExercitoDeElfos ede, int mataQuantos) {
		DataTerceiraEra dte = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Imortal", dte);
		for (Elfo elfo : ede.getExercito().values()) {
			if (mataQuantos-- <= 0)
				break;
			for (int i = 0; i < 92; i++)
				elfo.atirarFlecha(dwarf);
		}
	}

	@Test
	public void dezElfosAtacam6Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(7, 3);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		ede.agrupaPorStatus();
	    strat.atacar(ede.getExercitoAgrupado(), dwarfs); 		
	    ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(10, ordemAtq.size());
	}

	@Test
	public void dezElfosNoturnosAtacam6Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(0, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(6);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 		
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(3, ordemAtq.size());
	}

	@Test
	public void cincoElfosVerdesCincoElfoNoturnoAtacaUmAnao() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(5, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 		
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(8, ordemAtq.size());
	}

	@Test
	public void passaListaDwarfNulo() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(5, 5);
		ArrayList<Dwarf> dwarfs = null;
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(0, ordemAtq.size());
	}

	@Test
	public void passaExercitoVazio() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(0, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(0, ordemAtq.size());
	}

	@Test
	public void passa0Anoes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(10, 10);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(0);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(0, ordemAtq.size());
	}

	@Test
	public void passaUmElfoNulo() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(7, 3);
		ede.alistaElfo(null);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 	
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(10, ordemAtq.size());
	}

	@Test
	public void duzentosElfosNoturnosTentamAtacar() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(1, 200);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 	
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(61, ordemAtq.size());
	}

	@Test
	public void nenhumElfoNoturnoAtaca() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(1, 1);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(1);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 	
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(1, ordemAtq.size());
	}

	@Test
	public void zeroElfosVerdes() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(0, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 	
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(2, ordemAtq.size());
	}

	@Test
	public void zeroElfosNoturnos() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(5, 0);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs);
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(5, ordemAtq.size());
	}

	@Test
	public void cincoElfosMortos() {
		Estrategia strat = new ArteDaGuerra();
		ExercitoDeElfos ede = factoryElfos(0, 15);
		mataElfos(ede, 5);
		ArrayList<Dwarf> dwarfs = factoryDwarfs(5);
		ede.agrupaPorStatus();
		strat.atacar(ede.getExercitoAgrupado(), dwarfs); 		
		ArrayList<Elfo> ordemAtq = strat.getOrdemDoUltimoAtaque();
		assertEquals(3, ordemAtq.size());
	}
}
