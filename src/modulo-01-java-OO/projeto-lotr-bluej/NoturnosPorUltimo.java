import java.util.*;

public class NoturnosPorUltimo implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

	public ArrayList<Elfo> atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null  || dwarfs.isEmpty())
			return ordemAtaque;
		ordemAtaqueElfos(new ElfoVerde("Verde"), exercitoElfos, dwarfs);
		ordemAtaqueElfos(new ElfoNoturno("Noturno"), exercitoElfos, dwarfs);
		return ordemAtaque;
	}

	private void ordemAtaqueElfos(Elfo tipo, HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
			if (elfo.getClass().equals(tipo.getClass())) {
				ordemAtaque.add(elfo);
				for (Dwarf dwarf : dwarfs)
					elfo.atirarFlecha(dwarf);
			}
		}
	}
}
