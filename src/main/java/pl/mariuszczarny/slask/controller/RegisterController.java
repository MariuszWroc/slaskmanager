/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;

import pl.mariuszczarny.slask.controller.utils.StringConstants;
import pl.mariuszczarny.slask.model.User;
import pl.mariuszczarny.slask.service.IRoleService;
import pl.mariuszczarny.slask.service.IUserService;

/**
 *
 * @author Jacek
 */
@ManagedBean(name = "registercontroller")
@SessionScoped
public class RegisterController implements Serializable, IAppController {
	private static final String POMYŚLNIE_ZAREJSTROWANO = "Pomyślnie Zarejstrowano";
	private static final String REJESTRACJA_NIEUDANA = "rejestracja nieudana";
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	private String name;
	private String lastName;
	private String login;
	private String password;
	private IUserService userService;
	private IRoleService roleService;

	public RegisterController() {
		name = "";
		lastName = "";
		login = "";
		password = "";

	}

	public String save() {
		User newUser = new User();
		try {
			newUser.setId(generateId());
			newUser.setLogin(login);
			newUser.setSname(lastName);
			newUser.setName(name);
			newUser.setPassword(password);
			newUser.setRoleidRole(roleService.findAllByCriteria().get(1));
			getUserService().add(newUser);
		} catch (EmptyResultDataAccessException e) {
            logger.info(e.getMessage(), e); 
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, REJESTRACJA_NIEUDANA, ""));
			return StringConstants.SAVE_ERROR.getValue() + " - " + newUser.toString();
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, POMYŚLNIE_ZAREJSTROWANO, ""));

		return "/HomePage.xhtml";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private Long generateId() {
		return getUserService().count() + 1L;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

}
