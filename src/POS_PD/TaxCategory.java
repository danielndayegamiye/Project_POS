package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * This represents the category of taxes
 */
public class TaxCategory {

	/**
	 * This represents the category
	 */
	private String category;
	/**
	 * This represents the rates for the tax
	 */
	private TreeSet<TaxRate> taxRates;

	/**
	 * This is the default constructor
	 */
	Store store;
	
	public void setStore(Store store) {
		this.store = store;
	}

	public TaxCategory() {
		this.category = null;
		this.taxRates = new TreeSet<TaxRate>();
		// TODO - implement TaxCategory.TaxCategory
		// throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets a category
	 * @param category
	 */
	public TaxCategory(String category) {
		this.category = category;
		this.taxRates = new TreeSet<TaxRate>();
		// TODO - implement TaxCategory.TaxCategory
		// throw new UnsupportedOperationException();
	}

	/**
	 * This gets the tax rate depending on the date
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) {
		TaxRate taxRate = new TaxRate();
		for (TaxRate t:this.taxRates)
		{
			if(t.isEffective(date))
			{
				taxRate = t;
			}
		}
		return taxRate.getTaxRate();
		// TODO - implement TaxCategory.getTaxRateForDate
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds a tax rate
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate) {
		this.taxRates.add(taxRate);
		// TODO - implement TaxCategory.addTaxRate
		// throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description for a TaxCategory object
	 */
	public String toString() {
		return category;
		// TODO - implement TaxCategory.toString
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes a tax rate
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) {
		this.taxRates.remove(taxRate);
		// TODO - implement TaxCategory.removeTaxRate
		// throw new UnsupportedOperationException();
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.store.removeTaxCategory(this);
		this.category = category;
		this.store.addTaxCategory(this);
	}

	public TreeSet<TaxRate> getTaxRates() {
		return taxRates;
	}

	public void setCategory(Store store, String text) {
		// TODO Auto-generated method stub
		this.store = store;
		this.category = text;
		store.addTaxCategory(this);
		
	}

	

}