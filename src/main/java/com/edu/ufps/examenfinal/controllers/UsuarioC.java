package com.edu.ufps.examenfinal.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.ufps.examenfinal.dao.RolDAO;
import com.edu.ufps.examenfinal.dao.TypedbDAO;
import com.edu.ufps.examenfinal.dao.UsuarioDAO;
import com.edu.ufps.examenfinal.dto.Rol;
import com.edu.ufps.examenfinal.dto.Typedb;
import com.edu.ufps.examenfinal.dto.Usuario;
import com.edu.ufps.examenfinal.util.Mail;

/**
 * Servlet implementation class Usuario
 */
@WebServlet({ "/Usuario", "/Registro","/Registro/enviar","/validarRegistro","/validarRegistro/enviar","/login" ,"/login/enviar",
	"/registroTipo","/registroTipo/enviar"})
public class UsuarioC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;
	private TypedbDAO typedbDAO;
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
		typedbDAO=new TypedbDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path= request.getServletPath();
		
		switch(path) {
		case "/Registro":
			mostrarRegistro(request, response);
			break;
		case "/Registro/enviar":
			registrar(request, response);
			break;
		case"/validarRegistro":
			request.getRequestDispatcher("validarRegistro.jsp").forward(request, response);
			break;
		case"/validarRegistro/enviar":
			validarRegistro(request, response);
			break;
			
		case"/login":
			request.setAttribute("roles",rolDAO.list());
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case"/login/enviar":
			login(request, response);
			break;
		case "/registroTipo":
			if(request.getSession().getAttribute("usuario")==null && ((Usuario)request.getSession().getAttribute("usuario")).getRol().getId()!=1) {
				response.sendRedirect(request.getContextPath()+"/login");
				return;
			}
			request.getRequestDispatcher("registroTipo.jsp").forward(request, response);
			break;
			
		case "/registroTipo/enviar":
			registroTipo(request, response);
			
			break;
		}
		
		
	}

	
	protected void mostrarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);
		
	}
	
	protected void registroTipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario")==null && ((Usuario)request.getSession().getAttribute("usuario")).getRol().getId()!=1) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		try {
			String id=request.getParameter("id");
			String descripcion=request.getParameter("descripcion");
			String driver=request.getParameter("driver");
			String adicional=request.getParameter("adicional");
			
			Typedb tipo = new Typedb();
			tipo.setId(id);
			tipo.setDescription(descripcion);
			tipo.setDriver(driver);
			tipo.setAditional(adicional);
			
			typedbDAO.insert(tipo);
			response.sendRedirect(request.getContextPath()+"/registroTipo?registro=tipo registrado con exito");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/registroTipo?registro=error al registrar tipo");
		}
		
		
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		String email= request.getParameter("email");
		try {

			Usuario u = new Usuario();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			u.setEmail(email);
			Rol r = rolDAO.find(2);
			u.setRol(r);
			u.setState((short)0);
			usuarioDAO.insert(u);
			Mail m =new Mail();
			m.enviarEmail(email, "Registro exitoso sistema reportes", "Te has registrado de manera exitosa completa tu registro en http://localhost:8080"+request.getContextPath()+"/validarRegistro");
			response.sendRedirect(request.getContextPath()+"/Registro?registro=Se ha registrado verifique su correo electronico");
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath()+"/Registro?registro=error vuelve intentarlo");
		}
		
		
		
	}
	
	protected void validarRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		try {

			Usuario u = new Usuario();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			Usuario us=null;
			if((us=usuarioDAO.buscar(u))!=null) {
				us.setState((short)1);
				usuarioDAO.update(us);
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=Se ha validado");
			}else {
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=No se ha validado");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario= request.getParameter("usuario");
		String contrasenia= request.getParameter("contrasenia");
		Integer rol = Integer.parseInt(request.getParameter("rol"));
		try {

			Usuario u = new Usuario();
			u.setPass(contrasenia);
			u.setUsuario(usuario);
			Rol r = rolDAO.find(rol);
			r.setId(rol);
			u.setRol(r);
			Usuario us=null;
			if((us=usuarioDAO.log(u))!=null) {
				request.getSession().setAttribute("usuario", us);
				if(u.getRol().getId()==1) {
					response.sendRedirect(request.getContextPath()+"/registroTipo");
				}else {
					response.sendRedirect(request.getContextPath()+"/inicio");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/validarRegistro?validar=No se ha validado");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
