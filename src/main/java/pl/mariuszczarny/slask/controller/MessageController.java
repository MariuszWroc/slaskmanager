/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mariuszczarny.slask.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Jacek
 */
@ManagedBean(name = "messageController")
@SessionScoped
public class MessageController implements Serializable, IAppController{
	private static final String WELCOME_MESSAGE = "Witamy w SlaskManager 2014";
	private static final long serialVersionUID = 1L;
	private List<String> messageList;
    
    public MessageController()
    {
        messageList = new ArrayList<>();        
    }
    
    @PostConstruct
    public void init()
    {       
        getMessageList().add(WELCOME_MESSAGE);
    }
    public void setMessageList(List<String> messageList)
    {
        this.messageList=messageList;
    }
    
    public List<String> getMessageList()
    {
        return messageList;
    }
}
