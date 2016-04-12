public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf anao){
        if(status == Status.MORTO)
            return;
        super.atirarFlecha(anao, 3);
        this.perdeVida();
    }
    
    /**Perdendo 5% da vida atual, os elfos não morrem ao lançar flechas, pois nunca perderão 100% da vida.*/
    private void perdeVida(){
        double vidaAposAtirarFlecha = vida - 5;//vida menos 5% vida maxima
        if(vidaAposAtirarFlecha == 0){
            status = status.MORTO;
        }
        if(vida > 0)
            vida = vidaAposAtirarFlecha;
    }
    /**Perdendo 5% da vida total, os elfos podem morrer ao lançar flechas.*/
}