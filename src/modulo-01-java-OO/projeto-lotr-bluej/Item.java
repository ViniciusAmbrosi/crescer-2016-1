
public class Item{    
    private int qtd;
    private String descricao;
    
    public Item (int qtd, String descricao){
        this.qtd = qtd;
        this.descricao = descricao;
    }
    
    public int getQtd(){return this.qtd;}
    
    public String getDescricao(){return this.descricao;}
}
