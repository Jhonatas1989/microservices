package com.school.administration.persist.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name = "USUARIO", catalog = "sctdb", uniqueConstraints = { @UniqueConstraint(columnNames = "IDUSUARIO") })
@NamedQuery(name = "Usuario.findAll", query = "select f from Usuario f")
public class User implements Serializable {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
