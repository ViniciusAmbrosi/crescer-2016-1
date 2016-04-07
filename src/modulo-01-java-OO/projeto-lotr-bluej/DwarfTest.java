import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void testeConstrutorNome(){
        Dwarf dwarf = new Dwarf("nome");
        assertEquals("nome", dwarf.getNome());
    }
    
    @Test
    public void testeConstrutorVida(){
        Dwarf dwarf = new Dwarf("nome");
        assertEquals(110, dwarf.getVida());
    }
    
    @Test
    public void testeConstrutorStatus(){
        Dwarf dwarf = new Dwarf("nome");
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void anaoPerdeVidaMorre(){
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i < 12; i++)
            dwarf.perdeVida();
        assertEquals(Status.MORTO, dwarf.getStatus());
    }
    
    @Test
    public void testePerdeVida(){
        Dwarf dwarf = new Dwarf("nome");
        dwarf.perdeVida();
        assertEquals(100, dwarf.getVida());
    }
}
