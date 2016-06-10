/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula3;

import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius.ambrosi
 */
public class RepositorioPessoaDAOTest {
    /**
     * Test of insert method, of class RepositorioPessoaDAO.
     */
    RepositorioPessoaDAO instance = new RepositorioPessoaDAO();

    /*@org.junit.Test
    public void testInsert() {
        System.out.println("insert");
        Pessoa pessoa = new Pessoa("Jaburela");
        List<Pessoa> pessoasAntes = instance.findNome("Jaburela");
        instance.insert(pessoa);
        List<Pessoa> pessoasDepois = instance.findNome("Jaburela");
        assertNotEquals(pessoasAntes, pessoasDepois);
    }*/

    /**
     * Test of update method, of class RepositorioPessoaDAO.
     */
    /*@org.junit.Test
    public void testUpdate() {
        System.out.println("testUpdate");
        Pessoa pessoa = new Pessoa("Shazam", 5);
        List<Pessoa> pessoasAntes = instance.findNome("Shazam");
        instance.update(pessoa);
        List<Pessoa> pessoasDepois = instance.findNome("Shazam");
        assertNotEquals(pessoasAntes, pessoasDepois);
    }*/

    /**
     * Test of delete method, of class RepositorioPessoaDAO.
     */
    /*@org.junit.Test
    public void testDelete() {
        System.out.println("testDelete");
        Pessoa pessoa = new Pessoa("Shazam", 1);
        List<Pessoa> pessoasAntes = instance.findNome("Shazam");
        instance.delete(pessoa);
        List<Pessoa> pessoasDepois = instance.findNome("Shazam");
        if(pessoasAntes.isEmpty())
            assertEquals(pessoasAntes, pessoasDepois);
        else
            assertNotEquals(pessoasAntes, pessoasDepois);
    }*/

    /**
     * Test of listAll method, of class RepositorioPessoaDAO.
     */
    /*@org.junit.Test
    public void testListAll() {
        System.out.println("testListAll");
        List<Pessoa> pessoas = instance.listAll();
        assertTrue(pessoas.size() > 0);
    }*/

    /**
     * Test of findNome method, of class RepositorioPessoaDAO.
     */
    /*@org.junit.Test
    public void testFindNome() {
        System.out.println("testFindNome");
        List<Pessoa> pessoas = instance.findNome("NomeNaoExistente");
        assertTrue(pessoas.isEmpty());
    }*/
}
