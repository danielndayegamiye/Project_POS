package POS_DM;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import POS_PD.*;

public class StoreDM {
	public static void loadData(Store store)
	{
		String fileName ="C:\\Mine\\Classes\\FALL 2022\\CMSC 2133\\Projects\\Project_2_POS\\src\\POS_DM\\StoreData_v2022.csv";
		String line = null;
		String[] result;
		result = "Seriously, Daniel".split(",");

		String dataType; 
		Session session1 = new Session();
		Sale sale1 = new Sale();
		
	    try 
	    {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	result = line.split(","); 
	        	
	    		
	        	dataType = result[0];
	        	
	        	
	        	if(dataType.equals("Store")) 
	        	{
	        		store.setName(result[1]);
		        	//System.out.println("Here");
	        	}
	        	else if(dataType.equals("TaxCategory"))
	        	{
	        		TaxCategory tax1 =  new TaxCategory(result[1]);
	        		new TaxRate(tax1, LocalDate.parse(result[3],DateTimeFormatter.ofPattern("M/d/yy")), new BigDecimal(result[2]));
	        		store.addTaxCategory(tax1);
	        	}
	        	else if (dataType.equals ("Cashier"))
	        	{
	        		Person p = new Person(result[2],result[4],result[5], result[6], result[7], result[8], result[3]);
	        		new Cashier(store, result[1],p,result[9]);
	        	}
	        	else if (dataType.equals( "Item"))
	        	{
	        		Item item = new Item(store, result[1], result[3]);
	        		new UPC(item, store, result[2]);
	        		item.setTaxCategory(store.findTaxCategorybyName(result[4]));
	        		new Price(item, result[5], result[6]);
	        		if(result.length > 7)
	        		{
	        			new PromoPrice(item, result[7], result[8], result[9]);
	        		}	        		
	        		
	        	}
	        	else if (dataType.equals("Register"))
	        	{
	        		new Register (store,result[1]);
	        	}
	        	else if (dataType.equals("Session"))
	        	{
	        		session1 = new Session (store.findCashierForNumber(result[1]), store.findRegisterbyNumber(result[2]));
	        		store.addSession(session1);
	        	}
	        	else if (dataType.equals("Sale"))
	        	{
	        		sale1 = new Sale(result[1]);
	        		session1.addSale(sale1);
	        		
	        	}
	        	else if (dataType.equals("SaleLineItem"))
	        	{
	        		new SaleLineItem(sale1,store.getItems().get(result[1]), result[2]);
	        	}
	        	else if (dataType.equals("Payment"))
	        	{
	        		if(result[1].equals("Cash"))
	        		{
	        			sale1.addPayment(new Cash(result[2],new BigDecimal(result[3])));
	        		}
	        		else if (result[1].equals("Credit"))
	        		{
	        			sale1.addPayment(new Credit(result[2], result [3], result[4], result[5], result[6]));
	        		}
	        		else if (result[1].equals("Check"))
	        		{
	        			sale1.addPayment(new Check(result[2], result [3], result[4], result[5], result[6]));

	        		}

	        	}
	     


	        }    
	      // Always close files.
	      bufferedReader.close();            
	    }
	    
	    catch(FileNotFoundException ex) 
	    {
	      System.out.println( "Unable to open file '" +  fileName + "'");                
	    }
	    catch(IOException ex) 
	    {
	       System.out.println (  "Error reading file '" + fileName + "'");   	
	    }
	}


}

