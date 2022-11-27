package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Sale;
import POS_PD.SaleLineItem;
import POS_PD.Session;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class SaleEntryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	Boolean hasFound = false;
	SaleLineItem sli = new SaleLineItem();
	JCheckBox chckbxNewCheckBox = new JCheckBox("Tax Free");


	/**
	 * Create the panel.
	 */
	public SaleEntryPanel(JFrame frame, Store store, Session session, Sale sale) {
		setLayout(null);
		//System.out.println(session.getSum().toString());
		textField_2 = new JTextField(sale.getSubTotal().toString());
		//textField_2.setEditable(false);
		//textField_2.setEditable(false);
		
		JLabel lblNewLabel_12 = new JLabel("Error!!!Incorrect UPC");
		lblNewLabel_12.setForeground(new Color(255, 0, 0));
		lblNewLabel_12.setVisible(false);
		lblNewLabel_12.setBounds(284, 47, 132, 20);
		add(lblNewLabel_12);

		JLabel lblNewLabel = new JLabel("Cashier:");
		lblNewLabel.setBounds(29, 37, 49, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(session.getCashier().toString());
		lblNewLabel_1.setBounds(102, 37, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Register:");
		lblNewLabel_2.setBounds(10, 59, 82, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(session.getRegister().toString());
		lblNewLabel_3.setBounds(102, 62, 49, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SALE");
		lblNewLabel_4.setBounds(297, 83, 71, 37);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Item: ");
		lblNewLabel_5.setBounds(29, 179, 49, 14);
		add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chckbxNewCheckBox.isSelected())
					sale.setTaxFree("Y");
				else
					sale.setTaxFree("N");
				if(store.findItemForUPC(textField.getText()) == null) {
					lblNewLabel_12.setVisible(true);
				}
				else {
				// Checking if the sale line item is already in the system
					for(SaleLineItem j: sale.getSaleLineItems()) {
						if(store.findItemForUPC(textField.getText()) .equals(j.getItem()))
						{
							if(Integer.parseInt(textField_1.getText()) > 0 )
								j.addToQuantity(Integer.parseInt(textField_1.getText()));
							else
								j.addToQuantity(0);
							hasFound = true;
						}
					}
				
				// Checking if the sale line item was not found in the sale
				if(!hasFound)
				{
					sli.setItem(store.findItemForUPC(textField.getText()));
					sli.setSale(sale);
					if(Integer.parseInt(textField_1.getText()) > 0 )
						sli.setQuantity(Integer.parseInt(textField_1.getText()));
					else
						sli.setQuantity(0);
				}
				
				sale.calcTotal();
				//System.out.println(sale.getTotal().toString());
				//System.out.println(session.getSum());

				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SaleEntryPanel(frame, store, session, sale));
				frame.getContentPane().revalidate();
				}
			}
		});
		textField.setBounds(117, 176, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Quantity");
		lblNewLabel_6.setBounds(268, 179, 49, 14);
		add(lblNewLabel_6);
		
		textField_1 = new JTextField("1");
		textField_1.setBounds(346, 176, 38, 20);
		add(textField_1);
		textField_1.setColumns(10);

		chckbxNewCheckBox.setBounds(489, 138, 99, 23);
		add(chckbxNewCheckBox);
		
		if(sale.getTaxFree()) {
			chckbxNewCheckBox.setSelected(true);
			chckbxNewCheckBox.setEnabled(false);
		}

		
		DefaultListModel listModel = new DefaultListModel();
		JList<SaleLineItem> list = new JList<SaleLineItem>(listModel);
		list.setBounds(29, 229, 319, 123);
		add(list);
		
			for(SaleLineItem j: sale.getSaleLineItems()) {
				listModel.addElement(j);
			}
		
		JButton btnNewButton = new JButton("Payment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new paymentPanel(frame, sale, store, session)) ;
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(62, 389, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Complete Sale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				session.addSale(sale);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SaleEntryPanel(frame, store, session, new Sale("N")));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(201, 389, 147, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel Sale");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SaleEntryPanel(frame, store, session, new Sale("N")));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(62, 434, 116, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("End Session");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SessionSummaryScreen(frame, store, session));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(201, 434, 147, 23);
		add(btnNewButton_3);
		
		if(sale.isPaymentEnough())
			btnNewButton_3.setEnabled(true);
		else
			btnNewButton_3.setEnabled(false);
			
		
		
		JLabel lblNewLabel_7 = new JLabel("SubTotal:");
		lblNewLabel_7.setBounds(366, 242, 74, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Tax:");
		lblNewLabel_8.setBounds(391, 292, 49, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Total:");
		lblNewLabel_9.setBounds(391, 338, 49, 14);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Amt Tendered:");
		lblNewLabel_10.setBounds(366, 393, 94, 14);
		add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Change:");
		lblNewLabel_11.setBounds(391, 418, 49, 30);
		add(lblNewLabel_11);
		
		textField_2.setBounds(489, 239, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(sale.getTaxAmount().toString());
		textField_3.setBounds(492, 289, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(sale.getTotal().toString());
		textField_4.setBounds(489, 335, 96, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(sale.calcAmtTendered().toString());
		textField_5.setBounds(489, 390, 96, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(sale.calcChange().toString());
		textField_6.setBounds(492, 423, 96, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		
		

	}
}
