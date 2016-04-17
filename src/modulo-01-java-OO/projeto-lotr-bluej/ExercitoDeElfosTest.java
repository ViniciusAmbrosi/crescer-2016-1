import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest{
    @Before
    public void tearDown() {
        System.gc();
        System.runFinalization();
    }
    
    
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
        ElfoVerde elfoVivo1 = new ElfoVerde("Pdra");
        ElfoVerde elfoVivo2 = new ElfoVerde("Legasdlas");
        ElfoVerde elfoVivo3 = new ElfoVerde("Legolfs");
        ElfoVerde elfoVivo4 = new ElfoVerde("Legolaas");
        ElfoNoturno elfoMorto = new ElfoNoturno("Salogel");
        mataElfo(elfoMorto);
        ExercitoDeElfos ede = new ExercitoDeElfos();
        ede.alistaElfo(elfoVivo);
        ede.alistaElfo(elfoVivo1);
        ede.alistaElfo(elfoVivo2);
        ede.alistaElfo(elfoVivo3);
        ede.alistaElfo(elfoVivo4);
        ede.alistaElfo(elfoMorto);
        ede.agrupaPorStatus();
        assertTrue(ede.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo));
        assertTrue(ede.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo1));
        assertTrue(ede.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo2));
        assertTrue(ede.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo3));
        assertTrue(ede.getExercitoAgrupado().get(elfoVivo.getStatus()).contains(elfoVivo4));
        assertTrue(ede.getExercitoAgrupado().get(elfoMorto.getStatus()).contains(elfoMorto));
    }
}
