package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.Beobachter;

import java.util.Set;
import java.util.HashSet;

public abstract class Beobachtbar
{
	/**
	 * Ein Set aller Beobachter
	 */
    Set<Beobachter> _beobachter;
    
    public Beobachtbar()
    {
        _beobachter = new HashSet<Beobachter>();
        
    }
    /**
     * Fügt dem Set einen Beobachter hinzu
     * @param beobachter 
     */
    
    public void setzeBeobachter(Beobachter beobachter)
    {
        _beobachter.add(beobachter);
    }
    /**
     * Meldet die Änderung an die Beobachter.
     * @param id gibt an, wo die Änderung stattgefunden hat.
     */
    public void meldeAenderung(String id)
    {
       for(Beobachter b : _beobachter)
       {
           b.reagiereAufAenderung(id);
       }
    }
}
