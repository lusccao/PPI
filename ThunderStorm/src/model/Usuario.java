package model;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;


	private int id;
	private String nome;
	private String sobrenome;
	private String nomedeusuario;
	private String email;
	private String senha;
	private String sexo;
	private String telefone;
	private String tipoEndereco;
	private String cep;
	private String rua;
	private String cidade;
	private String estado;
	
	public Usuario() {
	}
	
	public Usuario(int id, String nome, String sobrenome, String nomedeusuario, String email, String senha, String sexo,
			String telefone, String tipoEndereco, String cep, String rua, String cidade, String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomedeusuario = nomedeusuario;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.telefone = telefone;
		this.tipoEndereco = tipoEndereco;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNomedeusuario() {
		return nomedeusuario;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setNomedeusuario(String nomedeusuario) {
		this.nomedeusuario = nomedeusuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", nomedeusuario=" + nomedeusuario
				+ ", email=" + email + ", senha=" + senha + ", sexo=" + sexo + ", telefone=" + telefone
				+ ", tipoEndere�o=" + tipoEndereco + ", cep=" + cep + ", rua=" + rua + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
	
	

	
	}
