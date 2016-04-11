public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    /**Nao, elfos nao podem morrer atirando flechas. Pq sempre perdera 5% da vida atual,
    logo, nunca morrendo*/
    public void atirarFlecha(Dwarf anao){
        this.experiencia += 3;
        this.flechas--;
        anao.perdeVida();
        this.vida = this.vida * 0.05;
    }
}