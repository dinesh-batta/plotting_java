package com.charting.line.impl;

import com.charting.line.Function;

public class Square implements Function{

	@Override
	public double getY(double x) {
		return x*x;
	}

}
