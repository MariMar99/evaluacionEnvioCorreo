/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.controller;

import co.segundaEva.backend.persistence.entity.Usuario;
import co.segundaEva.backend.persistence.facades.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexandra
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Usuario usuario;
    
    @EJB
    private UsuarioFacade usufc;
          
            
    public LoginManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public String iniciarSesion() {
        try {
            usuario = usufc.iniciarSesion(usuario);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                return "/pages/inicio.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario y/o Contraseña Incorrectos"));
                return "";
            }
        } catch (Exception e) {
            System.out.println("NO INGRESO AL SISTEMA");
            return "";
        }
    }
    
//    public String iniciarSesion() {
//        Usuario u;
//        String redireccionar = null;
//        try {
//            u = usufc.iniciarSesion(usuario);
//            if (u != null) {
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
//                redireccionar = "/pages/inicio?faces-redirect=true";
//            } else {
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "El usuario o la clave son incorrectas."));
//            }
//
//        } catch (Exception e) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Ocurrió un error inténtelo más tarde"));
//        }
//        return redireccionar;
//    }
    
    public void verificarSesion() {
        try {
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            if (user == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("./../permisos.xhtml");
            }
        } catch (Exception e) {

        }
    }
    
    
    
}
