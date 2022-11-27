package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class storeEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public storeEditPanel(JFrame frame, Store store) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setBounds(125, 129, 60, 39);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(195, 138, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.setName(textField.getText());
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new POS_Home(store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(125, 261, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new POS_Home(store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(331, 261, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Edit Store");
		lblNewLabel_1.setBounds(250, 50, 111, 39);
		add(lblNewLabel_1);


	}
}
