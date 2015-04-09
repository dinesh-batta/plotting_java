package com.charting.function.impl;

import com.charting.function.Function;

public class Square implements Function{

	@Override
	public double getY(double x) {
		return x*x;
	}

}
