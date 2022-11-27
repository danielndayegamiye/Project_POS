package POS_UI;

import javax.swing.JPanel;

import POS_PD.Store;
import POS_PD.TaxCategory;
import POS_PD.TaxRate;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class taxCategoryEditPanel extends JPanel {
	private JTextField textField;
	private TaxRate taxes;
	Boolean isEdit = false;
	JPanel panel = this;
	DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public taxCategoryEditPanel(JFrame frame, Store store, TaxCategory taxCategory) {
		setLayout(null);
		TaxCategory tax =  taxCategory;
		taxes = new TaxRate();

		textField = new JTextField(tax.getCategory());
		textField.setBounds(139, 152, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tax.getCategory() == null) {
					//store.addRegister(register);
					tax.setCategory(store, textField.getText());
				}
				else {
					tax.setStore(store);
					tax.setCategory(textField.getText());

				}
        		//new TaxRate(tax, LocalDate.parse(textField_2.getText(),DateTimeFormatter.ofPattern("M/d/yy")), new BigDecimal(textField_1.getText()));
        		//store.addTaxCategory(tax);
        		frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxCategoryPanel(frame, store));
				frame.getContentPane().revalidate();

			}
		});
		btnNewButton.setBounds(221, 342, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxCategoryPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(398, 342, 89, 23);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Edit Tax Category");
		lblNewLabel.setBounds(306, 89, 105, 20);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category: ");
		lblNewLabel_1.setBounds(77, 152, 78, 20);
		add(lblNewLabel_1);
		
		listModel = new DefaultListModel();
		JList<TaxRate> list = new JList<TaxRate>(listModel);
		list.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				/*
				 * if(isEdit) { listModel.removeElement(taxes); }
				 */
				listModel = new DefaultListModel();
				for(TaxRate t : taxCategory.getTaxRates()) {
					
					listModel.addElement(t);
				}
				list.setModel(listModel);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		
		list.setBounds(398, 154, 156, 97);
		add(list);
	
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * isEdit = true; taxes = list.getSelectedValue();
				 */
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxRatePanel(store,frame,panel, taxCategory, list.getSelectedValue()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(445, 262, 63, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Add");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new taxRatePanel(store,frame, panel, taxCategory, new TaxRate()));
				frame.getContentPane().revalidate();
				//frame.getContentPane().repaint();
			}
		});
		btnNewButton_2_1.setBounds(346, 262, 89, 20);
		add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Delete");
		btnNewButton_2_2.setEnabled(false);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null) {
					btnNewButton_2_2.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					}
				else {
					btnNewButton_2_2.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()!=null) {
					taxCategory.removeTaxRate(list.getSelectedValue());
					}
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new taxCategoryEditPanel(frame, store,taxCategory));
					frame.getContentPane().revalidate();
					//frame.getContentPane().repaint();
			}
		});
		btnNewButton_2_2.setBounds(517, 262, 72, 23);
		add(btnNewButton_2_2);

	}
}
