/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Categoria;
import entity.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.jboss.weld.bean.builtin.FacadeInjectionPoint;

/**
 *
 * @author Diorgenes
 */
@Stateless
public class ProdutoFacade extends AbstractFacade<Produto> {
    @PersistenceContext(unitName = "E_bebidasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /*
    SQL: SELECT * FROM table IT start, maxRows;
    Query q = session.createQuery("FROM table");
    q.setFirstResult(start);
    q.setMaxResults(maxRows);
    */
    
    public List<Produto> findNovos()
    {
        List<Produto> prods=em.createQuery("SELECT p FROM Produto p ORDER BY p.idproduto DESC",Produto.class).setMaxResults(3).getResultList();        
        return prods;
    }
    
    public List<Produto> findMaisVendidos()
    {
        List<Produto> prods=em.createQuery("SELECT p FROM Produto p ORDER BY p.idproduto ASC",Produto.class).setMaxResults(3).getResultList();        
        return prods;
    }
    
    public List<Produto> findProdutosByCategory(int idcat, int limit, int offset, String orderByElement, String orderByAction)
    {
        Categoria c = new CategoriaFacade().find(idcat);        
        Query query =em.createQuery("SELECT p FROM Produto p WHERE p.idcategoria = ? ORDER BY p."+orderByElement+" "+orderByAction,Categoria.class);
        query.setParameter(1, c);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<Produto> prods = query.getResultList();
        return prods;
    }
    
    public ProdutoFacade() {
        super(Produto.class);
    }
    
}
