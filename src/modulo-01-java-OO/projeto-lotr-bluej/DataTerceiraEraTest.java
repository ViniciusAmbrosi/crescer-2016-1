

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{   
    public void criaDataTerceiraEraAno(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,200);
        assertEquals(15, dte.getDia());
        assertEquals(12, dte.getMes());
        assertEquals(200, dte.getAno());
    }
    
    @Test
    public void ano200NaoEhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,200);
        assertEquals(false, dte.ehBissexto());
    }
    
    @Test
    public void ano400EhBissexto(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,400);
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
