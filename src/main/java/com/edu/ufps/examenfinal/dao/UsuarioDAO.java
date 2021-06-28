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

	public Usuario buscar(Usuario usuario ) {
		Usuario logeado=null;
		Query query = null;
		query= getEm().createNamedQuery(Usuario.class.getSimpleName()+".log",Usuario.class);
		
		try {
			query.setParameter("usuario", usuario.getUsuario());
			query.setParameter("pass", usuario.getPass());
			logeado=(Usuario)query.getSingleResult();
		} catch (NoResultException e) {
			
		}
		
		return logeado;
	}
		
	public Usuario log(Usuario usuario ) {
		Usuario logeado=null;
		Query query = null;
		query= getEm().createNamedQuery(Usuario.class.getSimpleName()+".login",Usuario.class);
		
		try {
			query.setParameter("usuario", usuario.getUsuario());
			query.setParameter("pass", usuario.getPass());
			query.setParameter("rol", usuario.getRol().getId());
			logeado=(Usuario)query.getSingleResult();
		} catch (NoResultException e) {
			
		}
		
		return logeado;
	}
	

}