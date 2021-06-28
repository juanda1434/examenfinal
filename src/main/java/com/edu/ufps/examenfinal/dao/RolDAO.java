package com.edu.ufps.examenfinal.dao;

import java.util.List;

import com.edu.ufps.examenfinal.dto.Rol;
import com.edu.ufps.examenfinal.dto.Usuario;
import com.edu.ufps.examenfinal.util.Conexion;

public class RolDAO extends Conexion<Rol> implements GenericDAO<Rol>{

	
	public RolDAO() {
		super(Rol.class);
	}
	

}
