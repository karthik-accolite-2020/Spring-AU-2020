package com.main;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.Address;
import com.model.Items;
import com.model.LoadDataToDatabase;
import com.model.UserInfo;
import com.model.UserOrder;

import antlr.CppCodeGenerator;

public class MainClass {
	private static Scanner sc;
	private static HashMap<Integer,Items> items;
	private static void ShowAllItems(Session session, UserInfo u) {
		Query q=session.createQuery("from Items");
		List<Items> list=q.list();
		items=new HashMap<Integer, Items>();
		list.forEach((l)->{
			items.put(l.getItemId(),l);
			System.out.println("Item Id:"+l.getItemId()+
					"\tItem Name:"+l.getItemName()+
					"\nItem Description:"+l.getItemDesc()+
					"\nItem Price:Rs."+l.getItemPrice()+
					"\tAvailable Quantity:"+l.getItemQty()
					);
		});
	}
	private static void BuyAnItem(Session session, UserInfo u) {
		System.out.println("Enter id of the item u wanna buy..");
		int id=sc.nextInt();
		if(items.containsKey(id)) {
			Items i=items.get(id);
			i.setItemQty(i.getItemQty()-1);
			try {
				session.beginTransaction();
			}catch (Exception e) {
				// TODO: handle exception
			}
			UserOrder order=new UserOrder();
			order.setItems(i);
			order.setUserInfo(u);
			TypedQuery q=session.getNamedQuery("updateQty");
			q.setParameter("qty",i.getItemQty());
			q.setParameter("id",i.getItemId());
			int rowsAffected=q.executeUpdate();
			if(rowsAffected==1) {
				order.placeOrder(session);
			}
			else {
				System.out.println("Something went wrong..");
			}
		}
		else {
			System.out.println("No item with "+id+" exists in the database.");
		}
		
	}
	private static void ShowOrderHistory(Session session,UserInfo u) {
		Query q=session.createQuery("from UserInfo where Username='"+u.getUsername()+"'");
		UserInfo l=(UserInfo) q.list().get(0);
		Collection<Items> i= l.getPurchased();
		if(i.size()>0) {
			System.out.println("Here is your purchase history");
			i.forEach((item)->{
				System.out.println(item.getItemId()+" "+item.getItemName());
			});
		}
		else {
			System.out.println("You didn't buy any item");
		}
		
	}
	private static void ChangePassword(Session session, UserInfo u) {
		System.out.println("Type Current password");
		String currentPass=sc.next();
		System.out.println("Type New password");
		String newPass=sc.next();
		if(u.getPassword().equals(currentPass)) {
			u.setPassword(newPass);
			try {
				session.beginTransaction();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			session.update(u);
			session.getTransaction().commit();
			System.out.println("Password updated successfully.");
		}
		else {
			System.out.println("You entered wrong current password.");
		}
	}
	private static void ShowOptions(Session session, UserInfo u) {
		boolean loop=true;
		while(loop) {
			System.out.println("1:Buy an item"
					+ "\n2:Show all items"
					+ "\n3:Show order history"
					+"\n4:Change password");
			int option=sc.nextInt();
			switch(option) {
				case 1:
					ShowAllItems(session,u);
					BuyAnItem(session,u);
					break;
				case 2:
					ShowAllItems(session,u);
					break;
				case 3:
					ShowOrderHistory(session, u);
					break;
				case 4:
					ChangePassword(session, u);
					break;
				default:
					loop=false;
					break;
			}
		}
	}
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		LoadDataToDatabase.load(session);
		sc=new Scanner(System.in);
		System.out.println("--------------------------Welcome to OnlineShopping----------------------------");
		System.out.println("-------------------------------------------------------------------------------");
		
		System.out.println("Enter username:");
		String un="Karthik123";
		System.out.println("Enter password:");
		String pwd="qwerty";
		
		Query q=session.createQuery("from UserInfo where Username='"+un+"' and Password='"+pwd+"'");
		List<UserInfo> l=q.list();
		if(l.size()==1) {
			UserInfo u=l.get(0);
			System.out.println("Hi "+u.getName());
			ShowOptions(session,u);
		}
		else {
			System.out.println("Login not successful:(");
		}
		
		session.close();
	}
}
