package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayDatShitWerkzeugUI extends JDialog {

	/**
	 * 
	 */
	public JDialog _dialog;
	private JLabel _preisLabel;
	private JLabel _restbetragLabel;
	private JTextField _bargeldField;
	private JButton _okButton;
	private JButton _abbrechenButton;
	
	public PayDatShitWerkzeugUI(int preis) 
	{
        _dialog = new JDialog();
        _dialog.setTitle("PayDatShit");
        _dialog.setSize(269,323);
        _dialog.setModal(true);
        _dialog.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        _dialog.getContentPane().add(new JLabel("Zu zahlen:"));
        _preisLabel = new JLabel(String.valueOf(preis));
        _dialog.getContentPane().add(_preisLabel);
        JLabel bargeldLabel = new JLabel("Bargeld:");
        _dialog.getContentPane().add(bargeldLabel);
        _bargeldField = new JTextField();
        _dialog.getContentPane().add(_bargeldField);
        JLabel rueckgeldLabel = new JLabel("Rückgeld:");
        _dialog.getContentPane().add(rueckgeldLabel);
        _restbetragLabel = new JLabel("");
        _dialog.getContentPane().add(_restbetragLabel);
        
        _okButton = new JButton("Ok");
        _dialog.getContentPane().add(_okButton);
        
        _abbrechenButton = new JButton("Abbrechen");
        _dialog.getContentPane().add(_abbrechenButton);
	}

	public JDialog getDialog()
	{
		return _dialog;
	}
	public JButton getOkButton()
	{
		return _okButton;
	}
	public JButton getAbbrechenButton()
	{
		return _abbrechenButton;
	}
	public JTextField getBargeldFeld()
	{
		return _bargeldField;
	}
	public JLabel getRestbetragLabel()
	{
		return _restbetragLabel;
	}
}
