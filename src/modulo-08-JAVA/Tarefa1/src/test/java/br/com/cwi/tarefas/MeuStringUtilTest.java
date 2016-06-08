/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefas;

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
public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
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
     * Test of isEmpty method, of class MeuStringUtil.
     */
    @Test
    public void testaIsEmptyComStringVazia() {
        System.out.println("isEmpty");
        String palavra = "   ";
        boolean expResult = true;
        boolean result = MeuStringUtil.isEmpty(palavra);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testaIsEmptyComStringNaoVazia() {
        System.out.println("isEmpty");
        String palavra = "Hi";
        boolean expResult = false;
        boolean result = MeuStringUtil.isEmpty(palavra);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testaIsEmptyComStringNula() {
        System.out.println("isEmpty");
        String palavra = null;
        boolean expResult = true;
        boolean result = MeuStringUtil.isEmpty(palavra);
        assertEquals(expResult, result);
    }

    /**
     * Test of contarVogais method, of class MeuStringUtil.
     */
    @Test
    public void testaContarVogaisComTresA() {
        System.out.println("contarVogais");
        String palavra = "aaabbb";
        int expResult = 3;
        int result = MeuStringUtil.contarVogais(palavra);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testaContarVogaisSemVogais() {
        System.out.println("contarVogais");
        String palavra = "cccbbb";
        int expResult = 0;
        int result = MeuStringUtil.contarVogais(palavra);
        assertEquals(expResult, result);
    }

    /**
     * Test of inverterString method, of class MeuStringUtil.
     */
    @Test
    public void testaInverterStringComABC() {
        System.out.println("inverterString");
        String palavra = "ABC";
        String expResult = "CBA";
        String result = MeuStringUtil.inverterString(palavra);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPalindromo method, of class MeuStringUtil.
     */
    @Test
    public void testaPalindromoComPalavraNaoPalindromo() {
        System.out.println("isPalindromo");
        String palavra = "Computador";
        boolean expResult = false;
        boolean result = MeuStringUtil.isPalindromo(palavra);
        assertEquals(expResult, result);
    }  
    
    @Test
    public void testaPalindromoComPalindromo() {
        System.out.println("isPalindromo");
        String palavra = "ovo";
        boolean expResult = true;
        boolean result = MeuStringUtil.isPalindromo(palavra);
        assertEquals(expResult, result);
    }    
}
