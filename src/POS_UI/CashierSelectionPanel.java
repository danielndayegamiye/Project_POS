package POS_UI;

import javax.swing.JPanel;

import POS_PD.Cashier;
import POS_PD.Session;
import POS_PD.Store;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CashierSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierSelectionPanel(JFrame frame, Store store) {
		setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Edit");
		
		JButton btnNewButton_2 = new JButton("Delete");
		

		
		DefaultListModel listModel = new DefaultListModel();
		JList<Cashier> list = new JList<Cashier>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null) {
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					
					for(Session s: store.getSessions())
					{
						if(s.getCashier().equals(list.getSelectedValue()))
						{
							btnNewButton_2.setEnabled(false);
						}
					}
					}
				else {
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
			}
			}
		});
		list.setBounds(196, 113, 261, 174);
		add(list);
		for(Cashier c: store.getCashiers().values())
		{
			listModel.addElement(c);
		}
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CashierEditPanel(frame, store, new Cashier()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(125, 365, 89, 23);
		add(btnNewButton);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CashierEditPanel(frame, store, list.getSelectedValue()));
				frame.getContentPane().revalidate();
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeCashier(list.getSelectedValue());
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CashierSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		
		
		btnNewButton_1.setBounds(273, 365, 89, 23);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		btnNewButton_2.setBounds(422, 365, 89, 23);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);

	}
}
