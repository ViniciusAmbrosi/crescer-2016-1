package br.com.crescer.controller;

import java.util.Date;

/**
 * @author vinicius.ambrosi
 */
public class Pessoa {

    private Date data;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
