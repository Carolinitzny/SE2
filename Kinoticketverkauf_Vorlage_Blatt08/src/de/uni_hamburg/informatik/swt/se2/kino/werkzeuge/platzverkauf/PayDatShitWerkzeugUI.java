package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayDatShitWerkzeugUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBargeld;
	/**
	 * Create the dialog.
	 */
	public PayDatShitWerkzeugUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblZuZahlen = new JLabel("Zu zahlen");
			lblZuZahlen.setBounds(12, 66, 70, 15);
			contentPanel.add(lblZuZahlen);
		}
		{
			JLabel lblPreis = new JLabel("preis");
			lblPreis.setBounds(124, 66, 70, 15);
			contentPanel.add(lblPreis);
		}
		{
			JLabel lblBar = new JLabel("Bar");
			lblBar.setBounds(12, 113, 70, 15);
			contentPanel.add(lblBar);
		}
		{
			txtBargeld = new JTextField();
			txtBargeld.setText("bargeld");
			txtBargeld.setBounds(124, 111, 114, 19);
			contentPanel.add(txtBargeld);
			txtBargeld.setColumns(10);
		}
		{
			JLabel lblRueckgeld = new JLabel("Rueckgeld");
			lblRueckgeld.setBounds(12, 163, 70, 15);
			contentPanel.add(lblRueckgeld);
		}
		{
			JLabel lblRestbetrag = new JLabel("Restbetrag");
			lblRestbetrag.setBounds(124, 163, 70, 15);
			contentPanel.add(lblRestbetrag);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Abbrechen");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
