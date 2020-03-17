package pais;

import static org.junit.Assert.assertEquals;

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
		pais.setNome("Dublin");
		pais.setPopulacao(553165);
		pais.setArea(114.99);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
		System.out.println("____________________________\n");
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
	
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
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
	
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04BuscaMaisHab() {
		System.out.println("Busca Pais mais habitado");
		PaisService novoService = new PaisService();
		assertEquals("testa Busca Hab", novoService.PaisMaisHab());
	}
	
	@Test
	public void test05BuscaMenorArea() {
		System.out.println("Busca Menor area");
		PaisService novoService = new PaisService();
		assertEquals("testa Busca Area", novoService.PaisMenorArea());
	}
	
	@Test
	public void test05VetorTresPaises() {
		System.out.println("Três Paises");
		PaisService novoService = new PaisService();
		assertEquals("testa Busca Area", novoService.VetorTresPaises());
	}
}
