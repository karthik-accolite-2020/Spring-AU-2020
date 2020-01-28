package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadDataToDatabase {
	public static void load(Session session) {
		
		UserInfo u=new UserInfo();
		u.setName("Karthik");
		u.setUsername("Karthik123");
		u.setPassword("qwerty");
		u.setAge(22);
		Address ad=new Address();
		ad.setHouse_no(2);
		ad.setStreet_name("Vidyapeeta");
		ad.setCity_name("Banglore");
		u.setAddress(ad);
		List<Long> list=new ArrayList<Long>();
		list.add(new Long("8971313723"));
		list.add(new Long("9912530277"));
		u.setMobileNo(list);
		
		session.save(u);
		UserInfo u2=new UserInfo();
		u2.setName("Pranav");
		u2.setUsername("Pranav123");
		u2.setPassword("1234");
		u2.setAge(34);
		ad=new Address();
		ad.setHouse_no(10);
		ad.setStreet_name("Rajajinagar");
		ad.setCity_name("Mangalore");
		u2.setAddress(ad);
		list=new ArrayList<Long>();
		list.add(new Long("8362046402"));
		u2.setMobileNo(list);
		
		session.save(u2);
		
		Items i=new Items();
		i.setItemId(101);
		i.setItemName("Redmi note 8");
		i.setItemPrice(8599);
		i.setItemQty(160);
		i.setItemDesc("ABCD");
		
		session.save(i);
		
		Items i2=new Items();
		i2.setItemId(102);
		i2.setItemName("boAt headset");
		i2.setItemPrice(649);
		i2.setItemQty(320);
		i2.setItemDesc("XYZ");
		
		session.save(i2);
		
		session.getTransaction().commit();
	}
}
