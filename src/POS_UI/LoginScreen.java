package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.CashDrawer;
import POS_PD.Cashier;
import POS_PD.Register;
import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginScreen(JFrame frame, Store store) {
		setForeground(new Color(255, 0, 0));
		
		DefaultComboBoxModel comboModel_1 = new DefaultComboBoxModel();
		
		JComboBox<Register> comboBox = new JComboBox<Register>(comboModel_1);
		
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();

		JComboBox<Cashier> comboBox_1 = new JComboBox<Cashier>(comboModel);
		
		JLabel lblNewLabel_2 = new JLabel("Error !!!!! Invalid Password");
		lblNewLabel_2.setForeground(Color.red);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(194, 128, 273, 40);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Error!!!!invalid input for cashDrawer");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setBounds(183, 114, 231, 20);
		add(lblNewLabel_3);

		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(291, 75, 68, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier #");
		lblNewLabel_1.setBounds(142, 182, 80, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Register #");
		lblNewLabel_1_1.setBounds(142, 217, 80, 24);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Starting Cash");
		lblNewLabel_1_2.setBounds(142, 252, 80, 24);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password:");
		lblNewLabel_1_3.setBounds(142, 287, 80, 24);
		add(lblNewLabel_1_3);
		
		
		
		textField = new JTextField(null);
		textField.setBounds(238, 254, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = (Cashier)comboBox_1.getSelectedItem();
				lblNewLabel_3.setVisible(false);
				if(cashier.getPassword().equals(String.valueOf(passwordField.getPassword())))
				{
					lblNewLabel_2.setVisible(false);
					Session session = new Session();
					session.setCashier(cashier);
					if(textField.getText().isBlank()) {
						lblNewLabel_3.setVisible(true);
					}
					else if(!onlyDigits(textField.getText(), textField.getText().length()))
						lblNewLabel_3.setVisible(true);	
					else {
					CashDrawer cashDrawer = new CashDrawer(4, new BigDecimal(textField.getText()));
					Register register = (Register)comboBox.getSelectedItem();
					register.setCashDrawer(cashDrawer);
					session.setRegister(register);
					//store.addSession(session);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new SaleEntryPanel(frame, store, session,new Sale("N")));
					frame.getContentPane().revalidate();
					}
				}
				else
					lblNewLabel_2.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(225, 367, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new POS_Home(store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(401, 367, 89, 23);
		add(btnNewButton_1);
		
	
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = (Cashier)comboBox_1.getSelectedItem();
				lblNewLabel_3.setVisible(false);
				if(cashier.getPassword().equals(String.valueOf(passwordField.getPassword())))
				{
					lblNewLabel_2.setVisible(false);
					Session session = new Session();
					session.setCashier(cashier);
					if(textField.getText().isBlank()) {
						lblNewLabel_3.setVisible(true);
					}
					else if(!onlyDigits(textField.getText(), textField.getText().length()))
						lblNewLabel_3.setVisible(true);
					else 
					{
					CashDrawer cashDrawer = new CashDrawer(4, new BigDecimal(textField.getText()));
					Register register = (Register)comboBox.getSelectedItem();
					register.setCashDrawer(cashDrawer);
					session.setRegister(register);
					//store.addSession(session);
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new SaleEntryPanel(frame, store, session,new Sale("N")));
					frame.getContentPane().revalidate();
					}
				}
				else
					lblNewLabel_2.setVisible(true);
				
			}
		});
		passwordField.setBounds(248, 289, 86, 20);
		add(passwordField);
		
		
		comboBox.setBounds(237, 218, 97, 22);
		add(comboBox);
		
		for(Register r : store.getRegisters().values())
		{
			comboModel_1.addElement(r);
		}
		
		comboBox_1.setBounds(238, 183, 96, 22);
		add(comboBox_1);
		
		
		
		
		for(Cashier c:store.getCashiers().values())
		{
			comboModel.addElement(c);
		}

	}
	public static boolean onlyDigits(String str, int n)
    {
 
        // Traverse the string from
        // start to end
        for (int i = 0; i < n; i++) {
 
            // Check if the sepecified
            // character is a not digit
            // then return false,
            // else return false
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
          // If we reach here that means all
          // the characters were digits,
          // so we return true
        return true;
    }
	
}
