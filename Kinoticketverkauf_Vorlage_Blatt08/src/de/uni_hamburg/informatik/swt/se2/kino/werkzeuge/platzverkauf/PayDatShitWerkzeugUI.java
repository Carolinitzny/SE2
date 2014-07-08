package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayDatShitWerkzeugUI 
{

	
	private JDialog _dialog;
	private JLabel _preisLabel;
	private JLabel _restbetragLabel;
	private JTextField _bargeldField;
	private JButton _okButton;
	private JButton _abbrechenButton;
	
	/**
	 * Erstellt ein JDialog, welches im 
	 * engen Austausch mit dem PayDatShitWerkzeug steht.
	 * Es wird ein Interface mit einem OkButton, einem AbbrechenButton und Feldern
	 * fuer die Betraege erstellt.
	 * @param preis in Eurocent
	 
	 
	 */
	
	public PayDatShitWerkzeugUI(int preis) 
	{
	    
	    
	    //Erzeugen der UI.
        _dialog = new JDialog();
        _dialog.setTitle("PayDatShit");
        _dialog.setSize(269,323);
        _dialog.setModal(true);
        _dialog.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        _dialog.getContentPane().add(new JLabel("Zu zahlen:"));
        _preisLabel = new JLabel(String.valueOf(preis)+" Eurocent");
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
  
	// Get Methoden fuer Zugriff auf Dialog
	public JDialog getDialog()
	{
		return _dialog;
	}
	// Get Methoden fuer Zugriff auf den Okbutton
	public JButton getOkButton()
	{
		return _okButton;
	}
	// Get Methoden fuer Zugriff auf den Abbruchbutton
	public JButton getAbbrechenButton()
	{
		return _abbrechenButton;
	}
	// Get Methoden fuer Zugriff auf das Feld, mit dem Geldbetrag
	public JTextField getBargeldFeld()
	{
		return _bargeldField;
	}
	// Get Methoden fuer Zugriff auf die Anzeige des Restbetrags
	public JLabel getRestbetragLabel()
	{
		return _restbetragLabel;
	}
}
