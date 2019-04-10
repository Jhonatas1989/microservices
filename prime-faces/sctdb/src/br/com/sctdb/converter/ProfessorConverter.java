package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Professor;

@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter {

	private GenericDao<Professor> pdao = new GenericDao<Professor>(Professor.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Professor retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = pdao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Professor) value).getId());
		}
		return "";
	}

}
