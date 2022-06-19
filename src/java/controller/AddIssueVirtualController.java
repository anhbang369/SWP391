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
import javax.servlet.http.HttpSession;
import user.UserDAO;
import user.UserVirtualIssue;
import virtual.ListVirtual;

/**
 *
 * @author 84348
 */
@WebServlet(name = "AddIssueVirtualController", urlPatterns = {"/AddIssueVirtualController"})
public class AddIssueVirtualController extends HttpServlet {

    private static final String ERROR = "issueVirtual.jsp";
    private static final String SUCCESS = "issueVirtual.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            boolean k = true;
            String issueID = request.getParameter("issueID");
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            HttpSession session = request.getSession();
            ListVirtual ca = (ListVirtual) session.getAttribute("LIST_VIRTUAL");
            if(ca!=null){
                if (ca.getListVirtual().size() > 0){
                    for (UserVirtualIssue tm : ca.getListVirtual().values()){
                        if(tm.getIssueID().equalsIgnoreCase(issueID)||tm.getOrderID()==orderID){
                            k=false;
                            request.setAttribute("ERROR", "IssueID or OrderId already exists in the table.");
                        }
                    }
                }
            }
            if(k==true){
                String note = request.getParameter("note");
            String accountantID = request.getParameter("accountantID");
            String sellerID = request.getParameter("sellerID");
            UserDAO dao = new UserDAO();
            boolean checkAccountA = dao.checkExistAccount(accountantID);
            boolean checkAccountS = dao.checkExistAccount(sellerID);
            boolean checkOrderID = dao.checkExistOrderID(orderID);
            boolean checkOrderIdI = dao.checkOrderIdIssue(orderID);
            if (checkAccountA == true && checkAccountS == true && checkOrderID == true && checkOrderIdI==true) {
                UserVirtualIssue tm = new UserVirtualIssue(issueID,note, accountantID, sellerID, orderID);
                
                ListVirtual cart = (ListVirtual) session.getAttribute("LIST_VIRTUAL");
                if (cart == null) {
                    cart = new ListVirtual();
                }
                cart.add(tm);
                session.setAttribute("LIST_VIRTUAL", cart);
                url = SUCCESS;
            }else{
                request.setAttribute("ERROR", "Account or orderID not true!!!");
            }
            }
            

        } catch (Exception e) {
            System.out.println("Error at InsertController: " + e.toString());
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
