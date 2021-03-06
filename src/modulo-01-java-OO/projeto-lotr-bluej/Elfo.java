
public class Elfo extends Personagem {
	private int flechas;
	private static int countElfo;

	public Elfo(String nome) {
		super(nome, 100.0);
		this.flechas = 42;
		countElfo++;
	}

	public Elfo(String nome, int flechas) {
		this(nome);
		this.flechas = flechas;
		countElfo++;
	}

	public void finalize() throws Throwable {
		if (countElfo >= 0) {
			Elfo.countElfo--;
			super.finalize();
		}
	}

	public void tentarSorte() {
		System.out.println("Elfo tentou a sorte!");
	}

	public String toString() {
		boolean flechaAbs = Math.abs(this.flechas) == 1;
		boolean experienciaAbs = Math.abs(this.experiencia) == 1;
		return String.format("%s possui %d %s e %d %s de experiência", this.nome, this.flechas,
				flechaAbs ? "flecha" : "flechas", this.experiencia, experienciaAbs ? "nível" : "níveis");
	}

	public void atirarFlecha(Dwarf anao) {
		this.experiencia++;
		this.flechas--;
		anao.perdeVida();
	}

	public boolean equals(Object obj) {
		Elfo elfo = (Elfo) obj;
		return super.equals(obj) && this.flechas == elfo.flechas ? this.countElfo == elfo.countElfo ? true : false
				: false;
	}

	public int getFlechas() {
		return this.flechas;
	}

	public static int getCountElfos() {
		return Elfo.countElfo;
	}
}