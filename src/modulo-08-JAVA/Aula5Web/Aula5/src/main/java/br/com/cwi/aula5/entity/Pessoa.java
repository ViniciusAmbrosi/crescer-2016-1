package br.com.cwi.aula5.entity;
/**
 * @author vinicius.ambrosi
 */
public class Pessoa {

    public Pessoa(String nome, int idade, String sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    private String nome;
    private int idade;
    private String sexo;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }
}
