package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This represents payments with credit cards
 */
public class Credit extends AuthorizedPayment {

	/**
	 * This represents the type of cards
	 */
	private String cardType;
	/**
	 * This represents the account number
	 */
	private String acctNumber;
	/**
	 * This represents an expiration date
	 */
	private LocalDate expireDate;

	/**
	 * This is a default constructor
	 */
	public Credit() {
		cardType = "None";
		acctNumber = "000000";
		expireDate = LocalDate.of(1, 1, 1);
		// TODO - implement Credit.Credit
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets some parameters
	 * @param amount
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(String amount, String amountTendered, String cardType, String acctNumber, String expireDate) {
		this.cardType=cardType;
		this.acctNumber=acctNumber;
		this.expireDate= LocalDate.parse(expireDate,DateTimeFormatter.ofPattern("M/d/yy"));
		this.setAmtTendered(new BigDecimal(amountTendered));
		this.setAmount(new BigDecimal(amount));
		
		// TODO - implement Credit.Credit
		//throw new UnsupportedOperationException();
	}

	/**
	 * This checks if the credit card is authorized
	 */
	public Boolean isAuthorized() {
          return true;
	}

	/**
	 * This returns a description for an instance of Credit
	 */
	public String toString() {
		String card="\n Credit Card\n";
		card +=" Card Type: "+this.cardType+"\n Account #: "+this.acctNumber+"\n expire Date: "+this.expireDate;
		card += "\n Amount: "+this.getAmount() + "\n Amount Tendered: " +this.getAmtTendered();
		// TODO - implement Credit.toString
		//throw new UnsupportedOperationException();
		return card;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public BigDecimal calcChange() {
		return this.getAmtTendered().subtract(getAmount());
	}

	@Override
	public Boolean CountAsCash() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String paymentMethod() {
		// TODO Auto-generated method stub
		return "Credit";
	}

}