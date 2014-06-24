package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

public class Geld 
{
	private int _euro;
	private int _cent;
	
	public Geld(int euro, int cent)
	{
		_euro = euro;
		_cent = cent;
	}
	public Geld(int eurocent)
	{
		String betrag = Integer.toString(eurocent);
		if (betrag.length()>3)
		{
		_euro = Integer.parseInt(betrag.substring(0, betrag.length()-3));
		_cent = Integer.parseInt(betrag.substring(betrag.length()-3, betrag.length()-1));
		}
	}
	
	public int gibEuro()
	{
		return _euro;
	}
	public int gibCent()
	{
		return _cent;
	}
	public float gibBetrag()
	{
		return _euro+(_cent/100);
	}
	public Geld subtrahiere(Geld minuent)
	{
		int euro = _euro-minuent.gibEuro();
		int cent = _cent-minuent.gibCent();
		if (cent < 0)
		{
			euro--;
			cent += 100;
		}
		return new Geld(euro,cent);
	}

}
