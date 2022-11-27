package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This represents price in case of promotional pricing
 */
public class PromoPrice extends Price {

	/**
	 * This represents the ending date of the promotion
	 */
	private LocalDate endDate;

	/**
	 * This is a default constructor
	 */
	public PromoPrice() {
		endDate=LocalDate.now();
		// TODO - implement PromoPrice.PromoPrice
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(Item item, String price, String effectiveDate, String endDate) {
		this.setPrice( new BigDecimal(price));
		this.setEffectiveDate(LocalDate.parse(effectiveDate,DateTimeFormatter.ofPattern("M/d/yy")));
		this.setItem(item);
		//this.getItem().addPrice(this);
		this.endDate = LocalDate.parse(endDate,DateTimeFormatter.ofPattern("M/d/yy"));
		// TODO - implement PromoPrice.PromoPrice
		// throw new UnsupportedOperationException();
	}

	/**
	 * This checks to see if it is effective
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) {
		// TODO - implement PromoPrice.isEffective
		//throw new UnsupportedOperationException();
		return (this.endDate.isAfter(date) && this.getEffectiveDate().isBefore(date));
	}

	/**
	 * This returns a description of an instance of PromoPrice
	 */
	public String toString() {
		String result =  "";
		result += this.getPrice() +" "+this.getEffectiveDate() + " " + this.getEndDate();
		return result;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Boolean isPromo() {
		return true;
	}

}