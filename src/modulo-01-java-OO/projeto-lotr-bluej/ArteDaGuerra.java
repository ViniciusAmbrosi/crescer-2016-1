import java.util.*;

public class ArteDaGuerra implements Estrategia {
    ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
    	ArrayList<Elfo> exercitoElfosVivos = exercitoElfos.get(Status.VIVO);
        if (dwarfs == null || exercitoElfosVivos == null || dwarfs.isEmpty())
            return;
        int qtdNoturnos = quantosElfosNoturnosAtacam(exercitoElfosVivos.size(), dwarfs.size());
        for (Elfo elfo : exercitoElfosVivos) {
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
        return (int)(elfoSize * dwarfSize  * 0.3);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemAtaque;
    }
}