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
public class ProveedorEntities {
	
	private UUID id;
	private String names;
	private String address;
	private String emailAddress;
	private Integer phone;
	private Boolean state;
	
	
	public ProveedorEntities(UUID id, String names, String address, String emailAddress, Integer phone, Boolean state) {
		super();
		this.id = id;
		this.names = names;
		this.address = address;
		this.emailAddress = emailAddress;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
