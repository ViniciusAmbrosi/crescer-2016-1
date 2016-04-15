import java.util.*;

public class ArteDaGuerra implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

	public ArrayList<Elfo> atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null || dwarfs.isEmpty())
			return ordemAtaque;
		int qtdNoturnos = quantosElfosNoturnosAtacam(exercitoElfos.get(Status.VIVO).size(), dwarfs.size());
		for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
			if (elfo instanceof ElfoNoturno && qtdNoturnos-- <= 0)
				continue;
			for (Dwarf dwarf : dwarfs)
				elfo.atirarFlecha(dwarf);
			ordemAtaque.add(elfo);
		}
		return ordemAtaque;
	}

	private int quantosElfosNoturnosAtacam(int elfoSize, int dwarfSize) {
		return (int) Math.floor((elfoSize * dwarfSize) * 0.3);
	}
}