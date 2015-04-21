/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask2014.converter;

import javax.faces.component.UIComponent;import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.mariuszczarny.slask2014.model.Stadium;

/**
 *
 * @author Jacek
 */
@FacesConverter("stadiumConverter")
public class StadiumConverter implements Converter {
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
            Stadium tr=(Stadium) object;
            System.err.println("name of stadium in question "+tr.getStadiumName());
            return String.valueOf(tr.getId());
        }
        else {
            return null;
        }
    }
}
