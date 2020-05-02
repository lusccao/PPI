package service;

import model.Usuario;
import dao.UsuarioDAO;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Usuario cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}

	
}
