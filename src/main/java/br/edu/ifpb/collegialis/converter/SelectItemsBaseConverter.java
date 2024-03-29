package br.edu.ifpb.collegialis.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.edu.ifpb.collegialis.util.SelectItemsUtils;

public abstract class SelectItemsBaseConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return SelectItemsUtils.findValueByStringConversion(context, component, value, this);
    }

}
