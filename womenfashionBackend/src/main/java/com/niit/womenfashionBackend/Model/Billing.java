
package com.niit.womenfashionBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component

public class Billing {
	
	@Id
	private String bilId;
	private String bilName;
	private String bilCity;
	private String bilState;
	private String bilPhoneNo;
	private String bilAddress;
	public Billing()
	{
		this.bilId="Billing"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getBilAddress() {
		return bilAddress;
	}
	public void setBilAddress(String bilAddress) {
		this.bilAddress = bilAddress;
	}
	@OneToOne
	@JoinColumn(name="usersId")
	private Users users;

	public String getBilCity() {
		return bilCity;
	}
	public void setBilCity(String bilCity) {
		this.bilCity = bilCity;
	}
	public String getBilState() {
		return bilState;
	}
	public void setBilState(String bilState) {
		this.bilState = bilState;
	}
	public String getBilPhoneNo() {
		return bilPhoneNo;
	}
	public void setBilPhoneNo(String bilPhoneNo) {
		this.bilPhoneNo = bilPhoneNo;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getBilId() {
		return bilId;
	}
	public void setBilId(String bilId) {
		this.bilId = bilId;
	}
	public String getBilName() {
		return bilName;
	}
	public void setBilName(String bilName) {
		this.bilName = bilName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
																																						

}
