/**
 * 
 */
package POS_TEST;

import java.math.BigDecimal;
import java.time.LocalDate;

import POS_PD.*;

/**
 * @author daniel Ndayegamiye
 * 
 */
public class StoreTest {

	public void AC_1(Store store) {
		Item item1= new Item(store, "1001", "Turkey Sandwich" );
		Item item2 = new Item(store, "1002", "Ham Sandwich");
		Item item3 = new Item(store, "1003", "Coke");
		
		TaxCategory tax1 =  new TaxCategory("Food");
		TaxCategory tax2 =  new TaxCategory("Beverage");
		item1.setTaxCategory(tax1);
		item2.setTaxCategory(tax1);
		item3.setTaxCategory(tax2);
		
		new Price(item1, "2.59", "5/14/21");
		
		new Price(item1, "3.59", "7/14/21");
		

		
		new Price(item2, "2.59", "10/26/21");
		
		new Price(item3, "0.97", "5/8/21");
		
        new UPC(item1,store, "11111111111");
		
        new UPC(item2,store, "22222222222");
		
        new UPC(item3,store, "33333333333");
        
        System.out.println("***************\nAC 1.1\n***************\n");
        
        for(Item i:store.getItems().values())
        {
        	System.out.println(i);
        }
        

	}
	public void AC_2(Store store)
	{
		new Cashier(store, "1", new Person("David", "100 24th Street", "Edmond","OK", "73034", "405.348.1111", "111-11-1111"), "Queen3456");
		new Cashier(store, "2", new Person("Sally", "20405 2nd Street", "Edmond","OK", "73034", "405.348.2222", "222-22-2222"), "King1234");
		new Cashier(store, "3", new Person("Daniel", "3098 27th Street", "Edmond","OK", "73034", "405.348.3333", "333-33-3333"), "CMSC1222");
		
        System.out.println("***************\nAC 1.2\n***************\n");
        
        for(Cashier cashier:store.getCashiers().values())
        {
        	System.out.println(cashier);
        }
		
	}
	public void AC_3(Store store)
	{
		new Register(store,"1");
		new Register(store,"2");
		
        System.out.println("***************\nAC 1.3\n***************\n");

		for(Register r:store.getRegisters().values()) {
			System.out.println(r);
		}
		
	}
	public void AC_4(Store store)
	{
		// Creating the cashier, register and the session for the sale
		Cashier cashier1 = store.getCashiers().get("3");
		Register register1 = store.getRegisters().get("1");
		Session session1 = new Session(cashier1,register1);
		store.addSession(session1);
		
		// Creating tax Rates and assigning them to tax categories
		new TaxRate(store.getItems().get("1001").getTaxCategory(), LocalDate.of(2021, 12, 2),new BigDecimal(0.25) );
		new TaxRate(store.getItems().get("1003").getTaxCategory(), LocalDate.of(2021, 12, 2),new BigDecimal(0.75) );
		//new TaxRate(store.getItems().get("1003").getTaxCategory(), LocalDate.of(2021, 12, 22),new BigDecimal(1.5) );


		Sale sale1 = new Sale("N");
		session1.addSale(sale1);


		SaleLineItem sli1 = new SaleLineItem(sale1, store.getItems().get("1001"), "1");
		SaleLineItem sli2 = new SaleLineItem(sale1, store.getItems().get("1003"), "2");

        session1.calcTotal();
		System.out.println("***************\nAC 1.4\n***************\n");
		
        
        System.out.println(session1);



	}
}
