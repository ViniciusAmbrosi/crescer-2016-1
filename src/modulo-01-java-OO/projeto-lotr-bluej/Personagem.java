
public abstract class Personagem {
	protected String nome;
	protected int experiencia;
	protected Inventario inventario = new Inventario();
	protected double vida;
	protected Status status;

	public Personagem(String nome, double vida) {
		this.nome = nome;
		this.vida = vida;
		this.status = Status.VIVO;
	}

	public void adicionarItem(Item item) {
		this.inventario.addItem(item);
	}

	public void perderItem(Item item) {
		this.inventario.removerItem(item);
	}

	public abstract void tentarSorte();

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) // this nunca vai ser nulo, já que equals nao permite
			return false;
		Personagem personagem = (Personagem) obj;
		if (this.nome == null) {
			if (personagem.nome != null)
				return false;
		} else if (!this.nome.equals(personagem.nome))
			return false;
		return this.getClass() == personagem.getClass() && this.experiencia == personagem.experiencia
				&& this.inventario.equals(personagem.inventario) && this.status == personagem.status
				&& this.vida == personagem.vida;
	}

	public Inventario getInventario() {
		return this.inventario;
	}

	public String getNome() {
		return this.nome;
	}

	public int getExperiencia() {
		return this.experiencia;
	}

	public Status getStatus() {
		return this.status;
	}

	public double getVida() {
		return this.vida;
	}
}
