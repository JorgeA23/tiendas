package com.usbbog.tiendas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usbbog.tiendas.entities.ProductosEntities;

@Service
public class ProductosServices {
	
	private List<ProductosEntities> products1 = new ArrayList<>();
	
	public ProductosServices() {
		products1.add(new ProductosEntities(UUID.randomUUID(), "Esmalte", 35, 10500.0f, true));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Labial", 50, 12000.0f, true));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Rímel", 30, 25000.0f, true));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Base líquida", 20, 40000.0f, false));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Sombras", 40, 18000.0f, true));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Corrector", 25, 15000.0f, true));
		products1.add(new ProductosEntities(UUID.randomUUID(), "Brochas", 10, 35000.0f, false));

	}
	
	//Metodo para traer todos los productos existentes
	public List<ProductosEntities> getAll(){
		return products1;
	}
	
	//Metodo para traer un solo producto por su id
	public Optional<ProductosEntities> getProductById(UUID id){
		return products1.stream().filter(product -> product.getId().equals(id)).findFirst();
	}
	
	// Metodo para la creacion de los productos
	public String createProduct(Map<String, Object> newProduct){
		try {
			ProductosEntities newP = new ProductosEntities(
					UUID.randomUUID(), 
					newProduct.get("name").toString(), 
					Integer.parseInt(newProduct.get("stock").toString()), 
					Float.parseFloat(newProduct.get("price").toString()), 
					Boolean.parseBoolean(newProduct.get("state").toString()));
			products1.add(newP);
			return "Producto Creado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al crear el producto: "+e.toString();
		}
	}
	
	// Metodo para la actualizacion de los productos 
	public String updateProduct(Map<String, Object> newItems){
		try {
			for (ProductosEntities producto : products1) {
		        if (producto.getId().equals(UUID.fromString(newItems.get("id").toString()))) {
		        	producto.setProductName(newItems.get("name").toString());
		        	producto.setProductPrice(Float.parseFloat(newItems.get("price").toString()));
		        	producto.setProductState(Boolean.parseBoolean(newItems.get("state").toString()));
		        	producto.setProductStock(Integer.parseInt(newItems.get("stock").toString()));
		        	return "Producto Actualizado con Exito!!";
		        }
		    }
			return "No se encuentra ningún producto con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Actualizar el producto: "+e.toString();
		}
		
	}
	
	//Metodo para eliminar productos por id
	public String deleteProduct(UUID id){	
		
		try {
			for (ProductosEntities producto : products1) {
		        if (producto.getId().equals(id)) {
		        	products1.remove(producto);
		        	return "Producto Eliminado con Exito!!";
		        }
		    }
			return "No se encuentra ningún producto con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Eliminar el producto: "+e.toString();
		}
		
	}

}
