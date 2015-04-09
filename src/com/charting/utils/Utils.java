package com.charting.utils;

import java.util.List;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.charting.data.Data;
import com.charting.data.Pair;
import com.charting.database.impl.DBConnectionImpl;
import com.charting.function.Function;

public class Utils {

    private static final Double MAX_VALUE = 100.0;

    public static Data generateRandomData(int size, String title, String xLabel, String yLabel) {
	Data data = new Data();
	data.setTitle(title);
	data.setxAxisLabel(xLabel);
	data.setyAxisLabel(yLabel);
	for (int i = 0; i < size; i++) {
	    data.add(MAX_VALUE * Math.random(), MAX_VALUE * Math.random());
	}
	return data;
    }

    public static Data generateSquareData(int size, String title, String xLabel, String yLabel) {
	Data data = new Data();
	data.setTitle(title);
	data.setxAxisLabel(xLabel);
	data.setyAxisLabel(yLabel);
	for (int i = 0; i < size; i++) {
	    double x = MAX_VALUE * Math.random();
	    data.add(x, x * x);
	}
	return data;
    }

    public static Data generateData(int size, String title, String xLabel, String yLabel, Function f) {
	Data data = new Data();
	data.setTitle(title);
	data.setxAxisLabel(xLabel);
	data.setyAxisLabel(yLabel);
	for (int i = 0; i < size; i++) {
	    double x = i;
	    data.add(x, f.getY(x));
	}
	return data;
    }

    public static XYDataset generateDataSet(List<Pair> pairs) {
	XYSeriesCollection dataset = new XYSeriesCollection();
	XYSeries series = new XYSeries("Object 1");
	for (Pair pair : pairs) {
	    series.add(pair.getX(), pair.getY());
	}
	dataset.addSeries(series);
	return dataset;
    }

    public static Data generateDataFromnDB(String dbUrl, String username, String password, String query, String[] columns, String title) {

	DBConnectionImpl.getInstanceof().initializeDB(dbUrl, username, password);
	List<Object[]> results = DBConnectionImpl.getInstanceof().getResults(query, columns);

	Data data = new Data();
	data.setTitle(title);
	data.setxAxisLabel(columns[0]);
	data.setyAxisLabel(columns[1]);
	for (Object[] result : results) {
	    Pair pair = new Pair();
	    pair.setX(Double.parseDouble(result[0].toString()));
	    pair.setY(Double.parseDouble(result[1].toString()));
	    data.add(pair);
	}
	return data;
    }
}
