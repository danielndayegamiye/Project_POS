package POS_PD;

/**
 * This is for authorized payments for checks or credit cards
 */
public abstract class AuthorizedPayment extends Payment {

	/**
	 * This represents an authorization code
	 */
	private String authorizationCode;

	/**
	 * This checks to see if it is authorized
	 */
	public abstract Boolean isAuthorized();

	/**
	 * This checks to see if it counts as cash
	 */
	public Boolean countAsCash() {
		// TODO - implement AuthorizedPayment.countAsCash
		throw new UnsupportedOperationException();
	}

}