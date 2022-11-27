package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Credit;
import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class CreditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CreditPanel(JFrame frame, Sale sale, Store store, Session session) {
		DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
		
		JComboBox<String> comboBox = new JComboBox<String>(comboBoxModel);
		
		setLayout(null);
		setBounds(180, 111, 460, 304);
		
		JLabel lblNewLabel = new JLabel("Enter Credit Payment");
		lblNewLabel.setBounds(102, 31, 175, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount:");
		lblNewLabel_1.setBounds(52, 76, 96, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Card Type:");
		lblNewLabel_2.setBounds(52, 112, 119, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Acct Number:");
		lblNewLabel_3.setBounds(52, 151, 119, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Expire Date:");
		lblNewLabel_4.setBounds(52, 193, 119, 14);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(181, 73, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 148, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(181, 190, 96, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credit credit = new Credit();
				
				credit.setAmtTendered(new BigDecimal(textField.getText()));
				credit.setAcctNumber(textField_1.getText());
				credit.setExpireDate(LocalDate.parse(textField_2.getText(),DateTimeFormatter.ofPattern("M/d/yy")));
				credit.setCardType((String)comboBox.getSelectedItem());
				
				sale.addPayment(credit);
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new paymentPanel(frame, sale, store, session)) ;
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(88, 231, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(230, 231, 89, 23);
		add(btnNewButton_1);
		
		comboBox.setBounds(181, 108, 96, 22);
		comboBoxModel.addElement("Visa");
		comboBoxModel.addElement("MasterCard");

		add(comboBox);
	}
}
