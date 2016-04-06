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
    public void testePerdeVida(){
        Dwarf dwarf = new Dwarf("nome");
        dwarf.perdeVida();
        assertEquals(100, dwarf.getVida());
    }
}
