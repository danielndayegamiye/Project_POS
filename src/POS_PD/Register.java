package POS_PD;

import java.math.BigDecimal;

/**
 * This represents a physical register
 */
public class Register {

	/**
	 * This represents the number of the register
	 */
	private String number;
	/**
	 * This represents the physical cash drawer
	 */
	private CashDrawer cashDrawer;

	public CashDrawer getCashDrawer() {
		return cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) {
		this.cashDrawer = cashDrawer;
	}

	/**
	 * This is a default constructor
	 */
	private Store store;
	
	public void setStore(Store store) {
		this.store = store;
	}

	public Register() {
		this.number = null;
		this.cashDrawer = new CashDrawer();
		//this.store = new Store();
		// TODO - implement Register.Register
		// throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets parameters
	 * @param number
	 */
	public Register(Store store, String number) {
		this();
		this.number = number;
		this.store = store;
		this.store.addRegister(this);
		// TODO - implement Register.Register
		// throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of a register object
	 */
	public String toString() {
		String result = " " + this.number;
		//result += "\n==============================\n Register # "+number+"\n"+this.cashDrawer.toString()+"\n";
		return result;
		// TODO - implement Register.toString
		// throw new UnsupportedOperationException();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		store.removeRegister(this);
		this.number = number;
		store.addRegister(this);
	}

	public void setNumber(Store store, String text) {
		this.store = store;
		this.number = text;
		store.addRegister(this);
		
		// TODO Auto-generated method stub
		
	}

}