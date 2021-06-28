package com.edu.ufps.examenfinal.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.edu.ufps.examenfinal.dto.Typedb;
import com.edu.ufps.examenfinal.dto.Usuario;
import com.edu.ufps.examenfinal.util.Conexion;



public class TypedbDAO extends Conexion<Typedb> implements GenericDAO<Typedb>{
	
	public TypedbDAO() {
		super(Typedb.class);
	}


}