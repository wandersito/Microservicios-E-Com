package com.ecommerce.app.commons.services;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICommonService<T> {

	public List<T> read() throws Exception;
	
	public T readOnlyOne(Long id) throws Exception;
	
	public T create(T Entity);
	
	public T update(T Entity, Long id) throws Exception;
	
	public void deleteByid(Long id);
	
	public Page<T> pageable(Integer pageNo, Integer pageSize, String sortBy);
	
}
