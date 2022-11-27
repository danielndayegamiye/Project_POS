package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Cashier;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame frame, Store store, Cashier cashier) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Cashier");
		lblNewLabel.setBounds(308, 68, 77, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number: ");
		lblNewLabel_1.setBounds(82, 133, 68, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name: ");
		lblNewLabel_2.setBounds(82, 169, 77, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address: ");
		lblNewLabel_3.setBounds(82, 210, 68, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("City: ");
		lblNewLabel_4.setBounds(82, 257, 49, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone: ");
		lblNewLabel_5.setBounds(82, 310, 49, 14);
		add(lblNewLabel_5);
		
		textField = new JTextField(cashier.getNumber());
		textField.setBounds(183, 130, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(cashier.getPerson().getName());
		textField_1.setBounds(183, 166, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(cashier.getPerson().getAddress());
		textField_2.setBounds(183, 207, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(cashier.getPerson().getCity());
		textField_3.setBounds(183, 254, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(cashier.getPerson().getPhone());
		textField_4.setBounds(183, 307, 96, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password: ");
		lblNewLabel_6.setBounds(354, 169, 77, 14);
		add(lblNewLabel_6);
		
		textField_5 = new JTextField(cashier.getPassword());
		textField_5.setBounds(460, 166, 96, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("SSN: ");
		lblNewLabel_7.setBounds(382, 210, 49, 14);
		add(lblNewLabel_7);
		
		textField_6 = new JTextField(cashier.getPerson().getSSN());
		textField_6.setBounds(460, 207, 96, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("State: ");
		lblNewLabel_8.setBounds(382, 257, 49, 14);
		add(lblNewLabel_8);
		
		textField_7 = new JTextField(cashier.getPerson().getState());
		textField_7.setBounds(460, 254, 30, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Zip: ");
		lblNewLabel_9.setBounds(382, 310, 49, 14);
		add(lblNewLabel_9);
		
		textField_8 = new JTextField(cashier.getPerson().getZip());
		textField_8.setBounds(460, 307, 59, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(cashier.getNumber() == null)
					//store.addRegister(register);
					cashier.setNumber(store, textField.getText());
				else
					cashier.setNumber(textField.getText());
				
				cashier.getPerson().setName(textField_1.getText());
				cashier.getPerson().setAddress(textField_2.getText());
				cashier.getPerson().setCity(textField_3.getText());
				cashier.getPerson().setState(textField_7.getText());
				cashier.getPerson().setPhone(textField_4.getText());
				cashier.setPassword(textField_5.getText());
				cashier.getPerson().setSSN(textField_6.getText());
				cashier.getPerson().setZip(textField_8.getText());
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CashierSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
				
				
			}
		});
		btnNewButton.setBounds(231, 407, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CashierSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(417, 407, 89, 23);
		add(btnNewButton_1);
		

	}

}
