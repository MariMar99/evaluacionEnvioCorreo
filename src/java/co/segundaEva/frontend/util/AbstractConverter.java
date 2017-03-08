/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.util;

import co.segundaEva.backend.persistence.entity.IEntity;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author APRENDIZ
 */
public abstract class AbstractConverter implements Converter{
   
    protected String nombreMB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer i = Integer.valueOf(value);
            Managedbean d = (Managedbean) context.getApplication().getELResolver().getValue(context.getELContext(), null, nombreMB);
            System.out.println(d.getObject(i));
            return d.getObject(i);
            
        } catch (NumberFormatException e) {
            context.addMessage(null, new FacesMessage("No se puede convertir el objeto"));
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof IEntity) {
                IEntity pollito = (IEntity) value;
                System.out.println(pollito);
                return pollito.getId();
            }else{
                return null;
            }
        } catch (Exception e) {
            return ""+e.getMessage();
        }
    }
    
}
