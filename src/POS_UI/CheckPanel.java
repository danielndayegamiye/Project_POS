package POS_UI;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import POS_PD.Check;
import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CheckPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CheckPanel(JFrame frame, Sale sale, Store store, Session session) {
		setLayout(null);
		setBounds(180, 111, 460, 304);
		
		JLabel lblNewLabel = new JLabel("Enter Check");
		lblNewLabel.setBounds(89, 28, 120, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount:");
		lblNewLabel_1.setBounds(21, 71, 120, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Routing Num:");
		lblNewLabel_2.setBounds(21, 112, 141, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Account Num:");
		lblNewLabel_3.setBounds(21, 154, 141, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Check Num:");
		lblNewLabel_4.setBounds(21, 194, 141, 14);
		add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Check check = new Check();
				check.setAmtTendered(new BigDecimal(textField.getText()));
				check.setRoutingNumber(textField_1.getText());
				check.setCheckNumber(textField_3.getText());
				check.setAccountNumber(textField_2.getText());
				sale.addPayment(check);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new paymentPanel(frame, sale, store, session)) ;
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(60, 239, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(187, 239, 89, 23);
		add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(187, 68, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 109, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 151, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 191, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);


	}

}
