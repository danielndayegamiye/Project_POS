package POS_UI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import POS_PD.Cash;
import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CashPanel extends JPanel {
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CashPanel(JFrame frame, Sale sale, Store store, Session session) {
		setLayout(null);
		setBounds(180, 111, 460, 304);

		JLabel lblNewLabel_3 = new JLabel("Enter Cash Payment");
		lblNewLabel_3.setBounds(134, 42, 138, 29);
		
		JLabel lblNewLabel_4 = new JLabel("Amount Tendered");
		lblNewLabel_4.setBounds(42, 97, 113, 14);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 94, 96, 20);
		textField_2.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Save");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cash cash = new Cash();
				cash.setAmtTendered(new BigDecimal(textField_2.getText()));
				sale.addPayment(cash);
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new paymentPanel(frame, sale, store, session)) ;
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(105, 152, 89, 23);
		
		JButton btnNewButton_5 = new JButton("Cancel");
		btnNewButton_5.setBounds(256, 152, 89, 23);
		add(lblNewLabel_3);
		this.add(lblNewLabel_4);
		this.add(textField_2);
		this.add(btnNewButton_4);
		this.add(btnNewButton_5);
		

	}

}
