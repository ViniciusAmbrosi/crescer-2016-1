/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.aula3;

/**
 *
 * @author vinicius.ambrosi
 */
public class Pessoa{

    private String nome;
    private int id;
    
    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
 
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

