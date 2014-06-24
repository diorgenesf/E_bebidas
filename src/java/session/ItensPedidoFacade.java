/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.ItensPedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diorgenes
 */
@Stateless
public class ItensPedidoFacade extends AbstractFacade<ItensPedido> {
    @PersistenceContext(unitName = "E_bebidasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItensPedidoFacade() {
        super(ItensPedido.class);
    }
    
}
