/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.controller;

import co.segundaEva.backend.persistence.entity.Correo;
import co.segundaEva.backend.persistence.entity.Telefono;
import co.segundaEva.backend.persistence.entity.Usuario;
import co.segundaEva.backend.persistence.facades.CorreoFacade;
import co.segundaEva.backend.persistence.facades.TelefonoFacade;
import co.segundaEva.backend.persistence.facades.UsuarioFacade;
import co.segundaEva.frontend.email.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author alexandra
 */
@Named(value = "usuarioManagedBean")
@RequestScoped
public class UsuarioManagedBean implements Serializable {

    private Usuario usuario;
    private Telefono tel;
    private Correo correo;

    @EJB
    private UsuarioFacade usufc;
    @EJB
    private TelefonoFacade telfc;
    @EJB
    private CorreoFacade correofc;
    
    
    private String asunto;
    private String mensaje;    
    

    public UsuarioManagedBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Telefono getTel() {
        return tel;
    }

    public void setTel(Telefono tel) {
        this.tel = tel;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        tel = new Telefono();
        correo = new Correo();
        asunto = "Registro Exitoso";
    }

    public void registrarUsuario() {
        try {
            usufc.create(usuario);
        } catch (Exception e) {
            System.out.println("NO REGISTRA EN LA BD");
        }
    }

    public List<Usuario> listarUsuarios() {
        return usufc.findAll();
    }

    String claveAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    public void registrar() {
        try {
            String cadena = claveAleatoria(6); //Llama el metodo que genera la contraseña
            usuario.setClave(cadena);//Se genera
            usufc.create(usuario);//Crea Usuario

            tel.setIdUsuario(usuario);//Por debajo
            telfc.create(tel);//Crea el telefono

            correo.setIdUsuario(usuario);//Por debajo
            correofc.create(correo);//Crea el Correo            

            //Enviar Correo
            setMensaje("Su Usuario es la Cedula y su contraseña es: "+usuario.getClave());
            Email e = new Email(asunto, mensaje, correo.getCorreo());
            
            e.enviarEmail();

        } catch (Exception e) {
            System.out.println("NO REGISTRA EN LA BD");
        }
    }

}
