package POS_PD;

import java.util.*;

/**
 * This represents a cashier
 */
public class Cashier {

	/**
	 * This represents the number
	 */
	private String number;
	/**
	 * This represents the password associated with the cashier
	 */
	private String password;
	/**
	 * This represents a person
	 */
	private Person person;
	/**
	 * This represents the sessions
	 */
	private ArrayList<Session> sessions;

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	/**
	 * This is a default constructor
	 */
	private Store store;
	
	
	
	public Cashier() {
		this.number = null;
		this.password = "N/A";
		this.person = new Person();
		this.sessions = new ArrayList<Session>();
		this.store = new Store();

		// TODO - implement Cashier.Cashier
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets parameters
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(Store store, String number, Person person, String password) {
		this();
		this.number=number;
		this.person = person;
		this.password = password;
		this.store = store;
		store.addCashier(this);
		
		// TODO - implement Cashier.Cashier
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds a session
	 * @param session
	 */
	public void addSession(Session session) {
		this.sessions.add(session);
		// TODO - implement Cashier.addSession
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes a session
	 * @param session
	 */
	public void removeSession(Session session) {
		this.sessions.remove(session);
		// TODO - implement Cashier.removeSession
		//throw new UnsupportedOperationException();
	}

	/**
	 * This checks the authorization
	 * @param password
	 */
	public Boolean isAuthorized(String password) {
		// TODO - implement Cashier.isAuthorized
		throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of the object
	 */
	public String toString() {
		String result = "";

		//result += "\n==============================\n # "+this.number+this.person.toString()+"\n P: "+ password+"\n";
		result += number +" "+this.person.getName();
		return result;
		// TODO - implement Cashier.toString
		//throw new UnsupportedOperationException();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.store.removeCashier(this);
		this.number = number;
		this.store.addCashier(this);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setNumber(Store store, String text) {
		// TODO Auto-generated method stub
		this.store = store;
		this.number = text;
		store.addCashier(this);
		
	}

}