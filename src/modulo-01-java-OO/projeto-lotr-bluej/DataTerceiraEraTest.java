

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
    public void criaDataTerceiraEraAno200(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,200);
        assertEquals(false, dte.ehBissexto());
    }
    
    @Test
    public void criaDataTerceiraEraAno400(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,400);
        assertEquals(true, dte.ehBissexto());
    }
    
    @Test
    public void criaDataTerceiraEraAno9000(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,9000);
        assertEquals(false, dte.ehBissexto());
    }
    
    @Test
    public void criaDataTerceiraEraAno2000(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,2000);
        assertEquals(true, dte.ehBissexto());
    }
    
    @Test
    public void criaDataTerceiraEraAno1500(){
        DataTerceiraEra dte = new DataTerceiraEra(15,12,1500);
        assertEquals(false, dte.ehBissexto());
    }
        
}
