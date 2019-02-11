/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.ricardoanalistadesistemas.sorveteria.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wordpress.ricardoanalistadesistemas.sorveteria.model.UserInfo;

/**
 *
 * @author ricardobalduino
 */
@WebServlet(name = "AuthenticatorController", urlPatterns = {"/AuthenticatorController"})
public class AuthenticatorController extends HttpServlet {

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
        doPost(request, response);
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
        String user = request.getParameter("TXTUSER");
		String pass = request.getParameter("TXTPASS");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			if ("convidado".equals(user) && "123456".equals(pass)) { 
				UserInfo userinfo = new UserInfo();
				userinfo.setProfile("user");
				userinfo.setNome("Antonio Rodrigues");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo);
				
//				RequestDispatcher rd = 
//						request.getRequestDispatcher("./index.jsp");
//				rd.forward(request, response);
				response.sendRedirect("./sorvete.jsp");
			} else if ("admin".equals(user) && "password".equals(pass)) { 
				UserInfo userinfo = new UserInfo();
				userinfo.setProfile("admin");
				userinfo.setNome("Antonio Rodrigues");
				userinfo.setLogado(true);
				session.setAttribute("LOGADO", userinfo); 
				response.sendRedirect("./sorvete.jsp");
			} else { 
				msg = "Usuário ou senha incorretos";
				session.setAttribute("MENSAGEM", msg);
				session.setAttribute("LOGADO", null);
				response.sendRedirect("./login.jsp");
				
//				request.setAttribute("MENSAGEM", msg);
//				RequestDispatcher rd = 
//						request.getRequestDispatcher("./login.jsp");
//				rd.forward(request, response);
			}
		} catch (IOException e) {
			e.printStackTrace();
//		} catch (ServletException e) {
//			e.printStackTrace();
		}
    }

    
}
