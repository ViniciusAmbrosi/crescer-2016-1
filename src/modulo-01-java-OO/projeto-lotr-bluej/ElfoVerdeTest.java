import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest{
    @After
    public void tearDown() {
        System.gc();
        System.runFinalization();
    }
    
    @Test
    public void adicionaEspadaDeAçoValiriano(){
        ElfoVerde elfo = new ElfoVerde("legolas");
        Item item = new Item(1, "Espada de aço valiriano");
        elfo.adicionarItem(item);
        assertTrue(elfo.getInventario().getItens().get(0).getDescricao().equals("Espada de aço valiriano"));
    }
    
    @Test
    public void ganha2XpAoAtirarFlecha(){
        ElfoVerde elfo = new ElfoVerde("legolas");
        Dwarf dwarf = new Dwarf("Gimli");
        elfo.atirarFlecha(dwarf);
        assertTrue(elfo.getExperiencia() == 2);
    }
    
    @Test
    public void retornaFalseTentativaAdicionarEspadaDeAçoValirian(){
        ElfoVerde elfo = new ElfoVerde("legolas");
        Item item = new Item(1, "Espada de aço valirian");
        elfo.adicionarItem(item);
        assertFalse(elfo.getInventario().getItens().contains(item));
    }
    
    @Test
    public void retornaFalseTentaAdicionarItemNull(){
        ElfoVerde elfo = new ElfoVerde("legolas");
        Item item = null;
        elfo.adicionarItem(item);
        assertFalse(elfo.getInventario().getItens().contains(item));
    }
}


