package com.edu.ufps.examenfinal.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.edu.ufps.examenfinal.dto.Usuario;
import com.edu.ufps.examenfinal.util.Conexion;



public class UsuarioDAO extends Conexion<Usuario> implements GenericDAO<Usuario>{
	
	public UsuarioDAO() {
		super(Usuario.class);
	}

	
		public Boolean logear(Usuario usuario) {
			/*Boolean isLog=true;
			Query query = null;
			if(usuario.getAdministradors()!=null) {
				query= getEm().createNamedQuery(Usuario.class.getSimpleName()+".logAdmin",Usuario.class);
			}else if(usuario.getAdoptante()!=null) {
				query= getEm().createNamedQuery(Usuario.class.getSimpleName()+".logAdoptante",Usuario.class);
			}else if(usuario.getHogarDePaso()!=null) {
				query= getEm().createNamedQuery(Usuario.class.getSimpleName()+".logHogar",Usuario.class);
			}
			
			try {
				query.setParameter("usuario", usuario.getUsuario());
				query.setParameter("contrasenia", usuario.getContraseña());
				query.getSingleResult();
			} catch (NoResultException e) {
				isLog=false;
			}
			
			return isLog;*/
			return false;
		}

}