/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public ProdutoFacade() {
        super(Produto.class);
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
        //Categoria c = new CategoriaFacade().find(idcat);    
        String s = "SELECT p FROM Produto p WHERE p.idcategoria.idcategoria = "+idcat+" ORDER BY p."+orderByElement+" "+orderByAction;
        System.out.println("Query: "+s);
        Query query =em.createQuery(s);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        List<Produto> prods = query.getResultList();
        return prods;
    }
}
