package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This represents the price for the items
 */
public class Price implements Comparable<Price> {

	/**
	 * This represents the price
	 */
	private BigDecimal price;
	/**
	 * This represents the effective date
	 */
	private LocalDate effectiveDate;
	/**
	 * This represents the item
	 */
	private Item item;

	/**
	 * This is a default constructor
	 */
	public Price() {
		this.price = null;
		this.effectiveDate = LocalDate.now();
		this.item=new Item();
		// TODO - implement Price.Price
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param price
	 * @param effectiveDate
	 */
	public Price(Item item, String price, String effectiveDate) {
		this.price  = new BigDecimal(price);
		this.effectiveDate = LocalDate.parse(effectiveDate,DateTimeFormatter.ofPattern("M/d/yy"));
		this.item=item;
		this.item.addPrice(this);
	
		// TODO - implement Price.Price
		//throw new UnsupportedOperationException();
	}

	/**
	 * This checks to see if it is effective
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		return date.isAfter(getEffectiveDate());
		// TODO - implement Price.isEffective
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the amount
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) {
		return this.price.multiply(new BigDecimal(quantity));
		// TODO - implement Price.calcAmountForQty
		//throw new UnsupportedOperationException();
	}

	/**
	 * This compares 2 prices
	 * @param price
	 */
	public int compareTo(Price price) {
		return this.effectiveDate.compareTo(price.effectiveDate);
		// TODO - implement Price.compareTo
		//throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of an instance of Price
	 */
	public String toString() {
		String result =  "";
		result += price +" "+this.effectiveDate;
		// TODO - implement Price.toString
		//throw new UnsupportedOperationException();
		return result;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Item getItem() {
		return item;
	}
	public Boolean isPromo() {
		return false;
	}

	public void setItem(Item item) {
		this.item.removePrice(this);
		this.item = item;
		this.item.addPrice(this);
	}



}