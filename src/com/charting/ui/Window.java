package com.charting.ui;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.charting.data.Data;
import com.charting.utils.Utils;

public class Window extends JFrame {

	private JPanel panel;

	private Window(){
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static final Window window=new Window();
	
	public static Window generateWindow(int width,int height){
		window.setSize(width, height);
		return window;
	}
	
	public void plot(Data data){
		JFreeChart chart=ChartFactory.createXYLineChart(data.getTitle(), data.getxAxisLabel(), data.getyAxisLabel(), Utils.generateDataSet(data.getPairs()));
		panel=new ChartPanel(chart);
		add(panel);
		repaint();
		setVisible(true);
	}
}
