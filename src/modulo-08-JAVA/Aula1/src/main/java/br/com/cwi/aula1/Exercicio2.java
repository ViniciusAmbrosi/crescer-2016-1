/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula1;

/**
 *
 * @author vinicius.ambrosi
 */
public class Exercicio2 {
    public static void main(String[] args) {
        String estados = "";
        for(Estados estado : Estados.values())
        {
            StringBuffer stringBuffer = new StringBuffer(estados);
            if(estados != "") stringBuffer.append(", ");
            stringBuffer.append(estado.getNome());
            estados = stringBuffer.toString();
        }
        System.out.println(estados);
    }
}
