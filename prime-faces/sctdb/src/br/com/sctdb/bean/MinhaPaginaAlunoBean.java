package br.com.sctdb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Nota;
import br.com.sctdb.entity.Usuario;
import br.com.sctdb.util.SessionUtils;

/**
 * @author Jhonatas Oliveira
 *
 */
@ManagedBean
@ViewScoped
public class MinhaPaginaAlunoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
	private Aluno aluno;

	/**
	 * 
	 */
	public MinhaPaginaAlunoBean() {
		aluno = pegarAluno(SessionUtils.getUser());
	}

	/**
	 * @param nota
	 * @return
	 */
	public String aprovacao(Nota nota) {
		String aprovado;
		Double nota1 = 0.0;
		Double nota2 = 0.0;
		Double nota3 = 0.0;
		if (nota.getProjeto1() != null) {
			nota1 = nota.getProjeto1() * 0.3;
		}
		if (nota.getProjeto2() != null) {
			nota2 = nota.getProjeto2() * 0.3;
		}
		if (nota.getAtividadePratica() != null) {
			nota3 = nota.getAtividadePratica() * 0.4;
		}
		Double total = nota1 + nota2 + nota3;
		if (total >= 7.0) {
			aprovado = "Aprovado";
		} else {
			aprovado = "Reprovado";
		}
		return aprovado;
	}

	/**
	 * @param user
	 * @return
	 */
	public Aluno pegarAluno(Usuario user) {
		Aluno al = null;
		for (Aluno aluno : adao.listar()) {
			if (aluno.getEmail().equals(user.getEmail())) {
				al = aluno;
			}
		}
		return al;
	}

	/**
	 * @return the adao
	 */
	public GenericDao<Aluno> getAdao() {
		return adao;
	}

	/**
	 * @param adao the adao to set
	 */
	public void setAdao(GenericDao<Aluno> adao) {
		this.adao = adao;
	}

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
