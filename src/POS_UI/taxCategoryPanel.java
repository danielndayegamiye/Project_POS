package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Item;
import POS_PD.Register;
import POS_PD.Sale;
import POS_PD.SaleLineItem;
import POS_PD.Session;
import POS_PD.Store;
import POS_PD.TaxCategory;
import POS_PD.TaxRate;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class taxCategoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public taxCategoryPanel(JFrame frame, Store store) {
		setLayout(null);
		JButton btnNewButton_2 = new JButton("Delete");
		JButton btnNewButton_1 = new JButton("Add");
		JButton btnNewButton = new JButton("Edit");

		btnNewButton_2.setEnabled(false);
		btnNewButton.setEnabled(false);
		
		DefaultListModel listModel = new DefaultListModel();
		JList<TaxCategory> list = new JList<TaxCategory>(listModel);
		
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
								if(sli.getItem().getTaxCategory().equals(list.getSelectedValue()))
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
		list.setBounds(152, 98, 281, 152);
		add(list);
		
		for(TaxCategory t : store.getTaxCategories().values()) {
			
			listModel.addElement(t);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxCategoryEditPanel(frame, store, list.getSelectedValue()));
				frame.getContentPane().revalidate();			
			}
		});
		btnNewButton.setBounds(117, 383, 89, 23);
		//btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxCategoryEditPanel(frame, store, new TaxCategory()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(282, 383, 89, 23);
		add(btnNewButton_1);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
				store.removeTaxCategory(list.getSelectedValue());
				}
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxCategoryPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(454, 383, 89, 23);
		//btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);

		

	}
}
