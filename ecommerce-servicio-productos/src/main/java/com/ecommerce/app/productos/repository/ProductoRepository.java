package com.ecommerce.app.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecommerce.app.commons.models.productos.Producto;


public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>, JpaRepository<Producto, Long>{

}
