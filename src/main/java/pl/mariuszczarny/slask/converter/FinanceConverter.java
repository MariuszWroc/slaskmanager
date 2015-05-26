/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.mariuszczarny.slask.model.Finance;

/**
 *
 * @author Jacek
 */
@FacesConverter("financeConverter")
public class FinanceConverter implements Converter {
             public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            System.err.println(value);
            return Long.parseLong(value);
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            System.err.println("problem "+object);
            Finance tr=(Finance) object;
            System.err.println("name of finance in question "+tr.toString());
            return String.valueOf(tr.getId());
        }
        else {
            return null;
        }
    }
}
