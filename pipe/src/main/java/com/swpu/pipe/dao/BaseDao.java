package com.swpu.pipe.dao;

import java.io.Serializable;
import java.util.List;
import com.swpu.pipe.beans.PageBean;

/**
 * ����dao
 * @author advice
 * @param <E> ʵ����
 * @param <K> ʵ����ID
 */
public interface BaseDao<E,K extends Serializable> {

	public K save(E entity);
	
	public boolean delete(E entity);
	
	public boolean deleteById(K k);
	
	public boolean update(E entity);
	
	public K findById(K k);
	
	public List<E> findAll();
	
	public boolean add(E entity);
	
	public PageBean<E> findAll(int page, int size);
	
}
