import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest {
	@Test
	public void criaInventarioEAddItem() {
		Inventario inventario = new Inventario();
		Item item = new Item(1, "espada");
		inventario.addItem(item);
		assertEquals(item, inventario.getItens().get(0));
	}

	@Test
	public void itemEspadaFoiRemovido() {
		Inventario inventario = new Inventario();
		Item espada = new Item(1, "espada");
		Item arco = new Item(1, "arco");
		Item escudo = new Item(1, "escudo");
		inventario.addItem(espada);
		inventario.addItem(arco);
		inventario.addItem(escudo);
		inventario.removerItem(espada);
		assertEquals(arco, inventario.getItens().get(0));
	}

	@Test
	public void descreveEspadaAdagaArco() {
		Inventario inventario = new Inventario();
		inventario.addItem(new Item(1, "Espada"));
		inventario.addItem(new Item(1, "Adaga"));
		inventario.addItem(new Item(1, "Arco"));
		boolean descreveEspadaAdagaArco = "Espada,Adaga,Arco".equals(inventario.getDescricaoItens());
		assertTrue(descreveEspadaAdagaArco);
	}

	@Test
	public void espadaItemMaisComum() {
		Inventario inventario = new Inventario();
		Item espada = new Item(5, "Espada");
		inventario.addItem(espada);
		inventario.addItem(new Item(1, "Adaga"));
		inventario.addItem(new Item(1, "Arco"));
		assertTrue(inventario.getItemMaisComum() == espada);
	}

	@Test
	public void ordenaItensArcoAdagaEspada() {
		Inventario inventario = new Inventario();
		Item espada = new Item(3, "Espada");
		Item adaga = new Item(2, "Adaga");
		Item arco = new Item(1, "Arco");
		inventario.addItem(espada);
		inventario.addItem(adaga);
		inventario.addItem(arco);
		inventario.ordenarItens();
		assertTrue(inventario.getItens().get(0) == arco);
		assertTrue(inventario.getItens().get(1) == adaga);
		assertTrue(inventario.getItens().get(2) == espada);
	}

	@Test
	public void ordenaItensArcoEspadaAdaga() {
		Inventario inventario = new Inventario();
		Item espada = new Item(2, "Espada");
		Item adaga = new Item(3, "Adaga");
		Item arco = new Item(1, "Arco");
		inventario.addItem(espada);
		inventario.addItem(adaga);
		inventario.addItem(arco);
		inventario.ordenarItens();
		assertTrue(inventario.getItens().get(0) == arco);
		assertTrue(inventario.getItens().get(2) == adaga);
		assertTrue(inventario.getItens().get(1) == espada);
	}

	@Test
	public void ordenaItensAdagaEspadaArco() {
		Inventario inventario = new Inventario();
		Item espada = new Item(2, "Espada");
		Item adaga = new Item(1, "Adaga");
		Item arco = new Item(3, "Arco");
		inventario.addItem(espada);
		inventario.addItem(adaga);
		inventario.addItem(arco);
		inventario.ordenarItens();
		assertTrue(inventario.getItens().get(2) == arco);
		assertTrue(inventario.getItens().get(0) == adaga);
		assertTrue(inventario.getItens().get(1) == espada);
	}

	public void primeiroInventarioNulo() {
		Inventario inventarioUm = null;
		Inventario inventarioDois = new Inventario();
		Item itemUm = new Item(2, "Pocao");
		inventarioDois.addItem(itemUm);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	public void segundoInventarioNulo() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = null;
		Item itemUm = new Item(1, "Espada");
		inventarioUm.addItem(itemUm);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	public void ambosInventariosNulos() {
		Inventario inventarioUm = null;
		Inventario inventarioDois = null;
		assertTrue(inventarioUm.equals(inventarioDois));

	}

	public void primeiroInventarioItemNulo() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = null;
		Item itemDois = new Item(2, "Pocao");
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemDois);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	public void segundoInventarioItemNulo() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = new Item(1, "Pocao");
		Item itemDois = null;
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemDois);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	public void ambosInventariosItensNulos() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = null;
		Item itemDois = null;
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemDois);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	public void inventariosDiferentes() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = new Item(3, "Pocao");
		Item itemDois = new Item(2, "Pocao");
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemDois);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	@Test
	public void inventariosIguais() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = new Item(1, "Espada");
		Item itemDois = new Item(2, "Pocao");
		Item itemTres = new Item(1, "Espada");
		Item itemQuatro = new Item(2, "Pocao");
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemTres);
		inventarioUm.addItem(itemDois);
		inventarioDois.addItem(itemQuatro);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

	@Test
	public void inventarioComObjetoDuplicado() {
		Inventario inventarioUm = new Inventario();
		Inventario inventarioDois = new Inventario();
		Item itemUm = new Item(1, "Espada");
		Item itemDois = new Item(2, "Pocao");
		inventarioUm.addItem(itemUm);
		inventarioUm.addItem(itemUm);
		inventarioDois.addItem(itemUm);
		inventarioDois.addItem(itemDois);
		assertTrue(inventarioUm.equals(inventarioDois));
	}

}
