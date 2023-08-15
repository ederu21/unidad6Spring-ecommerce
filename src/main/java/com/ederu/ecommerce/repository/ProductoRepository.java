package com.ederu.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ederu.ecommerce.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
