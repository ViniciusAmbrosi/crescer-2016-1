import java.util.*;

public interface Estrategia {
	public void atacar(HashMap<Status, ArrayList<Elfo>> elfos, ArrayList<Dwarf> dwarfs);

	public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}
