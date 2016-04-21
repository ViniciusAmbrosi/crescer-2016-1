
public class Dwarf extends Personagem {
	private DataTerceiraEra dataNasc = new DataTerceiraEra(1, 1, 1);

	public Dwarf(String nome) {
		super(nome, 110.0);
	}

	public Dwarf(String nome, DataTerceiraEra dte) {
		super(nome, 110.0);
		dataNasc = dte;
	}

	public void perdeVida() {
		if (status == Status.MORTO)
			return;
		double numeroSorte = getNumeroSorte();
		if (numeroSorte < 0) {
			experiencia += 2;
			return;
		} else if (numeroSorte <= 100)
			return;
		else {
			double vidaAposFlechada = vida - 10;
			if (vidaAposFlechada == 0)
				status = Status.MORTO;
			if (vida > 0)
				vida -= 10;
		}
	}

	public double getNumeroSorte() {
		double numeroSorte = 101;
		boolean ehBissexto = dataNasc.ehBissexto();
		boolean vidaEntreOitentaENoventa = this.vida >= 80 && this.vida <= 90;
		boolean nomeEhSeixasOuMeireles = this.nome != null
				&& (this.nome.equals("Seixas") || this.nome.equals("Meireles"));
		return ehBissexto ? vidaEntreOitentaENoventa ? -33 * 101 : numeroSorte
				: nomeEhSeixasOuMeireles ? (33 * 101) % 100 : numeroSorte;
	}

	public void tentarSorte() {
		double sorte = getNumeroSorte();
		if (sorte == -3333)
			inventario.adiciona1000UnidadesPorItem();
	}

	public static Dwarf descobrirMenosVida(Dwarf dwarfUm, Dwarf dwarfDois) {
		return dwarfUm.vida < dwarfDois.vida ? dwarfUm : dwarfDois;
	}

	public boolean equals(Object obj) {
		Dwarf dwarf = (Dwarf) obj;
		return super.equals(obj) && this.dataNasc.equals(dwarf.dataNasc);
	}

	public DataTerceiraEra getDataNasc() {
		return this.dataNasc;
	}
}
