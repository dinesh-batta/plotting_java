package com.charting.database;

import java.util.List;

public interface DBConnection {
	public Object[] getResult(String query,String[] columnNames);

	public List<Object[]> getResults(String query,String[] columnNames);
}
