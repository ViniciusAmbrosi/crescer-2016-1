public class ElfoVerde extends Elfo{
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome,flechas);
    }
    
    public void atirarFlecha(Dwarf anao){
        super.atirarFlecha(anao, 2);
    }
    
    public void adicionarItem(Item item){
        if(item == null)
            return;
        if(item.getDescricao().equals("Espada de aço valiriano") || 
           item.getDescricao().equals("Arco e flecha de Vidro"))
           super.adicionarItem(item);
    }
}