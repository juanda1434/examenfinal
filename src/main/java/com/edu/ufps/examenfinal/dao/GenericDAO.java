package com.edu.ufps.examenfinal.dao;

import java.util.*;

public interface GenericDAO<T> {
	
	public List<T> list();
	public <E> T find(E primary);
	public void insert(T obj);
	public void update(T obj);
	public void delete(T obj);	
}
