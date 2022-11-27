package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This represents the rate for the taxes
 */
public class TaxRate implements Comparable<TaxRate> {

	/**
	 * This gets a tax rate
	 */
	private BigDecimal taxRate;
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * This gets an effective date
	 */
	private LocalDate effectiveDate;

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * This is a default constructor
	 */
	public TaxRate() {
		this.effectiveDate = LocalDate.now();
		// TODO - implement TaxRate.TaxRate
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets parameters
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(TaxCategory taxCategory, LocalDate effectiveDate, BigDecimal rate) {
		this.taxRate = rate;
		this.effectiveDate = effectiveDate;
		taxCategory.addTaxRate(this);
		// TODO - implement TaxRate.TaxRate
		//throw new UnsupportedOperationException();
	}

	/**
	 * This checks the effectiveness
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		return date.isAfter(effectiveDate);
		// TODO - implement TaxRate.isEffective
		//throw new UnsupportedOperationException();
	}

	/**
	 * This compares the tax rates
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate) {
		// TODO - implement TaxRate.compareTo
		//throw new UnsupportedOperationException();
		return this.effectiveDate.compareTo(taxRate.effectiveDate);
	}

	/**
	 * This returns a TaxRate object
	 */
	public String toString() {
		return " "+taxRate+", "+effectiveDate;
		// TODO - implement TaxRate.toString
		//throw new UnsupportedOperationException();
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

}