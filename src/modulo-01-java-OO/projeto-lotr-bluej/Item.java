
public class Item{    
    private int qtd;
    private String descricao;
    
    public Item (int qtd, String descricao){
        this.qtd = qtd;
        this.descricao = descricao;
    }
    
    public void adiciona1000Unidades(){
        this.qtd += 1000;
    }
    
    public void adicionaItemProporcionalQuantidade(){
        this.qtd += (this.qtd * (this.qtd + 1) /2) * 1000;
    }
    
    public int getQtd(){return this.qtd;}
    
    public String getDescricao(){return this.descricao;}
}
