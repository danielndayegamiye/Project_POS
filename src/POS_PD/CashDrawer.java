package POS_PD;

import java.math.BigDecimal;

/**
 * This represents a single cash drawer
 */
public class CashDrawer {

	/**
	 * This represents the amount of cash
	 */
	private BigDecimal cashAmount;
	public BigDecimal getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	/**
	 * This represents the position of the drawer
	 */
	private int position;

	/**
	 * This is a default constructor
	 */
	public CashDrawer() {
		this.cashAmount = new BigDecimal(0);
		this.position = 0;
		// TODO - implement CashDrawer.CashDrawer
		// throw new UnsupportedOperationException();
	}
	/**
	 * This is a default constructor
	 */
	public CashDrawer(int position, BigDecimal amount) {
		this.cashAmount = amount;
		this.position = position;
		// TODO - implement CashDrawer.CashDrawer
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes cash from the drawer
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) {
		this.cashAmount.subtract(cash);
		// TODO - implement CashDrawer.removeCash
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds cash to the drawer
	 * @param cash
	 */
	public void addCash(BigDecimal cash) {
		this.cashAmount.add(cash);
		// TODO - implement CashDrawer.addCash
		// throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of the CashDrawer object
	 */
	public String toString() {
		return " Position: "+position+"\n Amount: "+cashAmount;
		// TODO - implement CashDrawer.toString
		// throw new UnsupportedOperationException();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}