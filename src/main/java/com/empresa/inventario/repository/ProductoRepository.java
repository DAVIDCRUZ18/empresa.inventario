package com.empresa.inventario.repository;

import com.empresa.inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz para operaciones CRUD sobre la entidad Producto.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}