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
    
    @Test
    public void dwarfsIguais(){ //retorna true
        Dwarf d1 = new IrishDwarf("gimli");
        Dwarf d2 = new IrishDwarf("gimli");
        assertTrue(d1.equals(d2));
    }
    
    @Test
    public void dwarfsDiferentes(){ //returna false
        Dwarf d1 = new IrishDwarf("gimli");
        Dwarf d2 = new IrishDwarf("gertrude");
        assertFalse(d1.equals(d2));
    }
    
    @Test
    public void dwarfsXpDiferente(){//retorna false
        DataTerceiraEra dte = new DataTerceiraEra(1,1,2000);
        Dwarf d1 = new IrishDwarf("gimli", dte);
        for(int i = 0; i < 3; i++)    
            d1.perdeVida();
        Dwarf d2 = new IrishDwarf("gertrude");
        assertFalse(d1.equals(d2));
    }
    
    @Test
    public void dwarfsInventarioDiferente(){//retorna false
        Dwarf d1 = new IrishDwarf("gimli");
        d1.adicionarItem(new Item(1, "adaga"));
        Dwarf d2 = new IrishDwarf("gertrude");
        d2.adicionarItem(new Item(2, "espada bastarda"));
        assertFalse(d1.equals(d2));
    }
    
    @Test
    public void primeiroDwarfNomeNulo(){//retorna false
        Dwarf d1 = new IrishDwarf(null);
        Dwarf d2 = new IrishDwarf("gertrude");
        assertFalse(d1.equals(d2));
    }
    
    @Test
    public void segundoDwarfNomeNulo(){//retorna false
        Dwarf d1 = new IrishDwarf("gimli");
        Dwarf d2 = new IrishDwarf(null);
        assertFalse(d1.equals(d2));
    }
    
    @Test
    public void ambsoDwarfsNomeNulo(){//retorna true
        Dwarf d1 = new IrishDwarf(null);
        Dwarf d2 = new IrishDwarf(null);
        assertTrue(d1.equals(d2));
    }
    
    @Test
    public void dwarfsStatusDiferente(){//retorna false
        Dwarf d1 = new IrishDwarf("gimli");
        Dwarf d2 = new IrishDwarf("gertrude");
        for(int i = 0; i < 12; i++)
            d1.perdeVida();
        assertFalse(d1.equals(d2));
    }
      
    @Test
    public void dwarfsVidaDiferente(){//retorna false
        Dwarf d1 = new IrishDwarf("gimli");
        Dwarf d2 = new IrishDwarf("gertrude");
        assertFalse(d1.equals(d2));
    }
}
