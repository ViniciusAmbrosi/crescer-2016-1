import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest {
	@Before
	public void tearDown() {
		System.gc();
		System.runFinalization();
	}

	private void mataElfo(ElfoNoturno elfo) {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Imortal", dataTerceiraEra);
		for (int i = 0; i < 92; i++)
			elfo.atirarFlecha(dwarf);
	}

	@Test
	public void adicionaElfo() {
		Elfo elfo = new Elfo("Legolas");
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfo);
		assertFalse(exercitoDeElfos.getExercito().containsValue(elfo));
	}

	@Test
	public void adicionaElfoVerde() {
		Elfo elfo = new ElfoVerde("Legolas");
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfo);
		assertTrue(exercitoDeElfos.getExercito().containsValue(elfo));
	}

	@Test
	public void adicionaElfoNoturno() {
		Elfo elfo = new ElfoNoturno("Legolas");
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfo);
		assertTrue(exercitoDeElfos.getExercito().containsValue(elfo));
	}

	@Test
	public void procuraElfoExistente() {
		Elfo elfo = new ElfoNoturno("Legolas");
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfo);
		assertTrue(exercitoDeElfos.buscarPorNome("Legolas").equals(elfo));
	}

	@Test
	public void procuraElfoNaoExistente() {
		Elfo elfo = new Elfo("Legolas");
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfo);
		assertFalse(elfo.equals(exercitoDeElfos.buscarPorNome("Legolas")));
	}

	@Test
	public void agrupaElfosPorStatus() {
		ElfoVerde elfoVivo = new ElfoVerde("Legolas");
		ElfoVerde elfoVivo1 = new ElfoVerde("Pdra");
		ElfoVerde elfoVivo2 = new ElfoVerde("Legasdlas");
		ElfoVerde elfoVivo3 = new ElfoVerde("Legolfs");
		ElfoVerde elfoVivo4 = new ElfoVerde("Legolaas");
		ElfoNoturno elfoMorto = new ElfoNoturno("Salogel");
		mataElfo(elfoMorto);
		ExercitoDeElfos exercitoDeElfos = new ExercitoDeElfos();
		exercitoDeElfos.alistaElfo(elfoVivo);
		exercitoDeElfos.alistaElfo(elfoVivo1);
		exercitoDeElfos.alistaElfo(elfoVivo2);
		exercitoDeElfos.alistaElfo(elfoVivo3);
		exercitoDeElfos.alistaElfo(elfoVivo4);
		exercitoDeElfos.alistaElfo(elfoMorto);
		exercitoDeElfos.agrupaPorStatus();
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo));
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo1));
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo2));
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo3));
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo4));
		assertTrue(exercitoDeElfos.getExercitoAgrupado().get(elfoMorto.getStatus()).contains(elfoMorto));
	}
}
