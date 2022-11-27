package POS_UI;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Cashier;
import POS_PD.Session;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;

public class CashierReportPanel extends JPanel {
	DatePicker datePicker = new DatePicker();

	/**
	 * Create the panel.
	 */
	public CashierReportPanel(JFrame frame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Report");
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
			public void actionPerformed(ActionEvent e) {
				BigDecimal totAmount =  new BigDecimal(0);
				int size = 0;
				BigDecimal totDiff = new BigDecimal(0);
				
				String message = "Cashier Report for: " + datePicker.getDate().toString();
				message += "\n\n\n";
				message += "Number\t\tName\tCount\tAmount\t\tDifference\n\n";
				for(Cashier c: store.getCashiers().values())
				{
					for(Session s: c.getSessions())
					{
						if(s.getStartDateTime().toLocalDate().equals(datePicker.getDate())) {
							totAmount = totAmount.add(s.getSum());
							size += s.getSales().size();
							totDiff = totDiff.add(s.getDiff());
							
							message += c.getNumber() + "\t\t" + c.getPerson().getName() + "\t " ;
							message +=  s.getSales().size() +"\t" + s.getSum() + "\t\t" + s.getDiff() + "\n";
						}
					}
				}
				message += "\n" + "Total:\t\t\t" +  size + "\t" + totAmount.toString()+ "\t\t" + totDiff;
				
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
//		datePicker.getDate()


	}
}
