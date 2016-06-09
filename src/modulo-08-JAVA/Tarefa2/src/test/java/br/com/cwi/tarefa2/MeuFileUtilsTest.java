/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa2;

import java.io.File;
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
public class MeuFileUtilsTest {

    /**
     * Test of ehDiretorio method, of class MeuFileUtils.
     */
    /**
     * Test of main method, of class MeuFileUtils.
     */
    @Test
    public void testaCriarArquivo() {
        System.out.println("main");
        String[] args = new String[]{"mk", "${criar}"};
        MeuFileUtils.main(args);
    }
    
    @Test
    public void testaObterCaminho() {
        System.out.println("main");
        String[] args = new String[]{"ls", "${criar}"};
        MeuFileUtils.main(args);
    }
    
    @Test
    public void testaMoverAqruivo() {
        System.out.println("main");
        String[] args = new String[]{"mv", "${criar C:\\Trabalho\\criar}"};
        MeuFileUtils.main(args);
    }

    @Test
    public void testaDeletarAqruivo() {
        System.out.println("main");
        String[] args = new String[]{"rm", "${criar}"};
        MeuFileUtils.main(args);
    }

}
