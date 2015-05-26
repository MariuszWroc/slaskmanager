/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.converter;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pl.mariuszczarny.slask.model.Tournament;
import pl.mariuszczarny.slask.service.ITournamentService;

/**
 *
 * @author Jacek
 */
@FacesConverter("tournamentConverter")
public class TournamentConverter implements Converter {
        
    @ManagedProperty(value = "#{tournamentService}")
    ITournamentService tournamentService;
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            System.err.println(value);
            if(getTournamentService()!=null){
            return getTournamentService().findById(Long.parseLong(value));
            }else{
                System.err.println("null sending id to ManagedBean");
                return Long.parseLong(value);
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            System.err.println("problem "+object);
            Tournament tr=(Tournament) object;
            System.err.println("name of training in question "+tr.getTournamentName());
            return String.valueOf(tr.getId());
        }
        else {
            return null;
        }
    }

    public ITournamentService getTournamentService() {
        return tournamentService;
    }

    public void setTournamentService(ITournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }
    
    
}
