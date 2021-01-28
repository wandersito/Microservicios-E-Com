package com.ecommerce.app.commons.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICommonService<T> {
	
	public Page<T> pageable(Pageable pageable);

	public Iterable<T> findAll() throws Exception;
	
	public T findById(Long id) throws Exception;
	
	public T save(T Entity);
	
	public void deleteByid(Long id);
	
}
