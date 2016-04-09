import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    
    @Test
    public void anaoGanha6000Chapeus(){
        DataTerceiraEra dte = new DataTerceiraEra(1,1,2000);
        IrishDwarf sortudo = new IrishDwarf("Sortudo", dte);
        for(int i = 0; i < 3; i++)
            sortudo.perdeVida();
        sortudo.adicionarItem(new Item(3, "chapéus"));
        sortudo.tentarSorte();
        assertTrue(6003 == sortudo.getInventario().getItens().get(0).getQtd());
    }
    
    @Test
    public void anaoGanha15015Pocoes(){
        DataTerceiraEra dte = new DataTerceiraEra(1,1,2000);
        IrishDwarf sortudo = new IrishDwarf("Sortudo", dte);
        for(int i = 0; i < 3; i++)
            sortudo.perdeVida();
        sortudo.adicionarItem(new Item(5, "Poções"));
        sortudo.tentarSorte();
        assertTrue(15005 == sortudo.getInventario().getItens().get(0).getQtd());
    }
    
    @Test
    public void anaoGanha6000ChapeusE15015Pocos(){
        DataTerceiraEra dte = new DataTerceiraEra(1,1,2000);
        IrishDwarf sortudo = new IrishDwarf("Sortudo", dte);
        for(int i = 0; i < 3; i++)
            sortudo.perdeVida();
        sortudo.adicionarItem(new Item(3, "chapéus"));
        sortudo.adicionarItem(new Item(5, "poções"));
        sortudo.tentarSorte();
        assertTrue(6003 == sortudo.getInventario().getItens().get(0).getQtd());
        assertTrue(15005 == sortudo.getInventario().getItens().get(1).getQtd());
    }
}
