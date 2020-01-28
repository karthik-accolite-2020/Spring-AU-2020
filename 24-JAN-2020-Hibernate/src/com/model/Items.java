package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "updateQty",query = "UPDATE Items set ItemQty= :qty where ItemId=:id")	
})


@Entity
public class Items {
	@Id
	private int ItemId;
	private String ItemName;
	private int ItemQty;
	private double ItemPrice;
	private String ItemDesc;
	public Items() {
	}
	public Items(int itemId, String itemName, int itemQty, double itemPrice, String itemDesc) {
		super();
		ItemId = itemId;
		ItemName = itemName;
		ItemQty = itemQty;
		ItemPrice = itemPrice;
		ItemDesc = itemDesc;
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getItemQty() {
		return ItemQty;
	}
	public void setItemQty(int itemQty) {
		ItemQty = itemQty;
	}
	public double getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(double itemPrice) {
		ItemPrice = itemPrice;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	
}
