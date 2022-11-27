package POS_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import POS_PD.Item;
import POS_PD.Sale;
import POS_PD.SaleLineItem;
import POS_PD.Session;
import POS_PD.Store;
import com.github.lgooddatepicker.components.DatePicker;

public class ItemReportPanel extends JPanel {
	DatePicker datePicker = new DatePicker();

	/**
	 * Create the panel.
	 */
	public ItemReportPanel(JFrame frame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item Report");
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
				String message = "Item Report For: \n\n";
				int qty = 0;
				for(Item i: store.getItems().values())
				{
					qty = 0;
					for(SaleLineItem sli: i.getSaleLineItems()) {
						if(sli.getSale().getDateTime().equals(datePicker.getDate())){
							qty += sli.getQuantity();
						}
					}
					message += "" + i.getNumber()+ " " +manageString(i.getDescription()) + qty;
					message += "\n";
				}
								
				
				/*
				 * for(Session s: store.getSessions()) {
				 * if(s.getStartDateTime().toLocalDate().equals(datePicker.getDate())){ for(Sale
				 * s1: s.getSales()) { for(SaleLineItem sli: s1.getSaleLineItems()) message +=
				 * sli.displayReport()+"\n"; message += "\n"; } message += "\n\n\n"; } }
				 */
				textArea.setText(message);
			}
		});
		btnNewButton.setBounds(149, 437, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBounds(424, 437, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new POS_Home(store));
				frame.getContentPane().revalidate();
			}
		});
		add(btnNewButton_1);
		
		datePicker.setBounds(274, 125, 158, 23);
		datePicker.getComponentDateTextField().setEditable(false);
		add(datePicker);
		//SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");



	}
	
	public String manageString(String message)
	{
		int size = message.length();
		for(int i = size; i<21; i++)
		{
			message += "\t";
		}
		return message;
	}
}
