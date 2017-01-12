package com.interview.arraysandstrings.matrixNull;

public class Location {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Location() {
		
	}
	
	public Location(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
}
