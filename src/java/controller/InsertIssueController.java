/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.UserDAO;
import user.UserVirtualIssue;
import user.UserVirtualIssueS;
import virtual.ListVirtual;

/**
 *
 * @author 84348
 */
@WebServlet(name = "InsertIssueController", urlPatterns = {"/InsertIssueController"})
public class InsertIssueController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "MainController?action=SeacrhIssue&seacrhIssue=";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            ListVirtual cart = (ListVirtual) session.getAttribute("LIST_VIRTUAL");
            if (cart != null) {
                if (cart.getListVirtual().size() > 0) {
                    boolean createIssue = false;
                    for (UserVirtualIssue tm : cart.getListVirtual().values()) {
                        String note = tm.getNote();
                        String accountantID = tm.getAccountantID();
                        String sellerID = tm.getSellerID();
                        int orderID = tm.getOrderID();
                        UserVirtualIssueS shoppingCart = new UserVirtualIssueS(note, accountantID, sellerID, orderID);
                        UserDAO dao = new UserDAO();
                        createIssue = dao.createDetail(shoppingCart);
                    }
                    if (createIssue == true){
                        if (session != null) {
                            if (cart != null) {
                                session.removeAttribute("LIST_VIRTUAL");
                                url = SUCCESS;

                            }
                    }
                        
                        

                    }

                }
            }

        } catch (Exception e) {
            System.out.println("Error at BuyController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
