/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.City;
import pl.mariuszczarny.slask.service.ICityService;

/**
 *
 * @author Mariusz
 */
@ManagedBean(name = "cityController")
@SessionScoped
public class CityController implements Serializable, IAppController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	private ICityService cityService;
    private MessageController messageController;
    private List<City> cityList = null;
    private City selectedCity;
    private Long idCity;
    private String cityName;

    public CityController() {
        idCity=0L;
        cityName="";
        selectedCity = new City();
    }
    
    public String prepareEdit() {
        return "EditCity";
    }
    
    public String prepareAdd()
    {
        return "AddCity";
    }

    public ICityService getCityService() {
        return cityService;
    }

    public void setCityService(ICityService cityService) {
        this.cityService = cityService;
    }

    public List<City> getCityList() {
        getMessageController().getMessageList().add("pokaż listę miast");
        cityList = new ArrayList<City>();
        cityList.addAll(getCityService().findAllByCriteria());
        return cityList;
    }

    public void destroy() {
        getCityService().delete(selectedCity);
    }
    
    public String update()
    {
    	logger.info("selectedCity " + selectedCity);
        getCityService().update(selectedCity);
        return selectedCity.toString();
    }
    
    public String save()
    {
    	logger.info("Start saving");
        City city = new City();
         try {
            city.setId((long)getCityService().findAllByCriteria().size()+1); 
            city.setCityName(cityName); 
            getCityService().add(city); 
            return StringConstants.SAVE_SUCCESS.getValue();
        } catch (DataAccessException e) {
            e.getMessage();
        }   
        return ERROR + " - " + selectedCity.toString();
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public void setMessageController(MessageController messageController) {
        this.messageController = messageController;
    }

    public MessageController getMessageController() {
        return messageController;
    }
    
    public void setSelectedCity(City selectedCity)
    {
        this.selectedCity=selectedCity;
    }
    
    public City getSelectedCity()
    {
        return selectedCity;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    
}
