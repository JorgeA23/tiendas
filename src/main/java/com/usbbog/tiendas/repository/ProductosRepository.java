package com.usbbog.tiendas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usbbog.tiendas.entities.ProductosEntities;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntities, UUID>{

}
