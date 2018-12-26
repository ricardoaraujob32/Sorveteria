/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GenericDAOException;
import dao.SorveteDAO;
import dao.SorveteDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Sorvete;

/**
 *
 * @author ricardobalduino
 */
@WebServlet(name = "SorveteController", urlPatterns = {"/SorveteController"})
public class SorveteController extends HttpServlet {

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
        response.getWriter()
		.append("Para acessar utilize a pagina de <a href=\"./sorvete.jsp\">sorvete</a>");
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
        String cmd = request.getParameter("cmd");
		String msg = null;
		HttpSession session = request.getSession();
		try {
			SorveteDAO sDao = new SorveteDAOImpl();
			if ( "adicionar".equals(cmd) ) {
				Sorvete s = new Sorvete();
                                
				s.setSabor( request.getParameter("txtSabor") );
				s.setPreco( Float.parseFloat( request.getParameter("txtPreco") ) );
				s.setTipo( request.getParameter("txtTipo") );
				s.setCobertura( request.getParameter("txtCobertura") );
				s.setImagem( request.getParameter("txtImagem") );
				sDao.adicionar( s );
                                
				List<Sorvete> lista = sDao.pesquisarPorSabor("");
				session.setAttribute("LISTA", lista);
				msg = "Sorvete foi adicionado com sucesso";
			} else if ( "pesquisar".equals(cmd) ) {
				List<Sorvete> lista = sDao.pesquisarPorSabor( request.getParameter("txtSabor") );
                                
				session.setAttribute("LISTA", lista);
				msg = "Foram encontrados " + lista.size() + " sorvetes";
			} else if ( "remover".equals(cmd) ) {
				String id = request.getParameter("txtId");
				
                                sDao.remover( Long.parseLong(id) );
				msg = "Sorvete com o Id " + id + " foi removido";
				
                                List<Sorvete> lista = sDao.pesquisarPorSabor("");
				session.setAttribute("LISTA", lista);				
			} else if ( "editar".equals(cmd) ) {
				String id = request.getParameter("txtId");
				Sorvete s = sDao.pesquisarPorId( Long.parseLong(id) );
                                
				session.setAttribute("SORVETE_ATUAL", s);
				msg = "Detalhes do Sorvete com o Id " + id;
			} else if ( "salvar".equals(cmd) ) {
				Sorvete s = new Sorvete();
				String id = request.getParameter("txtId");
				
                                s.setSabor(request.getParameter("txtSabor"));
				s.setPreco(Float.parseFloat(request.getParameter("txtPreco")));
				s.setTipo(request.getParameter("txtTipo"));
				s.setCobertura(request.getParameter("txtCobertura"));
				s.setImagem(request.getParameter("txtImagem"));
				sDao.salvar( Long.parseLong(id), s );
				
                                List<Sorvete> lista = sDao.pesquisarPorSabor("");
				session.setAttribute("LISTA", lista);				
				msg = "Sorvete foi atualizado com sucesso";
			} 
		} catch (GenericDAOException | NumberFormatException e) {
			e.printStackTrace();
			msg = "Erro ao acessar este sorvete";
			msg += "\n\n" + e.getMessage() + "\n";
			for (StackTraceElement trace : e.getStackTrace()) { 
				msg += trace.toString();
			}
		}

		session.setAttribute("MENSAGEM", msg);
		response.sendRedirect("./sorvete.jsp");

		//		List<Sorvete> lista = (List<Sorvete>) getServletContext().getAttribute("LISTA");
		//		if (lista == null) { 
		//			lista = new Vector<Sorvete>();
		//			getServletContext().setAttribute("LISTA", lista);
		//		}
		//		lista.add( s );
		//		System.out.println( lista.size() );
	}
}
