package pais;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

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
		copia.setNome("Dublin");
		copia.setPopulacao(553165);
		copia.setArea(114.99);
		paisService = new PaisService();
		//System.out.println(pais);
		//System.out.println(copia);
		//System.out.println(id);
		System.out.println("____________________________\n");
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Alemanha");
		fixture.setPopulacao(357051);
		fixture.setArea(82800000);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		System.out.println(novo);
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		PaisService service = new PaisService(); 
		assertEquals("testa criacao", pais, service.carregar(id));
	}
	
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(230000);
		copia.setPopulacao(230000);
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);
	}
	
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		System.out.println(pais);
		assertNotEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04BuscaMaisHab() {
		System.out.println("Busca Pais mais habitado");
		PaisService novoService = new PaisService();
		System.out.println(novoService.PaisMaisHab());
	}
	
	@Test
	public void test05BuscaMenorArea() {
		System.out.println("Busca Menor area");
		PaisService novoService = new PaisService();
		System.out.println(novoService.PaisMenorArea());
	}

	@Test
	public void test05VetorTresPaises() {
		System.out.println("Três Paises");
		PaisService novoService = new PaisService();
		System.out.println(novoService.VetorTresPaises());
	}
}
