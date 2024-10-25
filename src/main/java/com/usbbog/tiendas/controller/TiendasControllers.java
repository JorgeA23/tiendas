package com.usbbog.tiendas.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usbbog.tiendas.entities.TiendasEntities;
import com.usbbog.tiendas.services.TiendasServices;

@RestController
@RequestMapping("/tiendas")
public class TiendasControllers {
	
	private final TiendasServices tiendasServices;
	
	@Autowired
	public TiendasControllers(TiendasServices tiendasServices) {
		this.tiendasServices = tiendasServices;
	}
	
	@GetMapping("/{id}")
	public List<TiendasEntities> getAllProducts(@PathVariable Integer id){
		return tiendasServices.getAllByShop(id);
	}
	
	@GetMapping("/ides")
	public Optional<TiendasEntities> getProductById(@RequestBody Map<String, Object> data){
		return tiendasServices.getProductById(data);
	}
	
	@PostMapping("/new")
	public String createProducts(@RequestBody Map<String, Object> data){
		return tiendasServices.createProduct(data);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Map<String, Object> newItems){
		return tiendasServices.updateProduct(newItems);
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct(@RequestBody Map<String, Object> todelete){
		return tiendasServices.deleteProduct(todelete);
	}

}
