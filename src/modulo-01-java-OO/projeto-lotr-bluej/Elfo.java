public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return  nome + " possui " + this.flechas
                + " flechas e " + this.experiencia
                + " niveis de experiência";
    }
    
    public void atirarFlecha() {
        experiencia++;
        flechas--;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getFlechas(){
        return flechas;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void atirarFlecha(Dwarf anao){
        this.atirarFlecha();
        anao.perdeVida();
    }
    
}