public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        this.flechas = flechas;
    } 
    
    public String toString(){
        boolean flechaAbs = Math.abs(this.flechas) == 1;
        boolean experienciaAbs = Math.abs(this.experiencia) == 1;
        return  String.format("%s possui %d %s e %d %s de experiência",
                              this.nome,
                              this.flechas,
                              flechaAbs ? "flecha" : "flechas",
                              this.experiencia,
                              experienciaAbs ? "nível" : "níveis");
                              
    }
    
    public void atirarFlecha(Dwarf anao){
        experiencia++;
        flechas--;
        anao.perdeVida();
    }
    
    public String getNome(){return nome;}
    
    public int getFlechas(){return flechas;}
    
    public int getExperiencia(){return experiencia;}     
}