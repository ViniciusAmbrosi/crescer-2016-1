/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa3;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.ambrosi
 */
public class Run {

    public static void main(String[] args) {

        //EX: 1
        /*try{
            MeuSqlUtils.lerSql();
            
            }catch(IOException e){
            System.out.println("DEU JABU!");
            }*/
        //EX: 2
        /*List<String> linhas = MeuSqlUtils.lerColunasELinhas("SELECT * FROM PESSOA");
            for(String linha : linhas)
            {
            System.out.println(linha);
            }*/
        //EX: 3
        /*
            try {
            MeuSqlUtils.importarCsv("Pessoas.csv", "Pessoa");
            } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        //EX:4
        
        try {
            MeuSqlUtils.exportarCsv("CSVMAROTO.csv", "Pessoa");
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
