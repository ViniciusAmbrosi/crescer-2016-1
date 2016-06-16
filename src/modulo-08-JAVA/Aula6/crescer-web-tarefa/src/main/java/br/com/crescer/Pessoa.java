package br.com.crescer;

/**
 * @author vinicius.ambrosi
 */
public class Pessoa{
    private String nome;
    private Integer idade;
    private Cidade cidade;

    public Pessoa() {
        this.cidade = new Cidade();
    }

    public String getNome() {
        return nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente " + nome + " " + 
               idade + " anos " + 
               "Residente em " + cidade.getNome() + " " + 
               cidade.getUF();
    }    
}


