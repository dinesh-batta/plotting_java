package com.charting.test;

import com.charting.ui.Window;
import com.charting.utils.Constant;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// Window.generateWindow(500,200).plot(Utils.generateRandomData(100,"title","x label","y label"));

	String[] columns = new String[] { Constant.TRADEPLUS_X, Constant.TRADEPLUS_Y };

	Window.generateWindow(1000, 500).showWindow();// .plot();

	// Window.generateWindow(1000, 1000).plot(
	// Utils.generateData(10000, "title", "x label", "y label",
	// new Function() {
	// @Override
	// public double getY(double x) {
	// return Math.sin(x);
	// }
	// }));
    }

}
