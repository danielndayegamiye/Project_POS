package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Item;
import POS_PD.Store;
import POS_PD.UPC;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class upcEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public upcEditPanel(JFrame frame, JPanel iPanel, Store store, Item item, UPC upc) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit UPC");
		lblNewLabel.setBounds(296, 90, 63, 25);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPC Code: ");
		lblNewLabel_1.setBounds(168, 204, 77, 25);
		add(lblNewLabel_1);

		if(upc.getUPC() == null)
			textField = new JTextField();
		else
			textField = new JTextField(upc.getUPC());
		textField.setBounds(250, 206, 137, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(upc.getUPC() == null) {
					upc.setUPC(store, item, textField.getText());
					
					//item.addUPC(upc);
					//store.addUPC(upc);
				}
				
				else {
				upc.setUPC(textField.getText());
				}
				frame.getContentPane().removeAll();
				frame.getContentPane().add(iPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(176, 385, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(iPanel);
				frame.getContentPane().revalidate();
				frame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(404, 385, 89, 23);
		add(btnNewButton_1);
		

	}
}
