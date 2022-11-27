package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Item;
import POS_PD.Sale;
import POS_PD.SaleLineItem;
import POS_PD.Session;
import POS_PD.Store;
import POS_PD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class itemSelection extends JPanel {

	/**
	 * Create the panel.
	 */
	public itemSelection(JFrame frame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Item");
		lblNewLabel.setBounds(276, 94, 94, 27);
		add(lblNewLabel);
		
		DefaultListModel listModel = new DefaultListModel();
		JList<Item> list = new JList<Item>(listModel);
		
		
		list.setBounds(218, 144, 210, 178);
		add(list);
		
		for(Item t : store.getItems().values()) {
			
			listModel.addElement(t);
		}

		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new itemEditPanel(frame, store, list.getSelectedValue()));
				frame.getContentPane().revalidate();				
			}
		});
		btnNewButton.setBounds(104, 389, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new itemEditPanel(frame, store, new Item()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(260, 389, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!= null) {
					store.removeItem(list.getSelectedValue());
					}
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new itemSelection(frame, store));
					frame.getContentPane().revalidate();
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null) {
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					for(Session s: store.getSessions())
					{
						for(Sale sl: s.getSales())
						{
							for(SaleLineItem sli: sl.getSaleLineItems())
							{
								if(sli.getItem().equals(list.getSelectedValue()))
									btnNewButton_2.setEnabled(false);
							}
						}
					}
					}
				else {
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
			}
			}});
		btnNewButton_2.setBounds(425, 389, 89, 23);
		add(btnNewButton_2);
	}
}

