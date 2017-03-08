/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.email;

/**
 *
 * @author Mariana
 */
public class TestEmail {
    public static void main(String[] args){
        Email e = new Email ("Prueba Consola Evaluación", 
                "Su Usuario es", "ma412@misena.edu.co");
        e.enviarEmail();
        
    }
}
