package com.niit.womenfashionBackend.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component

public class Orders {
	
	@Id
	private String ordId;
	private Double grandtotal;
	
	@OneToOne
	@JoinColumn(name="bilId")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="useId")
	private Users users;
	
	@OneToOne
	@JoinColumn(name="paId")
	private Pay pay;
	
	@OneToMany(mappedBy="orders")
	private List<OrderItems> orderItems;
	public String getOrdId() {
		return ordId;
	}
	public void setCatId(String ordId) {
		this.ordId = ordId;
	}
	public Double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(Double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}																																				

}
