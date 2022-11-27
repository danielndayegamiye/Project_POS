package POS_PD;

/**
 * This represents a person
 */
public class Person {

	/**
	 * This represents the name of the person
	 */
	private String name;
	/**
	 * This represents the address of the person
	 */
	private String address;
	/**
	 * This represents the city
	 */
	private String city;
	/**
	 * This represents the state
	 */
	private String state;
	/**
	 * This represents the zip code
	 */
	private String zip;
	/**
	 * This represents the phone number of the person
	 */
	private String phone;
	/**
	 * This represents the social security number of the person
	 */
	private String SSN;
	/**
	 * This represents the cashier
	 */
	private Cashier cashier;

	/**
	 * This represents the default constructor
	 */
	public Person() {
		this.name = null;
		this.address = "N/A";
		this.city = "N/A";
		this.state = "N/A";
		this.zip = "N/A";
		this.phone = "N/A";
		this.SSN = "N/A";
	
		// TODO - implement Person.Person
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets parameters
	 * @param name
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param SSN
	 */
	public Person(String name, String address, String city, String state, String zip, String phone, String SSN) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.SSN = SSN;
		this.cashier = new Cashier();
		// TODO - implement Person.Person
		//throw new UnsupportedOperationException();
	}

	/**
	 * This function return a string describing the object
	 */
	public String toString() {
		String result="";
		result += "\n Name: "+name+"\n Address: "+address+" "+city+" "+state+", "+zip+"\n Phone: "+phone+"\n SSN: "+SSN;
		return result;
		// TODO - implement Person.toString
		//throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

}