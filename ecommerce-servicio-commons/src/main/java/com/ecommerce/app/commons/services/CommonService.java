package com.ecommerce.app.commons.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonService<T, R extends PagingAndSortingRepository<T, Long>> implements ICommonService<T> {
	
	Logger log = LoggerFactory.getLogger(CommonService.class);
	
	@Autowired
	protected R repository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<T> findAll() throws Exception {
		try {
		return repository.findAll();
		} catch( Exception e) {
			throw new Exception("Entidades no encontradas");
		}
	}

	@Override
	@Transactional(readOnly=true)
	public T findById(Long id) throws Exception {
		try {
			return repository.findById(id).orElse(null);
		} catch( Exception e) {
			throw new Exception("Entidad no encontrada");
		}

	}

	@Override
	@Transactional
	public T save(T Entity) {
		return repository.save(Entity);
	}

	@Override
	@Transactional
	public void deleteByid(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<T> pageable(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
