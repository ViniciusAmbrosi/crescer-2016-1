import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{
    private void mataElfo(ElfoNoturno elfo){
        DataTerceiraEra dte = new DataTerceiraEra(1,1,2000);
        Dwarf dwarf = new Dwarf("Imortal", dte);
        for(int i = 0; i < 92; i++)
            elfo.atirarFlecha(dwarf);
    }
    
    @Test
    public void adicionaElfo(){
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfo);
        assertFalse(ede.getExercito().containsValue(elfo));
    }
    
    @Test
    public void adicionaElfoVerde(){
        Elfo elfo = new ElfoVerde("Legolas");
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfo);
        assertTrue(ede.getExercito().containsValue(elfo));
    }
    
    @Test
    public void adicionaElfoNoturno(){
        Elfo elfo = new ElfoNoturno("Legolas");
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfo);
        assertTrue(ede.getExercito().containsValue(elfo));    
    }
    
    @Test
    public void procuraElfoExistente(){
        Elfo elfo = new ElfoNoturno("Legolas");
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfo);
        assertTrue(ede.buscarPorNome("Legolas").equals(elfo));  
    }
    
    @Test
    public void procuraElfoNaoExistente(){
        Elfo elfo = new Elfo("Legolas");
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfo);
        assertFalse(elfo.equals(ede.buscarPorNome("Legolas")));
    }
    
    @Test
    public void agrupaElfosPorStatus(){
        ElfoVerde elfoVivo = new ElfoVerde("Legolas");
        ElfoNoturno elfoMorto = new ElfoNoturno("Salogel");
        mataElfo(elfoMorto);
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfoVivo);
        ede.alistaElfo(elfoMorto);
        ede.agrupaPorStatus();
        assertTrue(ede.getExercitoAgrupado().containsKey(Status.VIVO));
        assertTrue(ede.getExercitoAgrupado().containsKey(Status.MORTO));
    }
}
