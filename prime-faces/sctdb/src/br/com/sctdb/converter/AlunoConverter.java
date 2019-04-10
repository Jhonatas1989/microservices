package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Aluno;

/**
 * @author Jhonatas Oliveira
 *
 */
@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	private GenericDao<Aluno> adao = new GenericDao<Aluno>(Aluno.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Aluno retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = adao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Aluno) value).getId());
		}
		return "";
	}

}
