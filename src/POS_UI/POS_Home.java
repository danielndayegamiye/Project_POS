package POS_UI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import POS_PD.Store;

public class POS_Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public POS_Home(Store store) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel(store.getName());
		lblNewLabel.setBounds(250, 70, 176, 80);
		add(lblNewLabel);


	}

}
