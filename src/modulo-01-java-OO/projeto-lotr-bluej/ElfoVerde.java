public class ElfoVerde extends Elfo{
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome,flechas);
    }
    
    public void atirarFlecha(Dwarf anao){
        this.experiencia += 2;
        this.flechas--;
        anao.perdeVida();
    }
    
    public void adicionarItem(Item item){
        if(item.getDescricao().equals("Espada de aço valiriano") || 
           item.getDescricao().equals("Arco e flecha de Vidro"))
           super.adicionarItem(item);
    }
}