
package com.niit.womenfashionBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component

public class Users {
	
	@Id
	private String useId;
	private String useName;
	private String useAddress;
	private String usePhoneNo;
	private String useEmailId;
	private String usePassword;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bilId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="authId")
	Authentication authentication;
	
	
	
	
	
	public Users() {
		this.useId = "USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	public String getUseAddress() {
		return useAddress;
	}
	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}
	public String getUsePhoneNo() {
		return usePhoneNo;
	}
	public void setUsePhoneNo(String usePhoneNo) {
		this.usePhoneNo = usePhoneNo;
	}
	public String getUseEmailId() {
		return useEmailId;
	}
	public void setUseEmailId(String useEmailId) {
		this.useEmailId = useEmailId;
	}
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="carId")
	private Cart cart;
	
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
																																						

}
