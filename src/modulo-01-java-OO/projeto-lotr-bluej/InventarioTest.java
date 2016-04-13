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
    
    @Test
    public void ordenaItensArcoAdagaEspada(){
        Inventario inv = new Inventario();
        Item espada = new Item(3, "Espada");
        Item adaga = new Item(2, "Adaga");
        Item arco = new Item(1, "Arco");
        inv.addItem(espada);
        inv.addItem(adaga);
        inv.addItem(arco);
        inv.ordenarItens();
        assertTrue(inv.getItens().get(0) == arco);
        assertTrue(inv.getItens().get(1) == adaga);
        assertTrue(inv.getItens().get(2) == espada);
    }
    
    @Test
    public void ordenaItensArcoEspadaAdaga(){
        Inventario inv = new Inventario();
        Item espada = new Item(2, "Espada");
        Item adaga = new Item(3, "Adaga");
        Item arco = new Item(1, "Arco");
        inv.addItem(espada);
        inv.addItem(adaga);
        inv.addItem(arco);
        inv.ordenarItens();
        assertTrue(inv.getItens().get(0) == arco);
        assertTrue(inv.getItens().get(2) == adaga);
        assertTrue(inv.getItens().get(1) == espada);
    }
    
    @Test
    public void ordenaItensAdagaEspadaArco(){
        Inventario inv = new Inventario();
        Item espada = new Item(2, "Espada");
        Item adaga = new Item(1, "Adaga");
        Item arco = new Item(3, "Arco");
        inv.addItem(espada);
        inv.addItem(adaga);
        inv.addItem(arco);
        inv.ordenarItens();
        assertTrue(inv.getItens().get(2) == arco);
        assertTrue(inv.getItens().get(0) == adaga);
        assertTrue(inv.getItens().get(1) == espada);
    }
    
    public void primeiroInventarioNulo(){
        Inventario inv1 = null;
        Inventario inv2 = new Inventario();
        Item item1 = new Item(2, "Poção");
        inv2.addItem(item1);
        assertTrue(inv1.equals(inv2));
    }
    
    public void segundoInventarioNulo(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = null;
        Item item1 = new Item(1, "Espada");
        inv1.addItem(item1);
        assertTrue(inv1.equals(inv2));
    }
    
    public void ambosInventariosNulos(){
        Inventario inv1 = null;
        Inventario inv2 = null;
        assertTrue(inv1.equals(inv2));
    
    }
    
    public void primeiroInventarioItemNulo(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = null;
        Item item2 = new Item(2, "Poção");
        inv1.addItem(item1);
        inv2.addItem(item2);
        assertTrue(inv1.equals(inv2));
    }
    
    public void segundoInventarioItemNulo(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = new Item(1, "Poção");
        Item item2 = null;
        inv1.addItem(item1);
        inv2.addItem(item2);
        assertTrue(inv1.equals(inv2));
    }
    
    public void ambosInventariosItensNulos(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = null;
        Item item2 = null;
        inv1.addItem(item1);
        inv2.addItem(item2);
        assertTrue(inv1.equals(inv2));
    }
    
    public void inventariosDiferentes(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = new Item(3, "Poção");
        Item item2 = new Item(2, "Poção");
        inv1.addItem(item1);
        inv2.addItem(item2);
        assertTrue(inv1.equals(inv2));
    }
    
    @Test
    public void inventariosIguais(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = new Item(1, "Espada");
        Item item2 = new Item(2, "Poção");
        Item item3 = new Item(1, "Espada");
        Item item4 = new Item(2, "Poção");
        inv1.addItem(item1);
        inv2.addItem(item3);
        inv1.addItem(item2);
        inv2.addItem(item4);
        assertTrue(inv1.equals(inv2));
    }
    
    @Test
    public void inventarioComObjetoDuplicado(){
        Inventario inv1 = new Inventario();
        Inventario inv2 = new Inventario();
        Item item1 = new Item(1, "Espada");
        Item item2 = new Item(2, "Poção");
        inv1.addItem(item1);
        inv1.addItem(item1);
        inv2.addItem(item1);
        inv2.addItem(item2);
        assertTrue(inv1.equals(inv2));
    }
    
}
