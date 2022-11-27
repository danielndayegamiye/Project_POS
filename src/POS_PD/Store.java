package POS_PD;

import java.util.*;

import POS_DM.StoreDM;

/**
 * This represents the physical store
 */
public class Store {

	/**
	 * This represents the store number
	 */
	private String number;
	/**
	 * This represents the store name
	 */
	private String name;
	/**
	 * This represents the store's cashiers
	 */
	private TreeMap<String,Cashier> cashiers;
	/**
	 * This represents the store's sessions
	 */
	private ArrayList<Session> sessions;
	/**
	 * This represents the store's registers
	 */
	private TreeMap<String,Register> registers;
	/**
	 * This represents the store's tax categories
	 */
	private TreeMap<String,TaxCategory> taxCategories;
	/**
	 * This represents the store's items
	 */
	private TreeMap<String,Item> items;
	/**
	 * This represents the item's UPCS
	 */
	private TreeMap<String,UPC> upcs;

	/**
	 * This is a constructor
	 */
	public Store() {
		this.number = "N/A";
		this.name = "N/A";
		this.cashiers = new TreeMap<String,Cashier>();
		this.registers = new TreeMap<String,Register>();
		this.taxCategories = new TreeMap<String,TaxCategory>();
		this.items = new TreeMap<String,Item>();
		this.upcs = new TreeMap<String,UPC>();
		this.sessions = new ArrayList<Session>();


		// TODO - implement Store.Store
		// throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets several parameters
	 * @param number
	 * @param name
	 */
	public Store(String number, String name) {
		this.number = number;
		this.name = name;
		this.cashiers = new TreeMap<String,Cashier>();
		this.registers = new TreeMap<String,Register>();
		this.taxCategories = new TreeMap<String,TaxCategory>();
		this.items = new TreeMap<String,Item>();
		this.upcs = new TreeMap<String,UPC>();
		this.sessions = new ArrayList<Session>();
		// TODO - implement Store.Store
		// throw new UnsupportedOperationException();
	}

	/**
	 * This returns the string that represents the store
	 * @return This string represents the store
	 */
	public String toString() {
		String result = "";

		result += " "+ name + "\n";
		result += items.toString();
		result += this.cashiers.values().toString();
		result +="\n\n"+this.registers.values().toString();
		result +="\n==\n"+this.sessions.toString();
		//this.sessions.get(0).calcTotal();
		//result += "\n===\n"+this.sessions.get(0).getSales().get(0).toString();
		
	
		return result;
		// TODO - implement Store.toString
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds an item to the store's storage
	 * @param item
	 */
	public void addItem(Item item) {
		this.items.put(item.getNumber(), item);
		// TODO - implement Store.addItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes item from the storage
	 * @param item
	 */
	public void removeItem(Item item) {
		this.items.remove(item.getNumber(),item);
		// TODO - implement Store.removeItem
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a new UPC
	 * @param upc
	 */
	public void addUPC(UPC upc) {
		this.upcs.put(upc.getUPC(), upc);
		// TODO - implement Store.addUPC
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a UPC
	 * @param upc
	 */
	public void removeUPC(UPC upc) {
		this.upcs.remove(upc.getUPC());
		// TODO - implement Store.removeUPC
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a register to the store
	 * @param register
	 */
	public void addRegister(Register register) {
		this.registers.put(register.getNumber(), register);
		// TODO - implement Store.addRegister
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a register from the store
	 * @param register
	 */
	public void removeRegister(Register register) {
		this.registers.remove(register.getNumber());
		// TODO - implement Store.removeRegister
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a new cashier to the store
	 * @param cashier
	 */
	public void addCashier(Cashier cashier) {
		this.cashiers.put(cashier.getNumber(), cashier);
		// TODO - implement Store.addCashier
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a cashier from the store
	 * @param cashier
	 */
	public void removeCashier(Cashier cashier) {
		this.cashiers.remove(cashier.getNumber());
		// TODO - implement Store.removeCashier
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a tax category
	 * @param taxCategory
	 */
	public void addTaxCategory(TaxCategory taxCategory) {
		this.taxCategories.put(taxCategory.getCategory(), taxCategory);
		// TODO - implement Store.addTaxCategory
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a tax category from the store
	 * @param taxCategory
	 */
	public void removeTaxCategory(TaxCategory taxCategory) {
		this.taxCategories.remove(taxCategory.getCategory());
		// TODO - implement Store.removeTaxCategory
		// throw new UnsupportedOperationException();
	}

	/**
	 * This adds a new session
	 * @param session
	 */
	public void addSession(Session session) {
		this.sessions.add(session);
		// TODO - implement Store.addSession
		// throw new UnsupportedOperationException();
	}

	/**
	 * This removes a session
	 * @param session
	 */
	public void removeSession(Session session) {
		this.sessions.remove(session);
		// TODO - implement Store.removeSession
		// throw new UnsupportedOperationException();
	}

	/**
	 * This finds the register using the number
	 * @param number
	 */
	public Register findRegisterbyNumber(String number) {
		return this.registers.get(number);
		// TODO - implement Store.findRegisterbyNumber
		// throw new UnsupportedOperationException();
	}

	/**
	 * This finds an item using UPC
	 * @param upc
	 */
	public Item findItemForUPC(String upc) {
		if(this.upcs.get(upc) == null)
			return null;
		return this.upcs.get(upc).getItem();
	}

	/**
	 * This finds an item using the number
	 * @param number
	 */
	public Item findItemForNumber(String number) {
		// TODO - implement Store.findItemForNumber
		throw new UnsupportedOperationException();
	}

	/**
	 * This finds the cashier using the number
	 * @param number
	 */
	public Cashier findCashierForNumber(String number) {
		return this.cashiers.get(number);
		// TODO - implement Store.findCashierForNumber
		// throw new UnsupportedOperationException();
	}

	/**
	 * This finds the tax category using the name
	 * @param category
	 */
	public TaxCategory findTaxCategorybyName(String category) {
		return taxCategories.get(category);
		// TODO - implement Store.findTaxCategorybyName
		//throw new UnsupportedOperationException();
	}

	public TreeMap<String, Item> getItems() {
		return items;
	}

	public TreeMap<String, Cashier> getCashiers() {
		return cashiers;
	}

	public TreeMap<String, Register> getRegisters() {
		return registers;
	}

	public String getName() {
		return name;
	}

	public TreeMap<String, TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}
	public void openStore()
	{
		StoreDM.loadData(this);
		
		for (Session session: this.getSessions()) 
		{ 
			 session.calcTotal(); 
		}

	}

}