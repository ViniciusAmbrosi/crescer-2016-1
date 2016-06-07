/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula1;

import java.util.Scanner;

/**
 *
 * @author vinicius.ambrosi
 */
public class Exercicio1 {
    public static void main(String[] args) {
        System.out.println("Digite um número: ");
        try (final Scanner scanner = new Scanner(System.in)) {
            int numeroRecebido = scanner.nextInt();
            String imparOuPar = numeroRecebido % 2 == 0 ? "Par" : "Impar";
            System.out.println("Número recebido é: " + imparOuPar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
