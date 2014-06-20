package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf;

import javax.swing.JPanel;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

public class PayDatShitWerkzeug 
{
	private Geld _preis;
	private PayDatShitWerkzeugUI _ui;
	private Geld _bargeld;
	public PayDatShitWerkzeug(Geld preis)
	{
		_ui = new PayDatShitWerkzeugUI();
		_preis = preis;
	}
	public Geld gibPreis()
	{
		return _preis;
		
	}
	public Geld berechneRestbetrag(Geld preis, Geld bargeld)
	{
		return preis.subtrahiere(bargeld);
	}
}
