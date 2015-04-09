package com.charting.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Data {

	private String title;
	private String xAxisLabel;
	private String yAxisLabel;
	
	private List<Pair> pairs = new ArrayList<>();

	public void add(double x, double y) {
		Pair pair = new Pair();
		pair.setX(x);
		pair.setY(y);
		add(pair);
	}

	public void add(Pair pair) {
		pairs.add(pair);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getxAxisLabel() {
		return xAxisLabel;
	}

	public void setxAxisLabel(String xAxisLabel) {
		this.xAxisLabel = xAxisLabel;
	}

	public String getyAxisLabel() {
		return yAxisLabel;
	}

	public void setyAxisLabel(String yAxisLabel) {
		this.yAxisLabel = yAxisLabel;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
	
	public Data sort(){
		Collections.sort(pairs);
		return this;
	}
}
