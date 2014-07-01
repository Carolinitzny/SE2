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
            _euro = (_eurocent - (_eurocent % 100)) / 100;
            _cent = _eurocent % 100;
        }
        else
        {
            _negativ = false;
            _eurocent = wert;
            _euro = (wert - (wert % 100)) / 100;
            _cent = wert % 100;
        }
    }
    
    public Geldwert(String wert)
    {
        _negativ = false;
        
        if (wert.matches("[0-9]+"))
        {
            _euro = Integer.parseInt(wert)*100;
            _cent = 0;
            _eurocent = _euro * 100;
        }
        else if (wert.matches("[0-9]+,(0-9)(0-9)"))
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
    
    public static Geldwert addieren(Geldwert geldwert, Geldwert geldwert2)
    {
        int ergebnis = geldwert.getEurocent() + geldwert2.getEurocent();
        
        return new Geldwert(ergebnis);
    }
    
    private int getEurocent()
    {
        return _eurocent;
    }
    
}
