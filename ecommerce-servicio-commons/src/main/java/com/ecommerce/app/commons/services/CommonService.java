package com.ecommerce.app.commons.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonService<T, R extends JpaRepository<T, Long>> implements ICommonService<T> {
	
	Logger log = LoggerFactory.getLogger(CommonService.class);
	
	@Autowired
	protected R repository;

	@Override
	@Transactional(readOnly=true)
	public List<T> read() throws Exception {
		try {
		return repository.findAll();
		} catch( Exception e) {
			throw new Exception("Entidades no encontradas");
		}
	}

	@Override
	@Transactional(readOnly=true)
	public T readOnlyOne(Long id) throws Exception {
		try {
			return repository.findById(id).orElse(null);
		} catch( Exception e) {
			throw new Exception("Entidad no encontrada");
		}

	}

	@Override
	@Transactional
	public T create(T Entity) {
		return repository.save(Entity);
	}

	@Override
	@Transactional
	public T update(T Entity, Long id) throws Exception {
	
		try {
			T EntityBD = repository.findById(id).orElseThrow();
			if(EntityBD != null) {
//				Entity.setId(id);
				return repository.save(Entity);
			}else{
				throw new Exception("No se pudo encontrar informacion de la entidad");
			}
		}catch(Exception e) {
			throw new Exception("Error al actualizar la entidad");
		}
		
	}

	@Override
	@Transactional
	public void deleteByid(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<T> pageable(Integer pageNo, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}



}
