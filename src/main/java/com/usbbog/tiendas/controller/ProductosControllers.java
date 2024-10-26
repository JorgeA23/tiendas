package com.usbbog.tiendas.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbbog.tiendas.entities.ProductosEntities;
import com.usbbog.tiendas.services.ProductosServices;

@RestController
@RequestMapping("/products")
public class ProductosControllers {
	
	private final ProductosServices tiendasServices;
	
	@Autowired
	public ProductosControllers(ProductosServices tiendasServices) {
		this.tiendasServices = tiendasServices;
	}
	
	@GetMapping()
	public List<ProductosEntities> getAllProducts(){
		return tiendasServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ProductosEntities> getProductById(@PathVariable UUID id){
		return tiendasServices.getProductById(id);
	}
	
	@PostMapping("/new")
	public String createProducts(@RequestBody Map<String, Object> data){
		return tiendasServices.createProduct(data);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Map<String, Object> newItems){
		return tiendasServices.updateProduct(newItems);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable UUID id){
		return tiendasServices.deleteProduct(id);
	}

}
