package com.API.DataDriven;

import org.testng.annotations.DataProvider;

public class DataProviders_Col {

	@DataProvider(name="DataForTest")
	public Object[][] dataProvider(){
		
//		Object[][] data = new Object[2][3];
//		
//		data[0][0] = "Akashi";
//		data[0][1] = "Seijuro";
//		data[0][2] = 2;
//	
//		data[1][0] = "Aomine";
//		data[1][1] = "Daiki";
//		data[1][2] = 1;
//		
//		return data;
		
		return new Object[][] {
			{"Hinata","Shoyo",1},
			{"Minato","Namikaze",2}
		};
	}

	@DataProvider(name="DataForDel")
	public Object[] dataForDeletion(){
		
		return new Object[] {
			1,7
		};
	}
	
}
