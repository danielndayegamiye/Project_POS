package POS_UI;

import POS_PD.*;
import POS_TEST.StoreTest;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store1 = new Store();
		store1.openStore();
		
		POSFrame.open(store1);
	
		//System.out.println(store1);

//		 StoreTest test1 = new StoreTest();
//
//		test1.AC_1(store1);
//		test1.AC_2(store1);
//		test1.AC_3(store1);
//		test1.AC_4(store1);

	}

}
