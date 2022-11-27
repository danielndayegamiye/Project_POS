package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * This represents the item sold in the store
 */
public class Item {

	/**
	 * This represents the number of an item
	 */
	private String number;
	/**
	 * This represents the description of an item
	 */
	private String description;
	/**
	 * This represents the category of tax for the item
	 */
	private TaxCategory taxCategory;
	/**
	 * This represents the UPC of an item
	 */
	private TreeMap<String, UPC> UPCs;
	/**
	 * This represents the sale line item
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * This represents the price of an item
	 */
	private TreeSet<Price> prices;

	/**
	 * This is a default constructor
	 */
	public Item() {
		this.number = "0";
		this.description = null;
		this.taxCategory = new TaxCategory();
		this.UPCs = new TreeMap<String,UPC>();
		this.prices =  new TreeSet<Price>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
		// TODO - implement Item.Item
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param number
	 * @param description
	 */
	public Item(Store store, String number, String description) {
		this();
		this.number=number;
		this.description=description;
		store.addItem(this);
		// TODO - implement Item.Item
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds a price to an item
	 * @param price
	 */
	public void addPrice(Price price) {
		prices.add(price);
		// TODO - implement Item.addPrice
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes the price of an item
	 * @param price
	 */
	public void removePrice(Price price) {
		this.prices.remove(price);
		// TODO - implement Item.removePrice
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds UPC for an item
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		this.UPCs.put(upc.getUPC(), upc);
		// TODO - implement Item.addUPC
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes UPC for an item
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		this.UPCs.remove(upc.getUPC());
		// TODO - implement Item.removeUPC
		//throw new UnsupportedOperationException();
	}

	/**
	 * This gets the price depending on the date
	 * @param date
	 */
	public Price getPriceForDate(LocalDate date) {
		Price price = new Price();
		for (Price p:this.prices)
		{
			if(p.isEffective(date))
			{
				price = p;
			}
		}
		return price;
		// TODO - implement Item.getPriceForDate
		//throw new UnsupportedOperationException();
	}

	/**
	 * This gets the tax rate depending on the date
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		return this.taxCategory.getTaxRateForDate(date);
		// TODO - implement Item.getTaxRateForDate
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the current amount
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) {
		
		return this.getPriceForDate(date).calcAmountForQty(quantity);
		
		// TODO - implement Item.calcAmountForDateQty
		//throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description for an instance of Item
	 */
	public String toString() {
		String result = "";
//		result += "\n==============================\n\n Item: "+description+" # "+number;
//		
//		for(Price p:this.prices) {
//			result +="\n Price: "+ p.getPrice()+"\n Effective Date: "+p.getEffectiveDate();
//		}
//		for(UPC up:this.UPCs.values())
//		{
//			result +=  "\n UPC: "+up.getUPC();
//		}
//		result += "\n Tax Category: "+this.getTaxCategory()+"\n\n";
//		
		result += this.number + " " + this.description + " ";
		for(Price p:this.prices) {
			result +=" "+ p.getPrice();
		}
		for(TaxRate r:this.getTaxCategory().getTaxRates()) {
			result +=" "+ r.getTaxRate();
		}
		
		return result;
		
		// TODO - implement Item.toString
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds a sale line item
	 * @param saleLineItem
	 */
	public void addSaleLineItem(SaleLineItem saleLineItem) {
		this.saleLineItems.add(saleLineItem);
		// TODO - implement Item.addSaleLineItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes the sale line item
	 * @param saleLineItem
	 */
	public void removeSaleLineItem(SaleLineItem saleLineItem) {
		saleLineItems.remove(saleLineItem);
		// TODO - implement Item.removeSaleLineItem
		//throw new UnsupportedOperationException();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	public TreeMap<String, UPC> getUPCs() {
		return UPCs;
	}

	public TreeSet<Price> getPrices() {
		return prices;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) {
		this.saleLineItems = saleLineItems;
	}

}