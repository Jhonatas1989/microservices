package br.com.sctdb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.sctdb.dao.GenericDao;
import br.com.sctdb.entity.Usuario;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	private GenericDao<Usuario> udao = new GenericDao<Usuario>(Usuario.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		if (value != null) {
			int id = Integer.parseInt(value);
			retorno = udao.buscar(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Usuario) value).getId());
		}
		return "";
	}

}
