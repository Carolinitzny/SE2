package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;
/**
 * Stellt einen Geldbetrag in Euro und in Cent dar.
 * 
 * @author 
 *
 */
public class Geldwert
{
    private final boolean _negativ;
    private final int _eurocent;
    private final int _euro;
    private final int _cent;
    
    
    
    public Geldwert(int wert) {
        if (wert<0)
        {
            _negativ = true;
            _eurocent = wert * (-1);
            _euro = (_eurocent/100);
//            _euro = (_eurocent - (_eurocent % 100)) / 100;
            _cent = _eurocent % 100;
        }
        else
        {
            _negativ = false;
            _eurocent = wert;
//            _euro = (wert - (wert % 100)) / 100;
            _euro = (wert/100);
            _cent = wert % 100;
        }
    }
    
    public Geldwert(String wert)
    {
        _negativ = false;
        if (wert.matches("[0-9]+"))
        {
        	_euro = Integer.parseInt(wert);
        	_cent = 0;
        	_eurocent = _euro*100;
        }
        
        else if (wert.matches("[0-9]+(,)[0-9]{2}")) //hab die richtige Regex eingefügt.
        {
            String[] parts = wert.split(","); 
            _euro = Integer.parseInt(parts[0]);
            _cent = Integer.parseInt(parts[1]);
            _eurocent = _euro*100 + _cent;
        }
        else
        {
            _euro = 0;
            _cent = 0;
            _eurocent = 0;
        }
    }
    
    public Geldwert addieren(Geldwert geldwert)
    {
        return new Geldwert(geldwert.getEurocent() + this.getEurocent());
    }
    
    public Geldwert subtrahieren(Geldwert geldwert)
    {
    	return new Geldwert(this.getEurocent() - geldwert.getEurocent());
    }
    
    public Geldwert multiplizieren(Geldwert geldwert)
    {
    	return new Geldwert(this.getEurocent() * geldwert.getEurocent());
    }
    
    public Geldwert multiplizieren(int geldwert)
    {
    	return new Geldwert(this.getEurocent() * geldwert);
    }
    
    public int getEurocent()
    {
        return _eurocent;
    }
    
    public int getEuro()
    {
    	return _euro;
    }
    
    public int getCent()
    {
    	return _cent;
    }
    
    public boolean istNegativ()
    {
    	return _negativ;
    }
    
    public String getString()
    {
    	if (String.valueOf(_cent).length()<2)
    	{
    	return String.valueOf(_euro)+",0"+String.valueOf(_cent);
    	}else{
    		return String.valueOf(_euro)+","+String.valueOf(_cent);
    	}
    }
}
