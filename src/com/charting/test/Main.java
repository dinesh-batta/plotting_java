package com.charting.test;

import com.charting.line.Function;
import com.charting.ui.Window;
import com.charting.utils.Utils;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Window.generateWindow(500,200).plot(Utils.generateRandomData(100,"title","x label","y label"));

		String[] columns=new String[]{"active_clay","gcs"};
		Window.generateWindow(1000, 500).plot(
				Utils.generateDataFromnDB("localhost/sandman_dev", "root", "","select * from preparedsand where foundry_line_id = 6 limit 10000",columns, columns[1]+" vs "+columns[0]));

//				Window.generateWindow(1000, 1000).plot(
//						Utils.generateData(10000, "title", "x label", "y label",
//								new Function() {
//									@Override
//									public double getY(double x) {
//										return Math.sin(x);
//									}
//								}));
	}

}
