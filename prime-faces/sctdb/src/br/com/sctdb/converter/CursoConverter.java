package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Curso;

@FacesConverter("cursoConverter")
public class CursoConverter implements Converter {

	private GenericDao<Curso> cdao = new GenericDao<Curso>(Curso.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Curso retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = cdao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Curso) value).getId());
		}
		return "";
	}

}
