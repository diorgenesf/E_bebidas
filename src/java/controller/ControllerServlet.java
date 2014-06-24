/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Categoria;
import entity.Produto;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CategoriaFacade;
import session.ProdutoFacade;

/**
 *
 * @author Hercilia
 */
@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {"/categoria", "/addCarrinho", "/produto", "/carrinho", "/compra"})
public class ControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private CategoriaFacade categoryFacade;
    @EJB
    private ProdutoFacade produtoFacade;

    public void init() throws ServletException {
        // store category list in servlet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
        getServletContext().setAttribute("novos_produtos", produtoFacade.findNovos());
        getServletContext().setAttribute("mais_vendidos", produtoFacade.findMaisVendidos());
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if categoria page is requested
        if (userPath.equals("/categoria")) {
            // TODO: Implement categoria request
            String categoryID = request.getParameter("id");
            
            if(categoryID != null)
            {
                System.out.println("categoryID: "+categoryID);
                int offset = 0;
                if (request.getParameter("offset")!=null) offset=Integer.parseInt(request.getParameter("offset"));
                offset *=6;
                System.out.println("Offset: "+offset);
                System.out.println("Order: "+request.getParameter("order"));
                String orderV = "titulo";
                String orderF = "ASC";
                if(request.getParameter("order") != null)
                {
                    switch(request.getParameter("order"))
                    {
                        case "T-ASC":
                            orderV = "titulo";
                            orderF = "ASC";
                            break;
                        case "T-DESC":
                            orderV = "titulo";
                            orderF = "DESC";
                            break;
                        case "P-ASC":
                            orderV = "valorUnitario";
                            orderF = "ASC";
                            break;
                        case "P-DESC":
                            orderV = "valorUnitario";
                            orderF = "DESC";
                            break;
                        default :
                            orderV = "titulo";
                            orderF = "ASC";
                            break;
                    }
                }
                Categoria selectedCategory = categoryFacade.find(Integer.parseInt(categoryID));
                request.setAttribute("selectedCategory", selectedCategory);
                
                Collection<Produto> categoryProducts = produtoFacade.findProdutosByCategory(Integer.parseInt(categoryID), 6, offset, orderV, orderF);
                request.setAttribute("categoryProducts", categoryProducts);
            }
            userPath = "/categoria";

        // if cart page is requested
        } else if (userPath.equals("/carrinho")) {
            // TODO: Implement cart page request

            userPath = "/carrinho";

        // if checkout page is requested
        }else if (userPath.equals("/produto")) {
            // TODO: Implement cart page request

            userPath = "/produto";

        // if checkout page is requested
        } else if (userPath.equals("/finalizar")) {
            // TODO: Implement checkout page request
            userPath = "/finalizar";
        // if user switches language
        } 

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if addCarrinho action is called
        if (userPath.equals("/addCarrinho")) {
            // TODO: Implement add product to cart action

        // if updateCart action is called
        } 
        /*else if (userPath.equals("/updateCart")) {
            // TODO: Implement update cart action

        // if compra action is called
        }*/ 
        else if (userPath.equals("/compra")) {
            // TODO: Implement compra action

            userPath = "/confirmacao";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}