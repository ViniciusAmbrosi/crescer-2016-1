

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CestoDeLembasTest{
    @Test
    public void criarCestoCom2Lembas(){
        CestoDeLembas cdl = new CestoDeLembas(2);
        boolean esperado = false;
        boolean obtido = cdl.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoCom4Lembas(){
        CestoDeLembas cdl = new CestoDeLembas(4);
        boolean esperado = true;
        boolean obtido = cdl.podeDividirEmPares();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarCestoCom2MenosUmLembas(){
        CestoDeLembas cdl = new CestoDeLembas(-1);
        assertEquals(false, cdl.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoCom101Lembas(){
        CestoDeLembas cdl = new CestoDeLembas(101);
        assertEquals(false, cdl.podeDividirEmPares());
    }

}