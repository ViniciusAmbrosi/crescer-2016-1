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
        if(status == Status.MORTO)
            return;
        this.experiencia += 3;
        this.flechas--;
        anao.perdeVida();
        double vidaAposFlechada = vida - 5;//vida menos 5% vida maxima
        if(vidaAposFlechada == 0){
            status = status.MORTO;
            vida = 0;
        }
        if(vida > 0)
            vida = vidaAposFlechada;
    }
    /**Agora elfos morre, pois perdem 5% da vida total*/
}