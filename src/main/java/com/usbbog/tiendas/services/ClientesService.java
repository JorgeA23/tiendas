package com.usbbog.tiendas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usbbog.tiendas.entities.ClientesEntities;

@Service
public class ClientesService {
	
	private List<ClientesEntities> clientes1 = new ArrayList<>();  
	
	public ClientesService() {
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Juan Alonso", "Lizarazo", "Calle 1234 -35",3154878, true));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Ana María", "González", "Avenida 45 - 12", 3167890, true));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Carlos Eduardo", "Pérez", "Calle 67 - 23", 3184523, false));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Luisa Fernanda", "Ramírez", "Carrera 10 - 56", 3157890, true));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Miguel Ángel", "Rodríguez", "Avenida 98 - 76", 3198765, false));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Paula Andrea", "Moreno", "Carrera 23 - 45", 3145678, true));
		clientes1.add(new ClientesEntities(UUID.randomUUID(), "Felipe Antonio", "García", "Calle 32 - 12", 3123456, false));
	}
	
	//Metodo para traer todos los productos existentes
	public List<ClientesEntities> getAll(){
		return clientes1;
	}
	
	//Metodo para traer un solo producto por su id
	public Optional<ClientesEntities> getClientById(UUID id){
		return clientes1.stream().filter(product -> product.getId().equals(id)).findFirst();
	}
	
	// Metodo para la creacion de los productos
	public String createClient(Map<String, Object> newClient){
		try {
			ClientesEntities newP = new ClientesEntities(
					UUID.randomUUID(), 
					newClient.get("names").toString(),
					newClient.get("lastNames").toString(),
					newClient.get("address").toString(),
					Integer.parseInt(newClient.get("phone").toString()),
					Boolean.parseBoolean(newClient.get("state").toString()));
			clientes1.add(newP);
			return "Cliente Creado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al crear el cliente: "+e.toString();
		}
	}
	
	// Metodo para la actualizacion de los clientes por id 
	public String updateClient(Map<String, Object> newItems){
		try {				
			for (ClientesEntities client : clientes1) {
		        if (client.getId().equals(UUID.fromString(newItems.get("id").toString()))) {
		        	client.setNames(newItems.get("names").toString());
		        	client.setLastNames(newItems.get("lastNames").toString());
		        	client.setAddress(newItems.get("address").toString());
		        	client.setPhone(Integer.parseInt(newItems.get("phone").toString()));
		        	client.setState(Boolean.parseBoolean(newItems.get("state").toString()));
		        	return "Producto Actualizado con Exito!!";
		        }
		    }
			return "No se encuentra ningún cliente con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Actualizar el cliente: "+e.toString();
		}
		
	}
	
	//Metodo para eliminar cliente por id
	public String deleteClient(UUID id){	
		
		try {
			for (ClientesEntities client : clientes1) {
		        if (client.getId().equals(id)) {
		        	clientes1.remove(client);
		        	return "Cliente Eliminado con Exito!!";
		        }
		    }
			return "No se encuentra ningún cliente con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Eliminar el cliente: "+e.toString();
		}
		
	}

}
