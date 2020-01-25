package com.assignment.model;

import org.springframework.beans.factory.annotation.Value;

public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	@Value("${p1.x}")
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	@Value("${p1.y}")
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println("X="+x+"\tY="+y);
		
	}
	
}
