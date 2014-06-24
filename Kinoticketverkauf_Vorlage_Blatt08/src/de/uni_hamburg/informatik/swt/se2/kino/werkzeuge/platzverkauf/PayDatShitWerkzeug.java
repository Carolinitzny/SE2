package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

/**
 * Werkzeug für den Bezahlvorgang, gibt zu bezahlenden Betrag und Restbetrag an.
 * 
 * 
 * 
 * @author 
 *
 */

public class PayDatShitWerkzeug 
{
	public boolean _istBezahlt = false;
	private int _bezahlphase = 1;
	private int _preis;
	private PayDatShitWerkzeugUI _ui;
	private int _bargeld;
	
    /**
     * Erstellt ein neues Werzeug
     * 
     * @param preis Preis der insgesamt bezahlt werden soll, in Eurocent
     * 
     * 
     */
	
	public PayDatShitWerkzeug(int preis)
	{
		_preis = preis;
		_ui = new PayDatShitWerkzeugUI(_preis);
		registriereUIaktionen();
		_ui.getDialog().setVisible(true);
		
	}
	
	/**
	 * Gibt den zu zahlenden Preis zurück
	 * 
	 * @return zu zahlender Preis in Eurocent
	 */
	public int gibPreis()
	{
		return _preis;
		
	}
	
	/**
	 * Berechnet die Differenz zwischen dem zu zahlenden Betrag und dem gezahlten Betrag
	 * 
	 * @param preis der zu zahlende Preis
	 * @param bargeld der schon gezahlte Preis
	 * @return Restbetrag
	 * 
	 * @require bargeld darf kein negativer Betrag sein
	 */
	public int berechneRestbetrag(int preis, int bargeld)
	{
	    assert(bargeld>=0):"Bargeld darf kein negativer Wert sein";
		int restbetrag = preis-bargeld;
		_ui.getRestbetragLabel().setText(String.valueOf(restbetrag*-1)+" Eurocent");
		return preis-bargeld;
	}
	
	/**
	 * Prüft, ob der Preis bezahlt wurde
	 * 
	 * @param bargeld der schon gezahlte Preis
	 * @return Gibt zurück, ob genug bezahlt wurde
	 * 
     * @require bargeld darf kein negativer Betrag sein
	 */
	public boolean istBezahlt(int bargeld)
	{
	    assert(bargeld>=0):"Bargeld darf kein negativer Wert sein";
		_istBezahlt = berechneRestbetrag(_preis, bargeld) < 0;
		return berechneRestbetrag(_preis, bargeld) < 0;
	}
	
	/**
	 * Interaktion mit dem Userinterface, bei Betätigung des Abbrechen-Buttons in der UI wird der Dialog geschlossen
	 * und somit das restliche Programm fortgesetzt
	 */
	public void registriereUIaktionen()
	{
		
		_ui.getOkButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent okbutton) 
        	{
        		if (_bezahlphase == 1)
        		{
        			if (_ui.getBargeldFeld().getText().matches("[0-9]*"))
        			{
        		_bargeld = Integer.parseInt(_ui.getBargeldFeld().getText());
        		berechneRestbetrag(_preis, _bargeld);
        		if (istBezahlt(_bargeld))
        				{
        					_bezahlphase = 2;
        					_ui.getOkButton().setText("Tickets buchen");
        				}else{
        					_ui.getOkButton().setText("Ok");
        				}
        			}else{
        				_ui.getOkButton().setText("Ungültiger Bargeldwert");
        			}
        		}else{
        			_ui.getDialog().setVisible(false);
        		}
        	}
        });
		
		
		
		_ui.getAbbrechenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	_ui.getDialog().setVisible(false);
            }
        });
	}
}
