package POS_UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_PD.Store;
import POS_PD.TaxCategory;
import POS_PD.TaxRate;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class taxRatePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public taxRatePanel(Store store, JFrame frame,JPanel tcPanel, TaxCategory taxCategory, TaxRate taxRate) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tax Rate");
		lblNewLabel.setBounds(278, 110, 94, 34);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rate: ");
		lblNewLabel_1.setBounds(121, 209, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date: ");
		lblNewLabel_2.setBounds(121, 268, 49, 14);
		add(lblNewLabel_2);
		if(taxRate.getTaxRate() != null)
			textField = new JTextField(taxRate.getTaxRate().toString());
		else
			textField = new JTextField();

		textField.setBounds(255, 206, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(taxRate.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy")));
		textField_1.setBounds(255, 265, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(taxRate.getTaxRate() == null) {
					new TaxRate(taxCategory,LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("M/d/yy")), new BigDecimal(textField.getText()));
			   }
				else 
				{
					taxRate.setTaxRate(new BigDecimal(textField.getText()));
					taxRate.setEffectiveDate(LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("M/d/yy")));
				}
				frame.getContentPane().removeAll();
				frame.getContentPane().add(tcPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(136, 380, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(tcPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(341, 380, 89, 23);
		add(btnNewButton_1);

		
	}
}
