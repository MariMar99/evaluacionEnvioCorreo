/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.segundaEva.backend.persistence.facades;

import co.segundaEva.backend.persistence.entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author alexandra
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "SegundaEvaluacionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario user) {
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "FROM Usuario u WHERE u.cedula = ?1 and u.clave = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, user.getCedula());
            query.setParameter(2, user.getClave());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }
    
}
