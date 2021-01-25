package com.ecommerce.app.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.app.productos.entity.Producto;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>, JpaRepository<Producto, Long>{

}
