package com.usbbog.tiendas.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientesEntities {
	
	private UUID id;
	private String names;
	private String lastNames;
	private String address;
	private Integer phone;
	private Boolean state;
	
	
	public ClientesEntities(UUID id, String names, String lastNames, String address, Integer phone, Boolean state) {
		super();
		this.id = id;
		this.names = names;
		this.lastNames = lastNames;
		this.address = address;
		this.phone = phone;
		this.state = state;
	}
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastNames() {
		return lastNames;
	}
	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	

}
