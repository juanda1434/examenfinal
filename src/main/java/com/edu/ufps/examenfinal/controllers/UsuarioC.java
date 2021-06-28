package com.edu.ufps.examenfinal.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.ufps.examenfinal.dao.RolDAO;
import com.edu.ufps.examenfinal.dao.UsuarioDAO;
import com.edu.ufps.examenfinal.dto.Usuario;

/**
 * Servlet implementation class Usuario
 */
@WebServlet({ "/Usuario", "/Registro" })
public class UsuarioC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;
    public UsuarioC() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		usuarioDAO=new UsuarioDAO();
		rolDAO=new RolDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getServletPath();
		
		switch(path) {
		case "/Registro":
			
			break;
		
		}
		
		//Usuario usuario = 		
				
				
				//usuarioDAO.insert(null);
		
	}

	
	protected void mostrarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("roles", rolDAO.list());
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
