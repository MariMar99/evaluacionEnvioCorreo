/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.controller;

import co.segundaEva.backend.persistence.entity.Telefono;
import co.segundaEva.backend.persistence.facades.TelefonoFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "telefonoManagedBean")
@RequestScoped
public class TelefonoManagedBean {

    private Telefono tel;
    
    @EJB 
    private TelefonoFacade telfc;
    
    public TelefonoManagedBean() {
    }

    public Telefono getTel() {
        return tel;
    }

    public void setTel(Telefono tel) {
        this.tel = tel;
    }
    
    @PostConstruct
    public void init(){
        tel = new Telefono();
    }
    
    
}
