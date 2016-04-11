import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest{
    @Test
    public void criaElfoTesteNome(){
        Elfo elfo = new Elfo("nome");
        assertEquals("nome", elfo.getNome());
    }
    
    @Test
    public void criaElfoTesteFlecha(){
        Elfo elfo = new Elfo("nome");
        assertEquals(42, elfo.getFlechas());
    }
    
    @Test
    public void criaElfoTesteExp(){
        Elfo elfo = new Elfo("nome");
        assertEquals(0, elfo.getExperiencia());
    }

    @Test
    public void atiraFlechaAnaoTesteXp(){
        Elfo elfo = new Elfo("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(1, elfo.getExperiencia());
    }
        
    @Test
    public void atiraFlechaAnaoTesteFlecha(){
        Elfo elfo = new Elfo("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
    }
       
    @Test
    public void atiraFlechaAnaoTesteVidaAnao(){
        Elfo elfo = new Elfo("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertTrue(dwarf.getVida() == 100);
    }
    
    @Test
    public void elfoTesteToString(){
        Elfo elfo = new Elfo("nome");
        assertEquals("nome possui 42 flechas e 0 níveis de experiência", elfo.toString());
    }
    
    @Test
    public void elfoSegundoConstrutor(){
        Elfo elfo = new Elfo("nome", 45);
        assertEquals("nome", elfo.getNome());
        assertEquals(45, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void retorna100VidaIrishDwarf(){
        Elfo elfo = new Elfo("legolas");
        Dwarf dwarf = new IrishDwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertTrue(dwarf.getVida() == 100);
    }
}


