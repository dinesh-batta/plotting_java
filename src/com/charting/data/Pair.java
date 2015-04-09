package com.charting.data;

public class Pair implements Comparable<Pair>{
	private Double x;
	private Double y;
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	@Override
	public int compareTo(Pair other) {
		return ((x<other.getX()?-1:(x>other.getX()?1:(y<other.getY()?-1:y>other.getY()?1:0))));
	}
	
}
