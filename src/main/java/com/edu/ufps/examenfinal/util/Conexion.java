package com.edu.ufps.examenfinal.util;


import java.util.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery; 

public abstract class Conexion <T> {
	private Class<T> c;
	private static EntityManager em = null;
	
	public Conexion() {
		em = Conexion.getEm();
	}
	
	public Conexion(Class<T> c) {
		em = Conexion.getEm();
		this.c = c;
	}
	
	public void setC(Class<T> c){
		this.c = c;
	}
	
	public static EntityManager getEm(){
		if ( em == null ) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenfinal");
            em = emf.createEntityManager();
        }
		return em;
	}
	
	public <E> T find(E primary){
		T object = (T) em.find(c, primary);
		return object;
	}
	
	public List<T> list(){
		TypedQuery<T> consulta= em.createNamedQuery(c.getSimpleName()+".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}
	
	public Class<T> getC(){
		return c;
	} 
	
	public void insert(T obj){
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
	
	public void update(T obj){
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
	
	public void delete(T id){
		try {
			em.getTransaction().begin();
			em.remove(id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
	public void deleteClearCache(T id){
		try {
			delete(id);
			em.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//em.close();
		}
		
	}
	
	 public Integer getMaxId() {
		 Integer maxId = (Integer) em.createNamedQuery(c.getSimpleName()+".getMaxID", c).getSingleResult();
		 return maxId + 1;
	 }

	 
	 
}