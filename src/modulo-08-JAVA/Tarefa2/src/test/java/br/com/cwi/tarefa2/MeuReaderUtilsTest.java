/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa2;

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
public class MeuReaderUtilsTest {
    
    /**
     * Test of lerArquivo method, of class MeuReaderUtils.
     */
    @Test
    public void testLerArquivo() throws Exception {
        System.out.println("lerArquivo");
        String nome = "criar.txt";
        String expResult = "Ta funcionando?/n";
        String result = MeuReaderUtils.lerArquivo(nome);
        assertEquals(expResult, result);
    }
    
}
