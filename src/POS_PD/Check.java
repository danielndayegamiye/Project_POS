package POS_PD;

import java.math.BigDecimal;

/**
 * This represents checks as payment
 */
public class Check extends AuthorizedPayment {

	/**
	 * This represents the routing number
	 */
	private String routingNumber;
	/**
	 * This represents the account number
	 */
	private String accountNumber;
	/**
	 * This represents the number of the check
	 */
	private String checkNumber;

	/**
	 * This is a default constructor
	 */
	public Check() {
		routingNumber="00000";
		accountNumber = "00000";
		checkNumber = "000";
		// TODO - implement Check.Check
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param amount
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(String amount, String amountTendered, String routingNumber, String accountNumber, String checkNumber) {
		this.setAmount(new BigDecimal(amount));
		this.setAmtTendered(new BigDecimal(amountTendered));
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.checkNumber = checkNumber;
		// TODO - implement Check.Check
		//throw new UnsupportedOperationException();
	}

	/**
	 * This checks to see if it is authorized
	 */
	public Boolean isAuthorized() {
		return true;
	}

	/**
	 * This returns a description of an instance of Check
	 */
	public String toString() {
		String check = "\n Check\n";
		check+=" Account #: "+accountNumber + "\n" + " Check #: "+ checkNumber +"\n" +" Routing #: "+routingNumber;
		check += "\n Amount: "+this.getAmount() + "\n Amount Tendered: " +this.getAmtTendered();
		// TODO - implement Check.toString
		// new UnsupportedOperationException();
		return check;
	}

	@Override
	public BigDecimal calcChange() {
		// TODO Auto-generated method stub
		return this.getAmtTendered().subtract(getAmount());
	}

	@Override
	public Boolean CountAsCash() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	@Override
	public String paymentMethod() {
		// TODO Auto-generated method stub
		return "Check";
	}

}