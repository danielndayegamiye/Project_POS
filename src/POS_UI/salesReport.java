package POS_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.lgooddatepicker.components.DatePicker;

import POS_PD.Cashier;
import POS_PD.Payment;
import POS_PD.Sale;
import POS_PD.Session;
import POS_PD.Store;

public class salesReport extends JPanel {
	DatePicker datePicker = new DatePicker();

	/**
	 * Create the panel.
	 */
	public salesReport(JFrame frame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setBounds(274, 49, 99, 37);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(203, 127, 49, 14);
		add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(56, 173, 595, 229);
		add(textArea);
		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BigDecimal totCash = new BigDecimal(0);
				BigDecimal totCredit = new BigDecimal(0);
				BigDecimal totCheck = new BigDecimal(0);
				BigDecimal total = new BigDecimal(0);
				
				BigDecimal tot2Cash = new BigDecimal(0);
				BigDecimal tot2Credit = new BigDecimal(0);
				BigDecimal tot2Check = new BigDecimal(0);
				BigDecimal total2 = new BigDecimal(0);

				String message = "Sales Report for: " + datePicker.getDate().toString();
				message += "\n\n\n";
				message += "Time\t\tCash\tCheck\tCredit\t\tTotal\n\n";
				for(Session s: store.getSessions())
				{
					if(s.getStartDateTime().toLocalDate().equals(datePicker.getDate())) {

					for(Sale sl: s.getSales())
					{
						total = new BigDecimal(0);
						message += s.getStartDateTime().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\t\t";	
						for(Payment p: sl.getPayments())
						{
							
							if(p.paymentMethod().equals("Cash")) {
								totCash = totCash.add(p.getAmtTendered());
							}
							else if(p.paymentMethod().equals("Credit"))
							{
								totCredit = totCredit.add(p.getAmtTendered());
							}
							else if(p.paymentMethod().equals("Check"))
							{
								totCheck = totCheck.add(p.getAmtTendered());
							}
							total = total.add(totCash.add(totCheck).add(totCredit));
							tot2Cash = tot2Cash.add(totCash);
							tot2Credit = tot2Credit.add(totCredit);
							tot2Check = tot2Check.add(totCheck);
							total2 = total2.add(total);

							message += totCash + "\t" + totCheck + "\t" + totCredit + "\t\t" + total + "\n";
						}
					}
				}
				}
				message += "\nTotal\t\t";
				message += tot2Cash + "\t" + tot2Check + "\t" + tot2Credit + "\t\t" + total2 + "\n";
				textArea.setText(message);
			}
		});
		btnNewButton.setBounds(163, 437, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new POS_Home(store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(407, 437, 89, 23);
		add(btnNewButton_1);
		

		datePicker.setBounds(274, 125, 158, 23);
		datePicker.getComponentDateTextField().setEditable(false);
		add(datePicker);
	}

}
