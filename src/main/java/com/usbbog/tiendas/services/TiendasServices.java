package com.usbbog.tiendas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.usbbog.tiendas.entities.TiendasEntities;

@Service
public class TiendasServices {
	
	private List<TiendasEntities> products1 = new ArrayList<>();  // Sexshop
	private List<TiendasEntities> products2 = new ArrayList<>();  // Maquillaje
	
	public TiendasServices() {
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Dildo", 15, 35000.0f, true));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Lubricante", 25, 15000.0f, true));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Lencería", 10, 45000.0f, true));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Vibrador", 8, 55000.0f, false));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Anillo vibrador", 12, 20000.0f, true));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Gel retardante", 20, 18000.0f, true));
		products1.add(new TiendasEntities(UUID.randomUUID(), "Sexshop", "Bolas chinas", 5, 40000.0f, false));
		
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Esmalte", 35, 10500.0f, true));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Labial", 50, 12000.0f, true));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Rímel", 30, 25000.0f, true));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Base líquida", 20, 40000.0f, false));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Sombras", 40, 18000.0f, true));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Corrector", 25, 15000.0f, true));
		products2.add(new TiendasEntities(UUID.randomUUID(), "Maquillaje", "Brochas", 10, 35000.0f, false));

	}
	
	public List<TiendasEntities> getAllByShop(Integer id){
		if(id == 1) {
			return products1;
		}else if(id == 2) {
			return products2;
		}else {
			return null;
		}
	}
	
	public Optional<TiendasEntities> getProductById(Map<String, Object> data){
		UUID productId = UUID.fromString(data.get("product").toString());
		if(Integer.parseInt(data.get("shop").toString()) == 1) {
			return products1.stream().filter(product -> product.getId().equals(productId)).findFirst();
		}else if(Integer.parseInt(data.get("shop").toString()) == 2) {
			return products2.stream().filter(product -> product.getId().equals(productId)).findFirst();
		}else {
			return null;
		}
	}
	
	public String createProduct(Map<String, Object> newProduct){
		TiendasEntities newP = new TiendasEntities(
				UUID.randomUUID(), 
				newProduct.get("shop").toString(),
				newProduct.get("name").toString(), 
				Integer.parseInt(newProduct.get("stock").toString()), 
				Float.parseFloat(newProduct.get("price").toString()), 
				Boolean.parseBoolean(newProduct.get("state").toString()));
		try {
			if(newProduct.get("shop").equals("Sexshop")) {
				products1.add(newP);
			}
			else if(newProduct.get("shop").equals("Maquillaje")) {
				products2.add(newP);
			}
			return "Producto Creado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al crear el producto: "+e.toString();
		}
	}
	
	public String updateProduct(Map<String, Object> newItems){
		UUID productId = UUID.fromString(newItems.get("product").toString());
		try {
			if(newItems.get("shop").equals("Sexshop")) {
				for (TiendasEntities producto : products1) {
			        if (producto.getId().equals(productId)) {
			        	producto.setTienda(newItems.get("shop").toString());
			        	producto.setProductName(newItems.get("name").toString());
			        	producto.setProductPrice(Float.parseFloat(newItems.get("price").toString()));
			        	producto.setProductState(Boolean.parseBoolean(newItems.get("state").toString()));
			        	producto.setProductStock(Integer.parseInt(newItems.get("stock").toString()));
			        	return "Producto Actualizado con Exito!!";
			        }
			    }
				return "No se encuentra ningún producto con el ID ingresado.";
			}
			else if(newItems.get("shop").equals("Maquillaje")) {
				for (TiendasEntities producto : products2) {
			        if (producto.getId().equals(productId)) {
			        	producto.setTienda(newItems.get("shop").toString());
			        	producto.setProductName(newItems.get("name").toString());
			        	producto.setProductPrice(Float.parseFloat(newItems.get("price").toString()));
			        	producto.setProductState(Boolean.parseBoolean(newItems.get("state").toString()));
			        	producto.setProductStock(Integer.parseInt(newItems.get("stock").toString()));
			        	return "Producto Actualizado con Exito!!";
			        }
			    }
				return "No se encuentra ningún producto con el ID ingresado.";
			}
			return "Producto Actualizado con Exito!!";
		}catch(Exception e){
			return "Ocurrió un error al actualizar el producto: "+e.toString();
		}
		
	}
	
	public String deleteProduct(Map<String, Object> toDelete){	
		UUID productId = UUID.fromString(toDelete.get("product").toString());
		try {
			if(toDelete.get("shop").equals("Sexshop")) {
				for (TiendasEntities producto : products1) {
			        if (producto.getId().equals(productId)) {
			        	products1.remove(producto);
			        	return "Producto Eliminado con Exito!!";
			        }
			    }
				return "No se encuentra ningún producto con el ID ingresado.";
			}
			else if(toDelete.get("shop").equals("Maquillaje")) {
				for (TiendasEntities producto : products2) {
			        if (producto.getId().equals(productId)) {
			        	products2.remove(producto);
			        	return "Producto Eliminado con Exito!!";
			        }
			    }
				return "No se encuentra ningún producto con el ID ingresado.";
			}
			return "No se encuentra ningún producto con el ID ingresado.";
		}catch(Exception e){
			return "Ocurrió un error al Eliminar el producto: "+e.toString();
		}
	}

}
