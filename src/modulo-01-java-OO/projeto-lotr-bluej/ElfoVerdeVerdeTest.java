import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeVerdeTest{
    @Test
    public void criaElfoVerdeTesteNome(){
        ElfoVerde elfo = new ElfoVerde("nome");
        assertEquals("nome", elfo.getNome());
    }
    
    @Test
    public void criaElfoVerdeTesteFlecha(){
        ElfoVerde elfo = new ElfoVerde("nome");
        assertEquals(42, elfo.getFlechas());
    }
    
    @Test
    public void criaElfoVerdeTesteExp(){
        ElfoVerde elfo = new ElfoVerde("nome");
        assertEquals(0, elfo.getExperiencia());
    }

    @Test
    public void atiraFlechaAnaoTesteXp(){
        ElfoVerde elfo = new ElfoVerde("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(2, elfo.getExperiencia());
    }
        
    @Test
    public void atiraFlechaAnaoTesteFlecha(){
        ElfoVerde elfo = new ElfoVerde("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
    }
       
    @Test
    public void atiraFlechaAnaoTesteVidaAnao(){
        ElfoVerde elfo = new ElfoVerde("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(100, dwarf.getVida());
    }
    
    @Test
    public void elfoTesteToString(){
        ElfoVerde elfo = new ElfoVerde("nome");
        assertEquals("nome possui 42 flechas e 0 níveis de experiência", elfo.toString());
    }
    
    @Test
    public void elfoSegundoConstrutor(){
        ElfoVerde elfo = new ElfoVerde("nome", 45);
        assertEquals("nome", elfo.getNome());
        assertEquals(45, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void retorna100VidaIrishDwarf(){
        ElfoVerde elfo = new ElfoVerde("legolas");
        Dwarf dwarf = new IrishDwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertTrue(dwarf.getVida() == 100);
    }
}


