
public class Personagem{
    protected String nome;
    protected int experiencia;
    protected Inventario inventario = new Inventario();
    protected double vida;
    protected Status status;
    
    public Personagem(String nome, double vida){
        this.nome = nome;
        this.vida = vida;
        this.status = status.VIVO;
        this.experiencia = 0;
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
    
    public Status getStatus(){return this.status;}
   
    public double getVida(){return this.vida;}
}
