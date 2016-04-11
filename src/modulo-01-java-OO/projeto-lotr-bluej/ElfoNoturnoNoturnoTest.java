import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoNoturnoTest{
    @Test
    public void criaElfoNoturnoTesteNome(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        assertEquals("nome", elfo.getNome());
    }
    
    @Test
    public void criaElfoNoturnoTesteFlecha(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        assertEquals(42, elfo.getFlechas());
    }
    
    @Test
    public void criaElfoNoturnoTesteExp(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        assertEquals(0, elfo.getExperiencia());
    }

    @Test
    public void atiraFlechaAnaoTesteRetorna3Xp(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(3, elfo.getExperiencia());
    }
        
    @Test
    public void atiraFlechaAnaoTesteFlecha(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertEquals(41, elfo.getFlechas());
    }
       
    @Test
    public void atiraFlechaAnaoTesteVidaAnao(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        Dwarf dwarf = new Dwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertTrue(dwarf.getVida() == 100);
    }
    
    @Test
    public void elfoTesteToString(){
        ElfoNoturno elfo = new ElfoNoturno("nome");
        assertEquals("nome possui 42 flechas e 0 níveis de experiência", elfo.toString());
    }
    
    @Test
    public void elfoSegundoConstrutor(){
        ElfoNoturno elfo = new ElfoNoturno("nome", 45);
        assertEquals("nome", elfo.getNome());
        assertEquals(45, elfo.getFlechas());
        assertEquals(0, elfo.getExperiencia());
    }
    
    @Test
    public void retorna100VidaIrishDwarf(){
        ElfoNoturno elfo = new ElfoNoturno("legolas");
        Dwarf dwarf = new IrishDwarf("nome");
        elfo.atirarFlecha(dwarf);
        assertTrue(dwarf.getVida() == 100);
    }
}


