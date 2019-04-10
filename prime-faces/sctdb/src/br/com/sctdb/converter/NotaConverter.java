package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Nota;

@FacesConverter(forClass = Nota.class)
public class NotaConverter implements Converter {

	private GenericDao<Nota> ndao = new GenericDao<Nota>(Nota.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Nota retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = ndao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Nota) value).getId());
		}
		return "";
	}

}
