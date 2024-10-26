package com.usbbog.tiendas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usbbog.tiendas.entities.ProveedorEntities;

@Service
public class PorveedorService {
	
	private List<ProveedorEntities> proveedor = new ArrayList<>();  
	
	public PorveedorService() {
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Elkosto", "Calle 68a -87", "3lkosto@mimail.com",3154878, true));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Supermercado Central", "Avenida 50 - 10", "supercentral@mimail.com", 3187890, true));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Distribuciones López", "Calle 99 - 34", "dlopez@mimail.com", 3194523, false));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Almacenes Primavera", "Carrera 25 - 56", "primavera@mimail.com", 3177890, true));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Comercializadora Norte", "Avenida 77 - 12", "cnorte@mimail.com", 3148765, true));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Productos del Sur", "Calle 12 - 45", "psur@mimail.com", 3125678, false));
		proveedor.add(new ProveedorEntities(UUID.randomUUID(), "Distribuidora Mar y Tierra", "Carrera 30 - 22", "mtyt@mimail.com", 3152345, true));

	}
	
	//Metodo para traer todos los proveedores existentes
	public List<ProveedorEntities> getAll(){
		return proveedor;
	}
	
	//Metodo para traer un solo proveedor por su id
	public Optional<ProveedorEntities> getProveedorById(UUID id){
		return proveedor.stream().filter(product -> product.getId().equals(id)).findFirst();
	}
	
	// Metodo para la creacion de los productos
	public String createProveedor(Map<String, Object> newProveedor){
		try {
			ProveedorEntities newP = new ProveedorEntities(
					UUID.randomUUID(), 
					newProveedor.get("name").toString(),
					newProveedor.get("address").toString(),
					newProveedor.get("email").toString(),
					Integer.parseInt(newProveedor.get("phone").toString()),
					Boolean.parseBoolean(newProveedor.get("state").toString()));
			proveedor.add(newP);
			return "Proveedor Creado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al crear el proveedor: "+e.toString();
		}
	}
	
	// Metodo para la actualizacion de los clientes por id 
	public String updateProveedor(Map<String, Object> newItems){
		try {				
			for (ProveedorEntities prove : proveedor) {
		        if (prove.getId().equals(UUID.fromString(newItems.get("id").toString()))) {
		        	prove.setNames(newItems.get("name").toString());
		        	prove.setAddress(newItems.get("address").toString());
		        	prove.setEmailAddress(newItems.get("email").toString());
		        	prove.setPhone(Integer.parseInt(newItems.get("phone").toString()));
		        	prove.setState(Boolean.parseBoolean(newItems.get("state").toString()));
		        	return "Proveedor Actualizado con Exito!!";
		        }
		    }
			return "No se encuentra ningún Proveedor con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Actualizar el proveedor: "+e.toString();
		}
		
	}
	
	//Metodo para eliminar cliente por id
	public String deleteProveedor(UUID id){	
		
		try {
			for (ProveedorEntities prove : proveedor) {
		        if (prove.getId().equals(id)) {
		        	proveedor.remove(prove);
		        	return "Proveedor Eliminado con Exito!!";
		        }
		    }
			return "No se encuentra ningún proveedor con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Eliminar el proveedor: "+e.toString();
		}
		
	}

}
