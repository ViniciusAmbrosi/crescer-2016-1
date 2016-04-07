import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void criaAnaoPrimeiroConstrutor(){
        Dwarf dwarf = new Dwarf("nome");
        assertEquals("nome", dwarf.getName());
        assertEquals(110, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertTrue(dwarf.getInventario() != null);
        assertEquals(1, dwarf.getDataNasc().getDia());
        assertEquals(1, dwarf.getDataNasc().getMes());
        assertEquals(1, dwarf.getDataNasc().getAno());
    }
    
    @Test
    public void anaoPerdeVidaMorre(){
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i < 12; i++)
            dwarf.perdeVida();
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void anaoNaoTemVidaNegativa(){
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i < 13; i++)
            dwarf.perdeVida();
        assertEquals(0, dwarf.getVida());
    }
    
    @Test
    public void testePerdeVida(){
        Dwarf dwarf = new Dwarf("nome");
        dwarf.perdeVida();
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void anaoTemInventarioDataNascDefault(){
        Dwarf dwarf = new Dwarf("nome");
        assertTrue(dwarf.getInventario() != null);
        assertEquals(1, dwarf.getDataNasc().getDia());
        assertEquals(1, dwarf.getDataNasc().getMes());
        assertEquals(1, dwarf.getDataNasc().getAno());
    }
    
    @Test
    public void anaoNovoConstrutorDataNasc222(){
        DataTerceiraEra dte = new DataTerceiraEra(2,2,2);
        Dwarf dwarf = new Dwarf("nome",dte);
        assertEquals("nome", dwarf.getName());
        assertEquals(110, dwarf.getVida());
        assertEquals(Status.VIVO, dwarf.getStatus());
        assertTrue(dwarf.getInventario() != null);
        assertEquals(2, dwarf.getDataNasc().getDia());
        assertEquals(2, dwarf.getDataNasc().getMes());
        assertEquals(2, dwarf.getDataNasc().getAno());
    }
    
    @Test
    public void anaoAdicionaItemInventario(){
        Dwarf dwarf = new Dwarf("nome");
        Item item = new Item(1,"espada");
        dwarf.adicionarItem(item);
        assertTrue(dwarf.getInventario().getItens().get(0) != null);
    }
    
    @Test
    public void anaoRemoveItemEspada(){
        Dwarf dwarf = new Dwarf("nome");
        Item espada = new Item(1,"espada");
        Item arco = new Item(1,"arco");
        dwarf.adicionarItem(espada);
        dwarf.adicionarItem(arco); 
        dwarf.perderItem(espada);
        assertTrue(dwarf.getInventario().getItens().get(0) == arco);
    }
    
}
