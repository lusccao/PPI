package dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT username, password FROM faculdade.usuario "
				+ "WHERE username = ? and password = ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			
			// Iniciando criptografia
						MessageDigest md = MessageDigest.getInstance("SHA-256");
						byte messageDigest[] = md.digest(usuario.getPassword().getBytes("UTF-8"));
						
						StringBuilder sb = new StringBuilder();
						
						for(byte b : messageDigest) {
							sb.append(String.format("%02X", 0xFF & b));
						}
						String senhaCript = sb.toString();
						//Finalização da criptografia
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, usuario.getUsername());
				stm.setString(2, senhaCript);
				try (ResultSet rs = stm.executeQuery();) {
					return rs.next();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
		} catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		return false;
	}
}
