package com.charting.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.charting.data.Data;
import com.charting.utils.Constant;
import com.charting.utils.QueryBuilder;
import com.charting.utils.Utils;

public class Window extends JFrame {

    private JPanel toolPanel;
    private JPanel chartPanel;

    private Window() {

	setLayout(new BorderLayout());

	final JTextField dbURLTextField = new JTextField(Constant.DB_URL);
	final JTextField tableNameTextField = new JTextField(Constant.TABLE_NAME);
	final JTextField xAxisTextField = new JTextField(Constant.X_AXIS);
	final JTextField yAxisTextField = new JTextField(Constant.Y_AXIS);

	JButton searchButton = new JButton(Constant.SEARCH);

	GridLayout gridLayout = new GridLayout(1, 3);

	toolPanel = new JPanel();

	toolPanel.setLayout(gridLayout);
	toolPanel.add(dbURLTextField);
	toolPanel.add(tableNameTextField);
	toolPanel.add(xAxisTextField);
	toolPanel.add(yAxisTextField);
	toolPanel.add(searchButton);

	add(toolPanel, BorderLayout.NORTH);

	searchButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		String dbURL = dbURLTextField.getText();
		String tableName = tableNameTextField.getText();
		String xAxis = xAxisTextField.getText();
		String yAxis = yAxisTextField.getText();

		try {
		    plot(Utils.generateDataFromnDB(dbURL, Constant.DATABASE_USER, Constant.DATABASE_PASSWORD, QueryBuilder.getBuilder().setTable(tableName).build(), new String[] { xAxis, yAxis }, yAxis + " vs " + xAxis));
		} catch (Exception ex) {
		    System.out.println(ex.getLocalizedMessage());
		}
	    }
	});

	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final Window window = new Window();

    public static Window generateWindow(int width, int height) {
	window.setSize(width, height);
	return window;
    }

    public void showWindow() {
	setVisible(true);
    }

    public void plot(Data data) {
	JFreeChart chart = ChartFactory.createXYLineChart(data.getTitle(), data.getxAxisLabel(), data.getyAxisLabel(), Utils.generateDataSet(data.getPairs()));
	chartPanel = new ChartPanel(chart);
	add(chartPanel, BorderLayout.CENTER);
	repaint();
	setVisible(true);
    }
}
