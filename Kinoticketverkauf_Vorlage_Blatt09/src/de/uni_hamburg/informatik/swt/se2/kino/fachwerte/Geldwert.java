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
    
/**
 * nice geldwert erstellen
 * @param wert
 */
    
    public Geldwert(int wert) {
        if (wert<0)
        {
            _negativ = true;
            _eurocent = wert *(-1);
            _euro = (_eurocent/100);
            _cent = _eurocent % 100;
        }
        else
        {
            _negativ = false;
            _eurocent = wert;
            _euro = (wert/100);
            _cent = wert % 100;
        }
    }
    /**
     * nice geldwert erstellen mit string
     * @param wert
     */
    public Geldwert(String wert)
    {
        _negativ = false;
        if (wert.matches("[0-9]+"))
        {
        	_euro = Integer.parseInt(wert);
        	_cent = 0;
        	if (_euro != 0 && (Integer.MAX_VALUE/_euro)>=100)
        	{
        	    _eurocent = _euro*100;
        	}
        	else if (_euro == 0) {
        	    _eurocent = _cent;
        	}
        	else{
        	    _eurocent = Integer.MAX_VALUE;
        	}
        	
        }
        
        else if (wert.matches("[0-9]+(,)[0-9]{2}"))
        {
            String[] parts = wert.split(","); 
            _euro = Integer.parseInt(parts[0]);
            _cent = Integer.parseInt(parts[1]);
            if (_euro != 0 && ( Integer.MAX_VALUE/_euro)>=100)
            {
                _eurocent = _euro*100 + _cent;
            }
            else if (_euro == 0) {
                _eurocent = _cent;
            }
            else{
                _eurocent = Integer.MAX_VALUE;
            }
        }
        else
        {
            _euro = 0;
            _cent = 0;
            _eurocent = 0;
        }
    }
    
    /**
     * addiert hier kram
     * @require istAddierenMoeglich()
     *
     */
    public Geldwert addieren(Geldwert geldwert)
    {
        assert istAddierenMoeglich(geldwert) : "Vorbedingung verletzt: istAddierenMoeglich()"; 
        
        if(geldwert._negativ && this._negativ){
            return new Geldwert(geldwert.getEurocent()*-1 + this.getEurocent()*-1);
        }
        else if(this._negativ)
        {
            return new Geldwert(geldwert.getEurocent() + this.getEurocent()*-1);
        }else if(geldwert._negativ)
        {
            return new Geldwert(this.getEurocent()+ geldwert.getEurocent()*-1);
        } else{
            return new Geldwert(geldwert.getEurocent() + this.getEurocent());
        }
        
        
    }
    /**
     * checkt aiddeern
     * @param wert
     */
    public boolean istAddierenMoeglich(Geldwert geldwert)
    {
        Geldwert ergebnis = new Geldwert(geldwert.getEurocent() + this.getEurocent());
        
        if (geldwert.istNegativ() && this.istNegativ() && (ergebnis.getEurocent()*-1)<0)
        {
            return true;
        }
        else if (!this._negativ && !geldwert._negativ && ergebnis.getEurocent() >= 0)
        {
            return true;
        }
        else if(!this._negativ && geldwert._negativ)
        {
            return true;
        }
        else if(this._negativ && !geldwert._negativ)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * subiib subsubsbusbsbbbi
     * @param wert
     */
    
    public Geldwert subtrahieren(Geldwert geldwert)
    {
        assert istAddierenMoeglich(geldwert) : "Vorbedingung verletzt: istAddierenMoeglich()"; 
        
        if(geldwert._negativ && this._negativ){
            return new Geldwert(geldwert.getEurocent()*-1 - this.getEurocent()*-1);
        }
        else if(this._negativ)
        {
            return new Geldwert(geldwert.getEurocent() - this.getEurocent()*-1);
        }else if(geldwert._negativ)
        {
            return new Geldwert(geldwert.getEurocent()*-1 - this.getEurocent());
        } else{
            return new Geldwert(geldwert.getEurocent() - this.getEurocent());
        }
    }
    /**
     * 
     * @require istMultiplizierenMoeglich()
     *
     */
    private boolean istMultiplizierenMoeglich(Geldwert geldwert, int faktor)
    {
        int ergebnis = geldwert.getEurocent()*faktor;
        if(ergebnis/faktor == geldwert.getEurocent())
        {
            return true;
            
        }else{
            
            return false;
        }
    }
    /**
     * muuuuuuuuuuuuuuuuuuuuuuuuultikill
     * @param wert
     */
    public Geldwert multiplizieren(int faktor)
    {
        assert istMultiplizierenMoeglich(this, faktor) : "Vorbedingung verletzt: istMultiplizierenMoeglich(this, faktor)";
    	return new Geldwert(this.getEurocent() * faktor);
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
