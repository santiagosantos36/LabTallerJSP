/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.sessionBEAN.CalcbeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "CalServlet", urlPatterns = {"/CalServlet"})
public class CalServlet extends HttpServlet {

    @EJB
    private CalcbeanLocal calcbean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                    String v1 = request.getParameter("numero");
                    int val1;
                    int val2;
                    int tam = v1.length();
               String A[] = new String[100];
               //Array para almacenar operadores.
               String operaciones[] = new String[100];
               int pos = 0;
               int sum = 0;
               String aux = "";

               //inicializa primer operador.
               operaciones[0] = "+";
               int index_operacion = 0;
               for(int i = 0; i<tam ; i++)
               {
                   if(v1.charAt(i) == '+' || v1.charAt(i) == '-' || v1.charAt(i) == '*' || v1.charAt(i) == '/' || v1.charAt(i) == '%' || v1.charAt(i) == '^')
                   {
                       A[pos] = aux;
                       operaciones[index_operacion] = String.valueOf(v1.charAt(i));
                       pos++;   
                       index_operacion++;
                       aux = "";            
                   }
                   else
                   {
                       aux = aux + v1.charAt(i);
                   }        
               }
               A[pos] = aux;
               pos++;
               val1= Integer.parseInt(A[0]);
               val2= Integer.parseInt(A[1]);
              
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            for(int i = 0; i<pos ; i++)
               {           
                   //Determina la operación a realizar.         
                   if(operaciones[i].equals("+")){
                    out.println("<h1> suma = " + calcbean.sumar(val1, val2) + "</h1>");    
                   }else if (operaciones[i].equals("-")){
                       out.println("<h1> resta = " + calcbean.resta(val1, val2) + "</h1>");              
                   }  else if (operaciones[i].equals("*")){
                       out.println("<h1> multiplicacion = " + calcbean.multiplicacion(val1, val2) + "</h1>");              
                   }  else if (operaciones[i].equals("/")){
                       out.println("<h1> dividir = " + calcbean.dividir(val1, val2) + "</h1>");              
                   }     else if (operaciones[i].equals("%")){
                       out.println("<h1> modulo = " + calcbean.modulo(val1, val2) + "</h1>");              
                   }  else if (operaciones[i].equals("^")){
                       out.println("<h1> cuadrado = " + calcbean.cuadrado(val1,val2) + "</h1>");              
                   }      

               }
        
            
            out.println("</body>");
            out.println("</html>");
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