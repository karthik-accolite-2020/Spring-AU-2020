package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

//@NamedQueries({
//	@NamedQuery(name = "updateUserList",query = "")
//})

@Entity
public class UserInfo {
	@Id
	private String Username;
	private String Password;
	private String Name;
	private int Age;
	@Embedded
	private Address Address;
	@ElementCollection
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name="MobileNoId") }, generator = "sequence_gen", type = @Type(type = "long"))
	private Collection<Long> MobileNo=new ArrayList<Long>();
	/*
	 * @ManyToMany
	 * 
	 * @JoinTable()
	 */
	@ManyToMany
	private Collection<Items> Purchased=new ArrayList<Items>();
	
	public Collection<Items> getPurchased() {
		return Purchased;
	}
	public void setPurchased(List<Items> purchased) {
		Purchased = purchased;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	public Collection<Long> getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(List<Long> mobileNo) {
		MobileNo = mobileNo;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	
	
}
