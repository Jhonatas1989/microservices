package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Escola;

/**
 * @author Jhonatas Oliveira
 *
 */
@FacesConverter("escolaConverter")
public class EscolaConverter implements Converter {

	private GenericDao<Escola> edao = new GenericDao<Escola>(Escola.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Escola retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = edao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Escola) value).getId());
		}
		return "";
	}

}
