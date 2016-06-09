/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.tarefa3;

import java.io.IOException;

/**
 *
 * @author vinicius.ambrosi
 */
public class Run {
    
    public static void main(String[] args) {
        try{
            MeuSqlUtils.lerSql();
        }catch(IOException e){
            System.out.println("DEU JABU!");
        }
    }
}
