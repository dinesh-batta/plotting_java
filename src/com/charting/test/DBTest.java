package com.charting.test;

import java.util.List;

import com.charting.database.impl.DBConnectionImpl;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnectionImpl.getInstanceof().initializeDB("localhost/sandman_dev", "root", "");
		List<Object[]> results = DBConnectionImpl.getInstanceof().getResults("select gcs, active_clay from preparedsand where foundry_line_id = 6 limit 10",new String[]{"gcs","active_clay"});

		for(Object[] result:results){
			for(Object object:result){
				System.out.print(object+", ");
			}
			System.out.println();
		}
		
	}

}
