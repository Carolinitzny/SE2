package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.util.Set;
import java.util.HashSet;

public abstract class Beobachtbar
{
    Set<Beobachter> _beobachter;
    
    public Beobachtbar()
    {
        _beobachter = new HashSet<Beobachter>();
        
    }
    
    public void setzeBeobachter(Beobachter beobachter)
    {
        _beobachter.add(beobachter);
    }
    
    public void meldeAenderung(String id)
    {
       for(Beobachter b : _beobachter)
       {
           b.reagiereAufAenderung(id);
       }
    }
}
