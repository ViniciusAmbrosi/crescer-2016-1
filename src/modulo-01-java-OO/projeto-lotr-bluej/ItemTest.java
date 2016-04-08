import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest{
    @Test
    public void cria1ItemEspada(){
        Item item = new Item(1,"espada");
        assertEquals(1, item.getQtd());
        assertTrue(item.getDescricao().equals("espada"));
    }
}
