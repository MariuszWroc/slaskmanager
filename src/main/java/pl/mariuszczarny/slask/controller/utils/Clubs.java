/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.slask.controller.utils;

/**
 *
 * @author jacek
 */
public enum Clubs {
    Legia (1L, "Legia Warszawa"),
    Slask (2L, "Slask Wroclaw");
    
    private final Long id;
    private final String name;
    
    Clubs(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static Long getIdByName(String name){
        for(Clubs c:Clubs.values()){
            if(c.getName().equals(name)){
                return c.getId();
            }
        }
        return 0L;
    }
}
