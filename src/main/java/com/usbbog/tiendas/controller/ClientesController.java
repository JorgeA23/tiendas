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

import com.usbbog.tiendas.entities.ClientesEntities;
import com.usbbog.tiendas.services.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	private final ClientesService clientesService;
	
	@Autowired
	public ClientesController(ClientesService clientesService) {
		this.clientesService = clientesService;
	}
	
	@GetMapping()
	public List<ClientesEntities> getAllProducts(){
		return clientesService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ClientesEntities> getProductById(@PathVariable UUID id){
		return clientesService.getClientById(id);
	}
	
	@PostMapping("/new")
	public String createProducts(@RequestBody Map<String, Object> data){
		return clientesService.createClient(data);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Map<String, Object> newItems){
		return clientesService.updateClient(newItems);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable UUID id){
		return clientesService.deleteClient(id);
	}

}
