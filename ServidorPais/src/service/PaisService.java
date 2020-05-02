package service;

import model.Pais;

import java.util.ArrayList;

import dao.PaisDAO;


public class PaisService {
	PaisDAO dao = new PaisDAO();
	
	public PaisService(){
		dao = new PaisDAO();
	}
	
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
	
	public ArrayList<Pais> listarPaises(){
		return dao.listarPaises();
	}
	public ArrayList<Pais> listarPaises(String chave){
		return dao.listarPaises(chave);
	}

}
