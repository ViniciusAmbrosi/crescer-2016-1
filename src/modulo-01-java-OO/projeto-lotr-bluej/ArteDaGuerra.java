import java.util.*;

public class ArteDaGuerra implements Estrategia {
    ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
        if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null || dwarfs.isEmpty())
            return;
        int qtdNoturnos = quantosElfosNoturnosAtacam(exercitoElfos.get(Status.VIVO).size(), dwarfs.size());
        for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
            boolean ehElfoNoturno = elfo instanceof ElfoNoturno;
            if (ehElfoNoturno && qtdNoturnos <= 0)
                continue;
            for (Dwarf dwarf : dwarfs) {
                if (ehElfoNoturno && qtdNoturnos-- <= 0)
                    break;
                elfo.atirarFlecha(dwarf);
            }
            ordemAtaque.add(elfo);
        }
    }

    private int quantosElfosNoturnosAtacam(int elfoSize, int dwarfSize) {
        return (int) Math.floor((elfoSize * dwarfSize) * 0.3);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemAtaque;
    }
}