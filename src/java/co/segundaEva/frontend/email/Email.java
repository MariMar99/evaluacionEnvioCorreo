/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mariana
 */
public class Email {

    private final static String HOST = ("smtp.gmail.com"); //Servidor de Correos que se va a usar (en este caso gmail)
    private final static String PORT = ("587"); // Tambien el puerto puede ser= 25 ó 587
    private final static String REMITENTE = ("expochick17@gmail.com"); // Cuenta de la que va salir el correo
    private final static String REMITENTE_PAST = ("expo1234"); //Password "REMITENTE_PASS"

    private String asunto;
    private String mensaje;
    private String destino;

    private Properties propiedades;

    public Email() {
        iniciarPropiedades();
    }

    public Email(String asunto, String mensaje, String destino) {
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.destino = destino;
        iniciarPropiedades();
    }

    //Si se fuera a usar @EJB se inicia acá el PostConstruct
    private void iniciarPropiedades() { //Se inicializan las propiedades porque hay dos Constructores
        propiedades = new Properties();
        //inicia el Map ->
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", HOST);
        propiedades.put("mail.smtp.port", PORT);
    }

    private Session getSession() {
        Authenticator a = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, REMITENTE_PAST);
            }
        };
        return Session.getInstance(propiedades, a);
    }

    //-------Métodos de Enviar Correos *-*-*-*-*-*-*
    
    
    public void enviarEmail() {//Método Enviar a un solo destinatario
        try {
            Session session = getSession(); //Nos devuelve el método
            Message msj = new MimeMessage(session); //El atributo que nos trae la sesión
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setText(this.mensaje);
            msj.setRecipient(Message.RecipientType.TO, new InternetAddress(this.destino));
            Transport.send(msj);
        } catch (MessagingException ex) {
            System.out.println("Envio de Correo Incorrecto!");
            ex.printStackTrace();
        }
    }
    
    public void enviarEmailVarios() { //Este método envia el mensaje a varios correos
        try {
            Session session = getSession(); //Nos devuelve el método
            Message msj = new MimeMessage(session); //El atributo que nos trae la sesión
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setText(this.mensaje);
            msj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.destino)); //plural "S"
            Transport.send(msj); 
        } catch (MessagingException ex) {
            System.out.println("Envio de Correo Incorrecto!");
            ex.printStackTrace();
        }
    }
    
    public void enviarEmailHtml() { // este método envia el mensaje con los estilos que le añadas
        try {
            Session session = getSession(); //Nos devuelve el método
            Message msj = new MimeMessage(session); //El atributo que nos trae la sesión
            msj.setFrom(new InternetAddress(REMITENTE));
            msj.setSubject(this.asunto);
            msj.setContent(this.mensaje, "text/html"); //Acá que el destinatario reciba los estilos por eso el Content
            msj.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.destino));
            Transport.send(msj); 
        } catch (MessagingException ex) {
            System.out.println("Envio de Correo Incorrecto!");
            ex.printStackTrace();
        }
    }
    

}
