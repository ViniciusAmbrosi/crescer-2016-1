import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest {
	@Test
	public void anaoGanha6000Chapeus() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		IrishDwarf irishDwarf = new IrishDwarf("irishDwarf", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			irishDwarf.perdeVida();
		irishDwarf.adicionarItem(new Item(3, "chapéus"));
		irishDwarf.tentarSorte();
		assertTrue(6003 == irishDwarf.getInventario().getItens().get(0).getQtd());
	}

	@Test
	public void anaoGanha15015Pocoes() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		IrishDwarf irishDwarf = new IrishDwarf("irishDwarf", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			irishDwarf.perdeVida();
		irishDwarf.adicionarItem(new Item(5, "Poções"));
		irishDwarf.tentarSorte();
		assertTrue(15005 == irishDwarf.getInventario().getItens().get(0).getQtd());
	}

	@Test
	public void anaoGanha6000ChapeusE15015Pocos() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		IrishDwarf irishDwarf = new IrishDwarf("irishDwarf", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			irishDwarf.perdeVida();
		irishDwarf.adicionarItem(new Item(3, "chapéus"));
		irishDwarf.adicionarItem(new Item(5, "poções"));
		irishDwarf.tentarSorte();
		assertTrue(6003 == irishDwarf.getInventario().getItens().get(0).getQtd());
		assertTrue(15005 == irishDwarf.getInventario().getItens().get(1).getQtd());
	}

	@Test
	public void dwarfsIguais() { // retorna true
		Dwarf dwarfUm = new IrishDwarf("gimli");
		Dwarf dwarfDois = new IrishDwarf("gimli");
		assertTrue(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void dwarfsDiferentes() { // returna false
		Dwarf dwarfUm = new IrishDwarf("gimli");
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void dwarfsXpDiferente() {// retorna false
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(1, 1, 2000);
		Dwarf dwarfUm = new IrishDwarf("gimli", dataTerceiraEra);
		for (int i = 0; i < 3; i++)
			dwarfUm.perdeVida();
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void dwarfsInventarioDiferente() {// retorna false
		Dwarf dwarfUm = new IrishDwarf("gimli");
		dwarfUm.adicionarItem(new Item(1, "adaga"));
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		dwarfDois.adicionarItem(new Item(2, "espada bastarda"));
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void primeiroDwarfNomeNulo() {// retorna false
		Dwarf dwarfUm = new IrishDwarf(null);
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void segundoDwarfNomeNulo() {// retorna false
		Dwarf dwarfUm = new IrishDwarf("gimli");
		Dwarf dwarfDois = new IrishDwarf(null);
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void ambsoDwarfsNomeNulo() {// retorna true
		Dwarf dwarfUm = new IrishDwarf(null);
		Dwarf dwarfDois = new IrishDwarf(null);
		assertTrue(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void dwarfsStatusDiferente() {// retorna false
		Dwarf dwarfUm = new IrishDwarf("gimli");
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		for (int i = 0; i < 12; i++)
			dwarfUm.perdeVida();
		assertFalse(dwarfUm.equals(dwarfDois));
	}

	@Test
	public void dwarfsVidaDiferente() {// retorna false
		Dwarf dwarfUm = new IrishDwarf("gimli");
		Dwarf dwarfDois = new IrishDwarf("gertrude");
		assertFalse(dwarfUm.equals(dwarfDois));
	}
}
