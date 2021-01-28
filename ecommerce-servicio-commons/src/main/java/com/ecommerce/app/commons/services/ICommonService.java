package com.ecommerce.app.commons.services;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICommonService<T> {

	public List<T> findAll() throws Exception;
	
	public T findById(Long id) throws Exception;
	
	public T save(T Entity);
	
	public void deleteByid(Long id);
	
	public Page<T> pageable(Integer pageNo, Integer pageSize, String sortBy);
	
}
