 package POS_PD;

/**
 * This represents the Universal Product Code
 */
public class UPC {

	/**
	 * This gets the UPC as a string
	 */
	private String UPC;
	/**
	 * This gets the item specified by the UPC
	 */
	private Item item;
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * This gets the store
	 */
	private Store store;
	
	/**
	 * This is a default constructor
	 */
	public UPC() {
		this.UPC = null;
		// TODO - implement UPC.UPC
		//throw new UnsupportedOperationException();
	}

	/**
	 * This constructor gets a parameter
	 * @param upc
	 */
	public UPC(Item item, Store store, String upc) {
		this.UPC=upc;
		this.item = item;
		this.store=store;
		this.item.addUPC(this);
		this.store.addUPC(this);

		// TODO - implement UPC.UPC
		//throw new UnsupportedOperationException();
	}

	/**
	 * This returns a description of an instance of UPC
	 */
	public String toString() {
		return "" + UPC;
		// TODO - implement UPC.toString
		//throw new UnsupportedOperationException();
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		if(item.getUPCs()!=null) {
			item.removeUPC(this);
			store.removeUPC(this);
		}
		UPC = uPC;
		item.addUPC(this);
		store.addUPC(this);
		
	}
	
	public void setUPC(Store store, Item item, String uPC) {
		UPC = uPC;

		this.item = item;
		this.item.addUPC(this);
		
		this.store = store;
		this.store.addUPC(this);
		
		
	}


}