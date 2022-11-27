package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Item;
import POS_PD.Price;
import POS_PD.Store;
import POS_PD.TaxCategory;
import POS_PD.UPC;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class itemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel listModel;
	private DefaultListModel listModel_1;
	/**
	 * Create the panel.
	 */
	public itemEditPanel(JFrame frame, Store store, Item item) {
		
		JPanel currentPanel = this;
		
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(boxModel);
		setLayout(null);
		comboBox.setBounds(110, 191, 98, 22);
		add(comboBox);
		for(TaxCategory t: store.getTaxCategories().values())
		{
			boxModel.addElement(t);
		}
		
		JLabel lblNewLabel = new JLabel("Edit Item");
		lblNewLabel.setBounds(243, 28, 86, 29);
		add(lblNewLabel);
		
		listModel = new DefaultListModel();

		JList<UPC> list = new JList<UPC>(listModel);
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				listModel = new DefaultListModel();
				for(UPC u: item.getUPCs().values()) {
					listModel.addElement(u);
				}
				list.setModel(listModel);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		list.setBounds(463, 69, 117, 76);
		add(list);
		
		
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new upcEditPanel(frame, currentPanel, store, item, list.getSelectedValue()));
					frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(411, 174, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new upcEditPanel(frame, currentPanel, store, item, new UPC()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(521, 174, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
					item.removeUPC(list.getSelectedValue());
					store.removeUPC(list.getSelectedValue());
				}
				
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new itemEditPanel(frame, store, item));
					frame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(463, 208, 89, 23);
		add(btnNewButton_2);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null) {
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					}
				else {
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
			}
		}});
		
		JLabel lblNewLabel_1 = new JLabel("Item Number:");
		lblNewLabel_1.setBounds(26, 110, 86, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description:");
		lblNewLabel_2.setBounds(26, 153, 74, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tax Category:");
		lblNewLabel_3.setBounds(26, 195, 74, 14);
		add(lblNewLabel_3);
		
		listModel_1 = new DefaultListModel();

		JList<Price> list_1 = new JList<Price>(listModel_1);
		list_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				listModel_1 = new DefaultListModel();
				for(Price p: item.getPrices()) {
					listModel_1.addElement(p);
				}
				list_1.setModel(listModel_1);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		list_1.setBounds(374, 260, 216, 103);
		
		add(list_1);
		
		
		JButton btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new priceEditPanel(frame, currentPanel, store, item, list_1.getSelectedValue()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setBounds(411, 380, 89, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new priceEditPanel(frame, currentPanel, store, item, new Price()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(521, 380, 89, 23);
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list_1.getSelectedValue()!=null) {
					item.removePrice(list_1.getSelectedValue());
				}
				
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new itemEditPanel(frame, store, item));
					frame.getContentPane().revalidate();
			}
		});
		btnNewButton_5.setEnabled(false);
		btnNewButton_5.setBounds(463, 414, 89, 23);
		add(btnNewButton_5);
		
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list_1.getSelectedValue()!=null) {
					btnNewButton_3.setEnabled(true);
					btnNewButton_5.setEnabled(true);
					}
				else {
					btnNewButton_3.setEnabled(false);
					btnNewButton_5.setEnabled(false);
			}
		}});
		
		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(item.getDescription() == null)
				{
					item.setNumber(textField.getText());
					store.addItem(item);
				}
				else 
					item.setNumber(textField.getText());

				item.setDescription(textField_1.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new itemSelection(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_6.setBounds(66, 414, 89, 23);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new itemSelection(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_7.setBounds(226, 414, 89, 23);
		add(btnNewButton_7);
		
		textField = new JTextField();
		textField.setBounds(112, 107, 96, 20);
		add(textField);
		textField.setColumns(10);
		textField.setText(item.getNumber());
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 150, 96, 20);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(item.getDescription());
		
		
		

	}
}
