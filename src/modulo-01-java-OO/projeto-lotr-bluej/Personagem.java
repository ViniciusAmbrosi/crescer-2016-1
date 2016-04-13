
public abstract class Personagem{
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
    
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null) //this nunca vai ser nulo, já que equals nao permite
            return false;
        Personagem personagem = (Personagem) obj;
        if(this.getClass() != personagem.getClass())
            return false;
        if(this.experiencia != personagem.experiencia)
            return false;
        if(!this.inventario.equals(personagem.inventario))
            return false;
        if(this.nome == null){
             if(personagem.nome != null)
                return false;
        }else if(!this.nome.equals(personagem.nome))
            return false;
        if(this.status != personagem.status)
            return false;
        if(this.vida != personagem.vida)
            return false;
        return true;
    }
    
    public Inventario getInventario(){return this.inventario;}
    
    public String getNome(){return this.nome;}
    
    public int getExperiencia(){return this.experiencia;} 
    
    public Status getStatus(){return this.status;}
   
    public double getVida(){return this.vida;}
}
