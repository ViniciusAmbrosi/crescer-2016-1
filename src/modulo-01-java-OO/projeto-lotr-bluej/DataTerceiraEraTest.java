

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{   
    public void criaDataTerceiraEraAno(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,1000);
        assertEquals(15, dte.getDia());
        assertEquals(12, dte.getMes());
        assertEquals(1000, dte.getAno());
    }
    
    @Test
    public void ano2100NaoEhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,2100);
        assertEquals(false, dte.ehBissexto());
    }
    
    @Test
    public void ano4000EhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,4000);
        assertEquals(true, dte.ehBissexto());
    }
    
    @Test
    public void ano90000NaoEhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,9000);
        assertEquals(false, dte.ehBissexto());
    }
    
    @Test
    public void ano2000EhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,2000);
        assertEquals(true, dte.ehBissexto());
    }
    
    @Test
    public void ano1500NaoEhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,1500);
        assertEquals(false, dte.ehBissexto());
    }
        
}
