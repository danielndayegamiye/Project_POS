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

public class SessionSummaryScreen extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public SessionSummaryScreen(JFrame frame, Store store, Session session) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session Summary");
		lblNewLabel.setBounds(205, 55, 229, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier");
		lblNewLabel_1.setBounds(52, 110, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Register");
		lblNewLabel_2.setBounds(52, 135, 49, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(session.getCashier().toString());
		lblNewLabel_3.setBounds(129, 110, 49, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(session.getRegister().toString());
		lblNewLabel_4.setBounds(129, 135, 49, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Number Sales:");
		lblNewLabel_5.setBounds(52, 196, 108, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Total Sales:");
		lblNewLabel_6.setBounds(52, 240, 114, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Cash:");
		lblNewLabel_7.setBounds(52, 285, 108, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cash Count Diff:");
		lblNewLabel_8.setBounds(52, 329, 126, 14);
		add(lblNewLabel_8);
		
		textField = new JTextField(""+session.getNumberOfSales());
		textField.setBounds(205, 193, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(session.calcTotal().toString());
		textField_1.setBounds(205, 237, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(session.calcCashCountDiff(new BigDecimal(textField_2.getText())).toString());
			}
		});
		textField_2.setBounds(202, 282, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(202, 326, 96, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("End Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.addSession(session);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new LoginScreen(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(261, 396, 122, 23);
		add(btnNewButton);

	}
}
