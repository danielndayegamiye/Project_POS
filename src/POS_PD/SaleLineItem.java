package POS_PD;

import java.math.BigDecimal;
import java.util.Formatter;

/**
 * This represents a single tax line item
 */
public class SaleLineItem {
	BigDecimal subTotal;
	BigDecimal taxAmount;

	/**
	 * This represents the quantity of items
	 */
	private int quantity;
	/**
	 * This represents the sale
	 */
	private Sale sale;
	public void setSale(Sale sale) {
		this.sale = sale;
		this.sale.addSaleLineItem(this);
	}
	

	public Sale getSale() {
		return sale;
	}


	/**
	 * This represents the item
	 */
	private Item item;

	public void setItem(Item item) {
		this.item = item;
		this.item.addSaleLineItem(this);
	}

	/**
	 * This is a default constructor
	 */
	public SaleLineItem() {
		quantity = 0;
		sale = new Sale();
		item = new Item();
		subTotal = new BigDecimal(0);
		taxAmount = new BigDecimal(0);
		// TODO - implement SaleLineItem.SaleLineItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param sale
	 * @param item
	 * @param quantity
	 */
	public SaleLineItem(Sale sale, Item item, String quantity) {
		this();
		
		this.sale=sale;
		this.item = item;
		this.setQuantity(Integer.parseInt(quantity));
		
		this.item.addSaleLineItem(this);
		this.sale.addSaleLineItem(this);
		
		// TODO - implement SaleLineItem.SaleLineItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the sub total
	 */
	public BigDecimal calcSubTotal() {
		subTotal = item.calcAmountForDateQty(sale.getDateTime(), quantity);
		return subTotal;
		// TODO - implement SaleLineItem.calcSubTotal
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the tax
	 */
	public BigDecimal calcTax() {
		taxAmount = item.getTaxRateForDate(sale.getDateTime()).multiply(new BigDecimal(this.quantity));
		return taxAmount;
		// TODO - implement SaleLineItem.calcTax
		//throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of an instance of SaleLineItem
	 */
	public String toString() {
		String result =" ";
		result += item.getNumber()+" "+ item.getDescription()+" " + this.quantity +" "+this.getItem().getPriceForDate(sale.getDateTime())+" "+this.getTaxAmount();
		// TODO - implement SaleLineItem.toString
		//throw new UnsupportedOperationException();
		return result;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addToQuantity(int quantity)
	{
		this.quantity += quantity;
	}

	public Item getItem() {
		return item;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
}