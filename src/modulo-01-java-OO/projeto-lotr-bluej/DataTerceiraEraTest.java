import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
	public void criaDataTerceiraEraAno() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 1000);
		assertEquals(15, dataTerceiraEra.getDia());
		assertEquals(12, dataTerceiraEra.getMes());
		assertEquals(1000, dataTerceiraEra.getAno());
	}

	@Test
	public void ano2100NaoEhBissexto() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 2100);
		assertEquals(false, dataTerceiraEra.ehBissexto());
	}

	@Test
	public void ano4000EhBissexto() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 4000);
		assertEquals(true, dataTerceiraEra.ehBissexto());
	}

	@Test
	public void ano90000NaoEhBissexto() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 9000);
		assertEquals(false, dataTerceiraEra.ehBissexto());
	}

	@Test
	public void ano2000EhBissexto() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 2000);
		assertEquals(true, dataTerceiraEra.ehBissexto());
	}

	@Test
	public void ano1500NaoEhBissexto() {
		DataTerceiraEra dataTerceiraEra = new DataTerceiraEra(15, 12, 1500);
		assertEquals(false, dataTerceiraEra.ehBissexto());
	}
}
