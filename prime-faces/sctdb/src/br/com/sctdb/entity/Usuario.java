package br.com.sctdb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "USUARIO", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDUSUARIO") })
@NamedQuery(name = "Usuario.findAll", query = "select f from Usuario f")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO", unique = true, nullable = false)
	private int id;

	@Column(name = "EMAIL", nullable = false, length = 45, unique = true)
	private String email;

	@Column(name = "USUARIO", nullable = false, length = 45, unique = true)
	private String usuario;

	@Column(name = "SENHA", nullable = false, length = 45)
	private String senha;

	@Column(name = "TIPO", nullable = false)
	private Integer tipo;

	/**
	 * 
	 */
	public Usuario() {
	}

	/**
	 * @param id
	 * @param email
	 * @param usuario
	 * @param senha
	 * @param tipo
	 */
	public Usuario(int id, String email, String usuario, String senha, Integer tipo) {
		super();
		this.id = id;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the tipo
	 */
	public Integer getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", usuario=" + usuario + ", senha=" + senha + ", tipo=" + tipo
				+ "]";
	}

}
