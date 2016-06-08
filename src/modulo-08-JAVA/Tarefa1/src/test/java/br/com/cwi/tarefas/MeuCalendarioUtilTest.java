/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefas;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dream
 */
public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of diaDeNascimento method, of class MeuCalendarioUtil.
     */
    @org.junit.Test
    public void retornaQuartaFeira() {
        System.out.println("diaDeNascimento");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("08/06/2016");
        }catch(Exception e){}  
        String expResult = "Quarta";
        String result = MeuCalendarioUtil.diaDeNascimento(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void passaDataNula() {
        System.out.println("diaDeNascimento");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = null;
        }catch(Exception e){}  
        String expResult = "";
        String result = MeuCalendarioUtil.diaDeNascimento(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of tempoDecorridoDesde method, of class MeuCalendarioUtil.
     */
    @org.junit.Test
    public void tempoDecorridoDesdeHoje() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("08/06/2016");
        }catch(Exception e){}  
        String expResult = "0 ano(s), 0 mes(es) e 0 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void tempoDecorridoDesdeOntem() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("07/06/2016");
        }catch(Exception e){}  
        String expResult = "0 ano(s), 0 mes(es) e 1 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void tempoDecorridoDesdeMesPassado() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("07/05/2016");
        }catch(Exception e){}  
        String expResult = "0 ano(s), 1 mes(es) e 1 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void tempoDecorridoDesdeAnoPassado() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("07/05/2015");
        }catch(Exception e){}  
        String expResult = "1 ano(s), 1 mes(es) e 1 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void tempoDecorridoComMesMaiorQueAtualAjustaAnoEMes() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("07/07/2015");
        }catch(Exception e){}  
        String expResult = "0 ano(s), 11 mes(es) e 1 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void tempoDecorridoComDiaMaiorQueAtualAjustaMesEDia() {
        System.out.println("tempoDecorridoDesde");
        Date data = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data = sdf.parse("10/07/2015");
        }catch(Exception e){}  
        String expResult = "0 ano(s), 10 mes(es) e 28 dia(s)";
        String result = MeuCalendarioUtil.tempoDecorridoDesde(data);
        assertEquals(expResult, result);
    }
}
