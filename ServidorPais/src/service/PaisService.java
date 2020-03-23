package service;

import model.Pais;
import dao.PaisDAO;


public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public int criar(Pais cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Pais cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Pais carregar(int id){
		return dao.carregar(id);
	}

}
