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
}
