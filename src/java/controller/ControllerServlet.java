/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if categoria page is requested
        if (userPath.equals("/categoria")) {
            // TODO: Implement categoria request
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