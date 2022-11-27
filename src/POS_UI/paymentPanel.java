package POS_UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class paymentPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	JPanel cashPanel = null;
	JPanel checkPanel = null;
	JPanel creditPanel = null;


	/**
	 * Create the panel.
	 */
	public paymentPanel(JFrame frame, Sale sale, Store store, Session session) {
		setLayout(null);
		
		
		//panel.setBounds(180, 111, 460, 304);
		
		
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setBounds(296, 55, 96, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Due");
		lblNewLabel_1.setBounds(31, 130, 96, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField(sale.calcAmountForPayment(sale.calcAmtTendered()).toString());
		textField.setBounds(31, 165, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amount Tendered");
		lblNewLabel_2.setBounds(31, 219, 108, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField(sale.calcAmtTendered().toString());
		textField_1.setBounds(31, 262, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JButton btnNewButton = new JButton("Cash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cashPanel = new CashPanel(frame, sale, store, session);
				cashPanel.setBounds(180, 111, 460, 304);
				
				add(cashPanel);
				if(checkPanel != null)
				{
					remove(checkPanel);
					checkPanel = null;
				}
				if(creditPanel != null)
				{
					remove(creditPanel);
					creditPanel = null;
				}
				revalidate();
				repaint();
			}
		});
		btnNewButton.setBounds(31, 324, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkPanel = new CheckPanel(frame, sale, store, session);
				checkPanel.setBounds(180, 111, 460, 304);
				
				add(checkPanel);
				if(cashPanel != null)
				{
					remove(cashPanel);
					cashPanel = null;
				}
				if(creditPanel != null)
				{
					remove(creditPanel);
					creditPanel = null;
				}
				revalidate();
				repaint();
			}
		});
		btnNewButton_1.setBounds(31, 385, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Credit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditPanel = new CreditPanel(frame, sale, store, session);
				creditPanel.setBounds(180, 111, 460, 304);
				
				add(creditPanel);
				if(cashPanel != null)
				{
					remove(cashPanel);
					cashPanel = null;
				}
				if(checkPanel != null)
				{
					remove(checkPanel);
					checkPanel = null;
				}
				revalidate();
				repaint();
			}
		});
		btnNewButton_2.setBounds(31, 430, 89, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment Complete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SaleEntryPanel(frame, store, session, sale));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(243, 440, 149, 23);
		add(btnNewButton_3);
		int cmp =sale.calcAmtTendered().compareTo(sale.getTotal());
		if( cmp == 1 || cmp == 0)
		{
			btnNewButton_3.setEnabled(true);
		}

	}
}
