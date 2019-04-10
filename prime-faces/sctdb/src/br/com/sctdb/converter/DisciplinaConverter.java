package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Disciplina;

/**
 * @author Jhonatas Oliveira
 *
 */
@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter {

	private GenericDao<Disciplina> ddao = new GenericDao<Disciplina>(Disciplina.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Disciplina retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = ddao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Disciplina) value).getId());
		}
		return "";
	}

}
