package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Register;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame frame, Store store, Register register) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Register");
		lblNewLabel.setBounds(295, 76, 116, 23);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Register Number: ");
		lblNewLabel_1.setBounds(113, 200, 125, 29);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(249, 204, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(register.getNumber() == null) {
					//store.addRegister(register);
					register.setNumber(store, textField.getText());
				}
				else
					register.setNumber(textField.getText());
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new RegisterSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(226, 387, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new RegisterSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(390, 387, 89, 23);
		add(btnNewButton_1);
		

	}

}
