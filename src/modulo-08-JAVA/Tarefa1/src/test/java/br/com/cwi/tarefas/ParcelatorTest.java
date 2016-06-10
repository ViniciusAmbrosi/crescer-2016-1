/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefas;

import static br.com.cwi.tarefas.Parcelator.obterParcelas;
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
public class ParcelatorTest {
    
    public ParcelatorTest() {
    }

    /*
    @Test
    public void obter10ParcelasDe110() {
        System.out.println("obterParcelas");
        double valor = 1000;
        double taxaJuros = 10;
        int qtdParcelas = 10;
        Date primeiroVencimento = null;
        try{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        primeiroVencimento = sdf.parse("08/12/2016");
        }catch(Exception e){}          
        String expResult = "08/12/2016 - R$ 110,00 \n"
                +          "08/01/2017 - R$ 110,00 \n"
                +          "08/02/2017 - R$ 110,00 \n"
                +          "08/03/2017 - R$ 110,00 \n"
                +          "08/04/2017 - R$ 110,00 \n"
                +          "08/05/2017 - R$ 110,00 \n"
                +          "08/06/2017 - R$ 110,00 \n"
                +          "08/07/2017 - R$ 110,00 \n"
                +          "08/08/2017 - R$ 110,00 \n"
                +          "08/09/2017 - R$ 110,00 \n";
                
        String result = Parcelator.obterParcelas(valor, taxaJuros, qtdParcelas, primeiroVencimento);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }
*/
}
