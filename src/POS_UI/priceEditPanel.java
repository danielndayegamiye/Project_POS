package POS_UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POS_PD.Item;
import POS_PD.Price;
import POS_PD.PromoPrice;
import POS_PD.Store;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class priceEditPanel extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the panel.
	 */
	public priceEditPanel(JFrame currentFrame, JPanel panel, Store store, Item item, Price price) {
		JTextField textField;
		JTextField textField_1;
		JLabel lblNewLabel_3 = new JLabel("End Date: ");

		
		
				 
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Promo Price");
		
		
		
		if(price.getPrice() == null)
		{
			chckbxNewCheckBox.setEnabled(true);
		}
		else
			chckbxNewCheckBox.setEnabled(false);
		
		chckbxNewCheckBox.setBounds(275, 130, 99, 23);
		add(chckbxNewCheckBox);
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Price");
		lblNewLabel.setBounds(296, 91, 68, 32);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price: ");
		lblNewLabel_1.setBounds(178, 227, 75, 19);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Effective Date:");
		lblNewLabel_1_1.setBounds(178, 255, 108, 19);
		add(lblNewLabel_1_1);
		
		if(price.getPrice() == null)
			textField = new JTextField();
		else
			textField = new JTextField(price.getPrice().toString());

		textField.setBounds(296, 226, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField(price.getEffectiveDate().format(DateTimeFormatter.ofPattern("M/d/yy")));
		textField_1.setBounds(296, 254, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		

		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					PromoPrice promoPrice = new PromoPrice();
					promoPrice.setPrice(new BigDecimal(textField.getText()));
					promoPrice.setEffectiveDate(LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("M/d/yy")));
					promoPrice.setEndDate(LocalDate.parse(textField_3.getText(),DateTimeFormatter.ofPattern("M/d/yy")));
					promoPrice.setItem(item);
				}
				else {
					price.setPrice(new BigDecimal(textField.getText()));
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(),DateTimeFormatter.ofPattern("M/d/yy")));
					price.setItem(item);
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(panel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(178, 420, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(panel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();

			}
		});
		btnNewButton_1.setBounds(378, 420, 89, 23);
		add(btnNewButton_1);
		
		lblNewLabel_3.setBounds(178, 288, 75, 17);
		lblNewLabel_3.setVisible(false);
		add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(296, 285, 96, 20);
		textField_3.setVisible(false);
		add(textField_3);
		
		textField_3.setColumns(10);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected())
				{
					lblNewLabel_3.setVisible(true);
					textField_3.setVisible(true);
				}
				else
				{
					lblNewLabel_3.setVisible(false);
					textField_3.setVisible(false);
				}
			}
		});
		
		// editing
		if(price.isPromo())
		{
			lblNewLabel_3.setVisible(true);
			textField_3.setVisible(true);
			chckbxNewCheckBox.setSelected(true);
		}
	}
}

