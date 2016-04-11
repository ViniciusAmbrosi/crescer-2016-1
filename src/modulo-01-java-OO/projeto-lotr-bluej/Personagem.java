
public class Personagem{
    protected String nome;
    protected int experiencia = 0;
    protected Inventario inventario = new Inventario();
    
    public Personagem(String nome){
        this.nome = nome;
    }
    
    public void adicionarItem(Item item){
       this.inventario.addItem(item);
    }
   
    public void perderItem(Item item){
       this.inventario.removerItem(item);
    }
    
    public Inventario getInventario(){return this.inventario;}
    
    public String getNome(){return this.nome;}
    
    public int getExperiencia(){return this.experiencia;} 
}
