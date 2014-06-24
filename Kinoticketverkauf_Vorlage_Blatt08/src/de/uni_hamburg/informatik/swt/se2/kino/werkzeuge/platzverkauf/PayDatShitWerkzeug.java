package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

public class PayDatShitWerkzeug 
{
	public boolean _istBezahlt = false;
	private int _bezahlphase = 1;
	private int _preis;
	private PayDatShitWerkzeugUI _ui;
	private int _bargeld;
	public PayDatShitWerkzeug(int preis)
	{
		_preis = preis;
		_ui = new PayDatShitWerkzeugUI(_preis);
		registriereUIaktionen();
		_ui.getDialog().setVisible(true);
		
	}
	public int gibPreis()
	{
		return _preis;
		
	}
	public int berechneRestbetrag(int preis, int bargeld)
	{
		int restbetrag = preis-bargeld;
		_ui.getRestbetragLabel().setText(String.valueOf(restbetrag*-1)+" Eurocent");
		return preis-bargeld;
	}
	
	public boolean istBezahlt(int bargeld)
	{
		_istBezahlt = berechneRestbetrag(_preis, bargeld) < 0;
		return berechneRestbetrag(_preis, bargeld) < 0;
	}
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
