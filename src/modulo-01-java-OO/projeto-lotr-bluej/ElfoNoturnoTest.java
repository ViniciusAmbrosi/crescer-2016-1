import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{
    @After
    public void tearDown() {
        System.gc();
        System.runFinalization();
    }
    
    @Test
    public void atiraFlechaAnaoTesteRetorna3XpEPerde5Vida(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(3, elfo.getExperiencia());
        assertTrue(elfo.getVida() == 95);
    }
    
    @Test
    public void atiraFlechaAnaoTesteRetorna5987369392383789Vida(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i < 10; i++)
            elfo.atirarFlecha(dwarf);
        assertEquals(59.87369392383786, elfo.getVida(), 0.00000000000000);
    }
    
    @Test public void elfoNoturnoMorreSemVidaNegativa(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i <= 100; i++)
            elfo.atirarFlecha(dwarf);
        assertTrue(elfo.getStatus() == Status.MORTO);
        assertTrue(elfo.getVida() == 0);
    }
}


