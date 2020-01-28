package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

@Entity
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int OrderId;
	@ManyToOne
	@JoinColumn(name="Username")
	private UserInfo userInfo;
	@ManyToOne
	@JoinColumn(name="ItemId")
	private Items items;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public void placeOrder(Session session) {
		session.save(this);
		userInfo.getPurchased().add(items);
		session.update(userInfo);
		session.getTransaction().commit();
		System.out.println("Your order is placed:Order details are");
		System.out.println("Order-Id="+OrderId+
				"\nUserName="+userInfo.getName()+
				"\tItem Name="+items.getItemName());		
	}
}
