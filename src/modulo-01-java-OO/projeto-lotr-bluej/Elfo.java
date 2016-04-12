
public class Elfo extends Personagem{
    protected int flechas;
    
    public Elfo(String nome){
        super(nome, 100.0);
        this.flechas = 42;
    }
    
    public Elfo(String nome, int flechas){
        super(nome, 100.0);
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
        this.experiencia++;
        this.flechas--;
        anao.perdeVida();
    }
    
    public int getFlechas(){return this.flechas;}    
}