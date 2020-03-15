package pais;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import PaisService;

public class PaisTeste {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Dublin");
		pais.setPopulacao(553165);
		pais.setArea(114.99);
		copia = new Pais();
		copia.setId(id);
		pais.setNome("Dublin");
		pais.setPopulacao(553165);
		pais.setArea(114.99);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(0);
		fixture.setNome("Canada");
		fixture.setPopulacao(37242571);
		fixture.setArea(9984670);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
}
