
public class ElfoNoturno extends Elfo {
	public ElfoNoturno(String nome) {
		super(nome);
	}

	public ElfoNoturno(String nome, int flechas) {
		super(nome, flechas);
	}

	public void atirarFlecha(Dwarf anao) {
		if (status == Status.MORTO)
			return;
		this.experiencia += 2;
		super.atirarFlecha(anao);
		this.perdeVida();
	}

	/**
	 * Perdendo 5% da vida atual, os elfos não morrem ao lançar flechas, pois
	 * nunca perderão 100% da vida.
	 */
	public double perdeVida() {
		double vidaAposAtirarFlecha = this.vida * 0.95;
		if (vidaAposAtirarFlecha < 1) {
			status = Status.MORTO;
			this.vida = 0;
		}
		if (vida > 0)
			vida = vidaAposAtirarFlecha;
		return vida;
	}
}