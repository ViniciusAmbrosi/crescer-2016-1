import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
	@Test
	public void criaAnaoPrimeiroConstrutor() {
		Dwarf dwarf = new Dwarf("nome");
		assertEquals("nome", dwarf.getNome());
		assertTrue(110 == dwarf.getVida());
		assertEquals(Status.VIVO, dwarf.getStatus());
		assertTrue(dwarf.getInventario() != null);
		assertEquals(1, dwarf.getDataNasc().getDia());
		assertEquals(1, dwarf.getDataNasc().getMes());
		assertEquals(1, dwarf.getDataNasc().getAno());
	}

	@Test
	public void anaoPerdeVidaMorre() {
		Dwarf dwarf = new Dwarf("nome");
		for (int i = 0; i < 12; i++)
			dwarf.perdeVida();
		assertEquals(Status.MORTO, dwarf.getStatus());
	}

	@Test
	public void anaoNaoTemVidaNegativa() {
		Dwarf dwarf = new Dwarf("nome");
		for (int i = 0; i < 13; i++)
			dwarf.perdeVida();
		assertTrue(0 == dwarf.getVida());
	}

	@Test
	public void testePerdeVida() {
		Dwarf dwarf = new Dwarf("nome");
		dwarf.perdeVida();
		assertTrue(100 == dwarf.getVida());
	}

	@Test
	public void anaoTemInventarioDataNascDefault() {
		Dwarf dwarf = new Dwarf("nome");
		assertTrue(dwarf.getInventario() != null);
		assertEquals(1, dwarf.getDataNasc().getDia());
		assertEquals(1, dwarf.getDataNasc().getMes());
		assertEquals(1, dwarf.getDataNasc().getAno());
	}

	@Test
	public void anaoNovoConstrutorDataNasc222() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(2, 2, 2);
		Dwarf dwarf = new Dwarf("nome", dataTerceiraEra);
		assertEquals("nome", dwarf.getNome());
		assertTrue(110 == dwarf.getVida());
		assertEquals(Status.VIVO, dwarf.getStatus());
		assertTrue(dwarf.getInventario() != null);
		assertEquals(2, dwarf.getDataNasc().getDia());
		assertEquals(2, dwarf.getDataNasc().getMes());
		assertEquals(2, dwarf.getDataNasc().getAno());
	}

	@Test
	public void anaoAdicionaItemInventario() {
		Dwarf dwarf = new Dwarf("nome");
		Item item = new Item(1, "espada");
		dwarf.adicionarItem(item);
		assertTrue(dwarf.getInventario().getItens().get(0) != null);
	}

	@Test
	public void anaoRemoveItemEspada() {
		Dwarf dwarf = new Dwarf("nome");
		Item espada = new Item(1, "espada");
		Item arco = new Item(1, "arco");
		dwarf.adicionarItem(espada);
		dwarf.adicionarItem(arco);
		dwarf.perderItem(espada);
		assertTrue(dwarf.getInventario().getItens().get(0) == arco);
	}

	@Test
	public void numeroSorteMenosTresMilETrintaETres() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("nome", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			dwarf.perdeVida();
		assertTrue(dwarf.getNumeroSorte() == -3333);
	}

	@Test
	public void numeroSorteTrintaETres() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2100);
		Dwarf dwarf = new Dwarf("Seixas", dataTerceiraEra);
		assertTrue(dwarf.getNumeroSorte() == 33); // 3333 / 100 = 33.33 - 33 *
													// 100 = 3300 - resto 33
	}

	@Test
	public void numeroSorteCentoEUmBiMaior() {// NascBissextoVidaMaiorQueNoventa
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Seixas", dataTerceiraEra);
		assertTrue(dwarf.getNumeroSorte() == 101);
	}

	@Test
	public void numeroSorteCentoEUmNaoBi() {// NascNaoBissextoNomeDiferenteSeixasOuMeireles
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2100);
		Dwarf dwarf = new Dwarf("Anao", dataTerceiraEra);
		assertTrue(dwarf.getNumeroSorte() == 101);
	}

	@Test
	public void dwarfGanha2Xp() { // Ano bissexto, vida entre 80 e 90
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("nome", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			dwarf.perdeVida();
		assertTrue(dwarf.getExperiencia() == 2);
	}

	@Test
	public void dwarfNaoTomaDanoSeixas() {// Ano !bissexto, Seixas ou Meireles
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2100);
		Dwarf dwarf = new Dwarf("Seixas", dataTerceiraEra);
		assertTrue(dwarf.getVida() == 110);
	}

	@Test
	public void dwarfNaoTomaDanoMeireles() {// Ano !bissexto, Seixas ou Meireles
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2100);
		Dwarf dwarf = new Dwarf("Meireles", dataTerceiraEra);
		assertTrue(dwarf.getVida() == 110);
	}

	@Test
	public void dwarfTomaDanoBi() {// Ano bissexto, nao entre 80 e 90
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("Seixas", dataTerceiraEra);
		dwarf.perdeVida();
		assertTrue(dwarf.getVida() == 100);
	}

	@Test
	public void dwarfTomaDanoNaoBi() {// Ano !bissexto, nao Seixas ou Meireles
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2100);
		Dwarf dwarf = new Dwarf("Roberto", dataTerceiraEra);
		dwarf.perdeVida();
		assertTrue(dwarf.getVida() == 100);
	}

	@Test
	public void anaoRecebeMais1000Pocoes() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarf = new Dwarf("nome", dataTerceiraEra);
		Item pocao = new Item(1, "pocao");
		dwarf.perdeVida();
		dwarf.perdeVida();
		dwarf.perdeVida();
		dwarf.adicionarItem(pocao);
		dwarf.tentarSorte();
		assertTrue(dwarf.getInventario().getItens().get(0).getQtd() == 1001);
	}

	@Test
	public void descobrirMenosVidaComDoisIguais() {
		Dwarf primeiroDwarf = new Dwarf("primeiroDwarf");
		Dwarf segundoDwarf = new Dwarf("segundoDwarf");
		assertTrue(Dwarf.descobrirMenosVida(primeiroDwarf, segundoDwarf) == segundoDwarf);
	}

	@Test
	public void descobrirMenosVidaComPrimeiroMenor() {
		Dwarf primeiroDwarf = new Dwarf("primeiroDwarf");
		primeiroDwarf.perdeVida();
		Dwarf segundoDwarf = new Dwarf("segundoDwarf");
		assertTrue(Dwarf.descobrirMenosVida(primeiroDwarf, segundoDwarf) == primeiroDwarf);
	}

	@Test
	public void descobrirMenosVidaComSegundoMenor() {
		Dwarf primeiroDwarf = new Dwarf("primeiroDwarf");
		Dwarf segundoDwarf = new Dwarf("segundoDwarf");
		segundoDwarf.perdeVida();
		assertTrue(Dwarf.descobrirMenosVida(primeiroDwarf, segundoDwarf) == segundoDwarf);
	}
}
