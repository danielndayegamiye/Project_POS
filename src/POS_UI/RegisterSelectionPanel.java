package POS_UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POS_PD.Register;
import POS_PD.Session;
import POS_PD.Store;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterSelectionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RegisterSelectionPanel(JFrame frame, Store store) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Register");
		lblNewLabel.setBounds(306, 89, 124, 23);
		add(lblNewLabel);
		
		DefaultListModel listModel = new DefaultListModel();
		JList<Register> list = new JList<Register>(listModel);
		
		list.setBounds(243, 160, 190, 187);
		add(list);
		for(Register r : store.getRegisters().values())
		{
			listModel.addElement(r);
		}
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new RegisterEditPanel(frame, store, list.getSelectedValue()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(121, 401, 89, 23);
		btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new RegisterEditPanel(frame, store, new Register()));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(266, 401, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeRegister(list.getSelectedValue());
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new RegisterSelectionPanel(frame, store));
				frame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(423, 401, 89, 23);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);

		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue()!=null) {
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					
					for(Session s: store.getSessions())
					{
						if(s.getRegister().equals(list.getSelectedValue()))
						{
							btnNewButton_2.setEnabled(false);
						}
					}
					}
				else {
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
			}
		}});
	}
}
