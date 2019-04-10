package br.com.sctdb.programa;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;
import br.com.sctdb.entity.Curso;
import br.com.sctdb.entity.Disciplina;
import br.com.sctdb.entity.Escola;
import br.com.sctdb.entity.Nota;
import br.com.sctdb.entity.Professor;

public class programa {
	public static void main(String[] args) {

		GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);
		GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);
		GenericDao<Nota> ndao = new GenericDao<Nota>(Nota.class);
		GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);
		GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);
		GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);

	}
}
