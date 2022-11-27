package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This represents a session
 */
public class Session {

	/**
	 * This represents a starting time
	 */
	private LocalDateTime startDateTime;
	
	private BigDecimal diff = new BigDecimal(0.00);
	
	public BigDecimal getDiff() {
		return diff;
	}

	public void setDiff(BigDecimal diff) {
		this.diff = diff;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	/**
	 * This represents an ending time
	 */
	private LocalDateTime endDateTime;
	/**
	 * This represents a register
	 */
	private Register register;
	public void setRegister(Register register) {
		this.register = register;
	}

	/**
	 * This represents the sales
	 */
	private ArrayList<Sale> sales;
	/**
	 * This represents the cashier
	 */
	private Cashier cashier;
	
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	private BigDecimal sum;
	

	public BigDecimal getSum() {
		return sum;
	}

	/**
	 * This is a default constructor
	 */
	public Session() {
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = LocalDateTime.of(1, 1, 1, 1, 1);
		this.register = new Register();
		this.sales = new ArrayList<Sale>();
		this.cashier = new Cashier();
		sum = new BigDecimal(0);
		// TODO - implement Session.Session
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets parameters
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) {
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = LocalDateTime.of(1, 1, 1, 1, 1);
		this.register = register;
		this.sales = new ArrayList<Sale>();
		this.cashier = cashier;
		sum = new BigDecimal(0);
		this.cashier.addSession(this);

		//this.calcTotal();
		// TODO - implement Session.Session
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a sale
	 * @param sale
	 */
	public void addSale(Sale sale) {
		this.sales.add(sale);
		//this.calcTotal();
		// TODO - implement Session.addSale
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a sale
	 * @param sale
	 */
	public void removeSale(Sale sale) {
		this.sales.remove(sale);
		// TODO - implement Session.removeSale
		// throw new UnsupportedOperationException();
	}

	/**
	 * This calculate the cash and count the difference
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) {
		diff = new BigDecimal(0);
		BigDecimal sum1 = new BigDecimal(0);
		for(Sale s: this.sales) {
			sum1 = sum1.add(s.getTotalPayments());
		}
		sum1 = sum1.add(this.register.getCashDrawer().getCashAmount());
		for(Sale s: this.sales)
			sum1 = sum1.subtract(s.calcChange());
		diff = sum1.subtract(cash);
		return diff;
		// TODO - implement Session.calcCashCountDiff
		//throw new UnsupportedOperationException();
	}

	/**
	 * This gets the total
	 */
	public BigDecimal calcTotal() {
		sum = new BigDecimal(0);
		for(Sale s: this.sales)
		{
			sum = sum.add(s.calcTotal());
		}
		return sum;
		// TODO - implement Session.calcTotal
		// throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of the session object
	 */
	public String toString() {
		String result = "\n=====================================\nSession\n=========================================\n";
		result += "Cashier: " + cashier.getPerson().getName() + " Register # " + register.getNumber();
		
		for (Sale s:this.sales) {
			result +=s.toString();
		}
		
		
		return result;
		// TODO - implement Session.toString
		// new UnsupportedOperationException();
	}

	public ArrayList<Sale> getSales() {
		return sales;
	}

	public Register getRegister() {
		return register;
	}

	public Cashier getCashier() {
		return cashier;
	}
	
	public int getNumberOfSales()
	{
		return this.sales.size();
	}

}