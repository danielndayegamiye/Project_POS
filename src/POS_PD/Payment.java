package POS_PD;

import java.math.BigDecimal;

/**
 * This represents the payment made at the store
 */
public abstract class Payment {

	/**
	 * This represents the amount in the payment
	 */
	private BigDecimal amount;
	/**
	 * This represents the amount tendered
	 */
	private BigDecimal amtTendered;
    
	public abstract BigDecimal calcChange();
	/**
	 * This checks if it is counted as cash
	 */
	public abstract Boolean CountAsCash();
	public abstract String  paymentMethod();

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmtTendered() {
		return amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered) {
		this.amtTendered = amtTendered;
	}
}