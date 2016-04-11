
public class Elfo extends Personagem{
    private int flechas = 42;
    private Inventario inventario = new Inventario();
    
    public Elfo(String nome){
        super(nome);
    }
    
    public Elfo(String nome, int flechas){
        super(nome);
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
    
    public int getFlechas(){return this.flechas;}    
}