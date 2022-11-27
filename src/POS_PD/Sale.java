package POS_PD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * This represents a sale process
 */
public class Sale {
	BigDecimal total;

	BigDecimal subTotal;
	BigDecimal taxAmount;
	BigDecimal amountTendered;
	BigDecimal change;
	BigDecimal amount;
	BigDecimal amountForPayment;

	public BigDecimal getAmountForPayment() {
		return amountForPayment;
	}

	/**
	 * This represents the time
	 */
	private LocalDate dateTime;
	/**
	 * This represents the tax free items
	 */
	private Boolean taxFree;
	public Boolean getTaxFree() {
		return taxFree;
	}

	public void setTaxFree(String taxFree) {
		
		if (taxFree.equals("Y"))
			taxFree = "true";
		else if (taxFree.equals("N"))
			taxFree = "false";
		this.taxFree = Boolean.parseBoolean(taxFree);
		}

	/**
	 * This represents a payment
	 */
	private ArrayList<Payment> payments;
	public ArrayList<Payment> getPayments() {
		return payments;
	}

	/**
	 * This represents a sale line item
	 */
	private ArrayList<SaleLineItem> saleLineItems;

	public ArrayList<SaleLineItem> getSaleLineItems() {
		return saleLineItems;
	}

	/**
	 * This is the default constructor
	 */
	public Sale() {
		this.dateTime = LocalDate.now();
		this.taxFree = false;
		this.payments = new ArrayList<Payment>();
		this.saleLineItems = new ArrayList <SaleLineItem>();
		// TODO - implement Sale.Sale
		//throw new UnsupportedOperationException();
		
		subTotal = new BigDecimal(0);
		taxAmount = new BigDecimal(0);
		total = new BigDecimal(0);
		amountTendered = new BigDecimal(0);
		change = new BigDecimal(0);
		amount = new BigDecimal(0);
		amountForPayment = new BigDecimal(0);
	}

	/**
	 * This constructor gets parameters
	 * @param taxFree
	 */
	public Sale(String taxFree) {
		this();
		if (taxFree.equals("Y"))
			taxFree = "true";
		else if (taxFree.equals("N"))
			taxFree = "false";
		this.taxFree = Boolean.parseBoolean(taxFree);
		this.dateTime = LocalDate.now();
		this.payments = new ArrayList<Payment>();
		this.saleLineItems = new ArrayList <SaleLineItem>();
		// TODO - implement Sale.Sale
		//throw new UnsupportedOperationException();
		
		
	}

	/**
	 * This adds a payment
	 * @param payment
	 */
	public void addPayment(Payment payment) {
		this.payments.add(payment);
		// TODO - implement Sale.addPayment
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes a payment
	 * @param payment
	 */
	public void removePayment(Payment payment) {
		this.payments.remove(payment);
		// TODO - implement Sale.removePayment
		//throw new UnsupportedOperationException();
	}

	/**
	 * This adds a sale line item
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli) {
		this.saleLineItems.add(sli);
		// TODO - implement Sale.addSaleLineItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This removes a sale line item
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli) {
		this.removeSaleLineItem(sli);
		// TODO - implement Sale.removeSaleLineItem
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the total
	 */
	public BigDecimal calcTotal() {
		this.calcSubTotal();
		this.calcTax();
		total= this.getSubTotal().add(this.getTaxAmount());
		return total;
		// TODO - implement Sale.calcTotal
		// throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the sub total
	 */
	public BigDecimal calcSubTotal() {
		subTotal = new BigDecimal(0);
		for (SaleLineItem s:this.saleLineItems)
		{
			subTotal = subTotal.add(s.calcSubTotal());
		}
		return subTotal;
		// TODO - implement Sale.calcSubTotal
		//throw new UnsupportedOperationException();
	}

	/**
	 * This calculates the tax
	 */
	public BigDecimal calcTax() {
		taxAmount = new BigDecimal(0);
		if(!taxFree)
		{
			for (SaleLineItem s:this.saleLineItems)
			{
				taxAmount = taxAmount.add(s.calcTax());
			}
		}
		return taxAmount;
		// TODO - implement Sale.calcTax
		//throw new UnsupportedOperationException();
	}

	/**
	 * This gets the total of payments
	 */
	public BigDecimal getTotalPayments() {
		BigDecimal tPayment = new BigDecimal(0);
		// TODO - implement Sale.getTotalPayments
		//throw new UnsupportedOperationException();
		for(Payment p: this.payments)
		{
			if(p.CountAsCash())
			{
				tPayment = tPayment.add(p.getAmtTendered());
			}
		}
		return tPayment;
	}

	/**
	 * This checks if the payment is enough
	 */
	public Boolean isPaymentEnough() {
		if((this.calcAmtTendered().subtract(getTotal())).compareTo((new BigDecimal(0))) == -1)
			return false;
		else
			return true;
	}

	/**
	 * This calculates the amount for a payment
	 * @param amtTendered
	 */
	public BigDecimal calcAmountForPayment(BigDecimal amtTendered) {
		
		amountForPayment = getTotal().subtract(amtTendered);
		
		if(amountForPayment .compareTo((new BigDecimal(0))) == -1)
		{
			return new BigDecimal(0);
		}
		
		return getTotal().subtract(amtTendered);
	}

	/**
	 * This calculates the change
	 */
	public BigDecimal calcChange() {
		if((this.calcAmtTendered().subtract(getTotal())) .compareTo((new BigDecimal(0))) == -1)
		{
			return new BigDecimal(0);
		}
		return this.calcAmtTendered().subtract(getTotal());
		
	}

	/**
	 * This gets the amount paid
	 */
	public BigDecimal calcAmtTendered() {
		amountTendered = new BigDecimal(0);
		for(Payment p : this.payments)
		{
			amountTendered = amountTendered.add(p.getAmtTendered());
		}
		return amountTendered;
	}

	/**
	 * This returns a description of an instance of Sale
	 */
	public String toString() {
		String result ="";
		result += "\n==============================\n"+this.getDateTime()+" Sale: Subtotal = "+this.getSubTotal()+" tax = "+this.getTaxAmount()+" Total = "+this.getTotal()+"\n\n";
		for(SaleLineItem sl: this.saleLineItems)
		{
			result += "\n"+sl.toString();
		}
		for (Payment p: payments)
		{
			result+="\n\n"+p.toString();
		}
		return result;
		// TODO - implement Sale.toString
		//throw new UnsupportedOperationException();
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public BigDecimal getTotal() {
		return total;
	}

}