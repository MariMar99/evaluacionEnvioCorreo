/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.frontend.converter;

import co.segundaEva.backend.persistence.entity.Rol;
import co.segundaEva.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author alexandra
 */
@FacesConverter(forClass = Rol.class)
public class RolConverter extends AbstractConverter{

    public RolConverter() {
        this.nombreMB = "rolManagedBean";
    }
    
}
