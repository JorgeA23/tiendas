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

import com.usbbog.tiendas.entities.ProveedorEntities;
import com.usbbog.tiendas.services.PorveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
	
	private final PorveedorService porveedorService;
	
	@Autowired
	public ProveedorController(PorveedorService porveedorService) {
		this.porveedorService = porveedorService;
	}
	
	@GetMapping()
	public List<ProveedorEntities> getAllProveedores(){
		return porveedorService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ProveedorEntities> getProveedorById(@PathVariable UUID id){
		return porveedorService.getProveedorById(id);
	}
	
	@PostMapping("/new")
	public String createProveedor(@RequestBody Map<String, Object> data){
		return porveedorService.createProveedor(data);
	}
	
	@PutMapping("/update")
	public String updateProveedor(@RequestBody Map<String, Object> newItems){
		return porveedorService.updateProveedor(newItems);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProveedor(@PathVariable UUID id){
		return porveedorService.deleteProveedor(id);
	}

}
