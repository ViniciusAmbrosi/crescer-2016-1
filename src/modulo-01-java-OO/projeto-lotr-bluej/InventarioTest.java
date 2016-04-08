import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest{
    @Test
    public void criaInventarioEAddItem(){
        Inventario inv = new Inventario();
        Item item = new Item(1,"espada");
        inv.addItem(item);
        assertEquals(item, inv.getItens().get(0));
    }

    @Test
    public void itemEspadaFoiRemovido(){
        Inventario inv = new Inventario();
        Item espada = new Item(1,"espada");
        Item arco = new Item(1,"arco");
        Item escudo = new Item(1,"escudo");
        inv.addItem(espada);
        inv.addItem(arco);
        inv.addItem(escudo);
        inv.removerItem(espada);
        assertEquals(arco, inv.getItens().get(0));
    }
    
    @Test
    public void descreveEspadaAdagaArco(){
        Inventario inv = new Inventario();
        inv.addItem(new Item(1, "Espada"));
        inv.addItem(new Item(1, "Adaga"));
        inv.addItem(new Item(1, "Arco"));
        boolean descreveEspadaAdagaArco = "Espada,Adaga,Arco".equals(inv.getDescricaoItens());
        assertTrue(descreveEspadaAdagaArco);
    }
    
    @Test
    public void espadaItemMaisComum(){
        Inventario inv = new Inventario();
        Item espada = new Item(5,"Espada");
        inv.addItem(espada);
        inv.addItem(new Item(1, "Adaga"));
        inv.addItem(new Item(1, "Arco"));
        assertTrue(inv.getItemMaisComum() == espada);
    }
}
