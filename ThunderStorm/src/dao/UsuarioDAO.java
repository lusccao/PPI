package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO usuario(nome, sobrenome, nomedeusuario, email, senha, sexo, cep, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSobrenome());
			stm.setString(3, usuario.getNomedeusuario());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSenha());
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getCep());
			stm.setString(8, usuario.getCidade());
			stm.setString(9, usuario.getEstado());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, sobrenome=?, nomedeusuario=?, email=?, senha=?, sexo=?, cep=?, cidade=?, estado=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSobrenome());
			stm.setString(3, usuario.getNomedeusuario());
			stm.setString(4, usuario.getEmail());
			stm.setString(5, usuario.getSenha());
			stm.setString(6, usuario.getSexo());
			stm.setString(7, usuario.getCep());
			stm.setString(8, usuario.getCidade());
			stm.setString(9, usuario.getEstado());
			stm.setInt(10, usuario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, fone, email FROM cliente WHERE cliente.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setNomedeusuario(rs.getString("nomedeusuario"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setSexo(rs.getString("sexo"));
					usuario.setCep(rs.getString("cep"));
					usuario.setCidade(rs.getString("cidade"));
					usuario.setEstado(rs.getString("estado"));

				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setSobrenome(null);
					usuario.setNomedeusuario(null);
					usuario.setEmail(null);
					usuario.setSenha(null);
					usuario.setSexo(null);
					usuario.setCep(null);
					usuario.setCidade(null);
					usuario.setEstado(null);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

}
