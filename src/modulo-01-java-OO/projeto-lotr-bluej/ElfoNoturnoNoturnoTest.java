import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoNoturnoTest{
    @Test
    public void atiraFlechaAnaoTesteRetorna3XpEPerde5Vida(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(3, elfo.getExperiencia());
        assertTrue(elfo.getVida() == 95);
    }
    
    @Test public void elfoNoturnoMorreSemVidaNegativa(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        for(int i = 0; i <= 22; i++)
            elfo.atirarFlecha(dwarf);
        assertTrue(elfo.getStatus() == Status.MORTO);
        assertTrue(elfo.getVida() == 0);
    }
}


