package POS_PD;

import java.math.BigDecimal;

/**
 * This represents money in cash
 */
public class Cash extends Payment {

	/**
	 * This is a default constructor
	 */
	public Cash() {
		this.setAmount(new BigDecimal(0));
		this.setAmtTendered(new BigDecimal(0));
		// TODO - implement Cash.Cash
		// throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(String amount, BigDecimal amtTendered) {
		this.setAmount(new BigDecimal(amount));
		this.setAmtTendered(amtTendered);
		// TODO - implement Cash.Cash
		// throw new UnsupportedOperationException();
	}

	/**
	 * This checks to see if it counts as cash
	 */
	/*
	 * public Boolean countAsCash() { // TODO - implement Cash.countAsCash throw new
	 * UnsupportedOperationException(); }
	 */

	/**
	 * This returns a description of an instance of Cash
	 */
	public String toString() {
		return "\n Cash\n"+" Amount: "+this.getAmount() + "\n Amount Tendered: " +this.getAmtTendered();
		// TODO - implement Cash.toString
		 //throw new UnsupportedOperationException();
	}

	
	public BigDecimal calcChange() {
		// TODO Auto-generated method stub
		return this.getAmtTendered().subtract(getAmount());
	}

	@Override
	public Boolean CountAsCash() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String paymentMethod() {
		// TODO Auto-generated method stub
		return "Cash";
	}
	
	


}