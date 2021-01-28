package com.ecommerce.app.clientes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.app.commons.models.cliente.Cliente;

public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

}
