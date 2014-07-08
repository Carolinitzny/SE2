package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testet die Methoden der Klasse Geldwert
 * 
 * @author 
 *
 */
public class GeldwertTest
{
    Geldwert geldwert = new Geldwert("20,50");
    Geldwert geldwert2 = new Geldwert(100);
    
    @Test
    public void testeAddieren()
    {
        Geldwert summe = geldwert.addieren(geldwert2);
        assertTrue(summe.getEurocent() == 2150);
        Geldwert summe2 = summe.addieren(new Geldwert(-500));
        assertTrue(summe2.getEurocent()== 1650);
        }
    
    @Test
   public void testeSubtrahieren()
    {
        Geldwert differenz = geldwert2.subtrahieren(geldwert);
        assertTrue(differenz.getEurocent() == 1950 && !differenz.istNegativ()); 
        differenz = geldwert.subtrahieren(geldwert2);
        assertTrue(differenz.getEurocent() == 1950 && differenz.istNegativ());
        
    }
    
    
    @Test
    public void testeMultiplizieren()
    {
        Geldwert produkt = geldwert2.multiplizieren(5);
        assertTrue(produkt.getEurocent() == 500);
    }
    
    @Test
    public void testeGetMethoden()
    {
        assertTrue(geldwert.getEurocent() == 2050);
        assertTrue(geldwert2.getEurocent() == 100);
        assertTrue(geldwert.getEuro() == 20);
        assertTrue(geldwert.getCent() == 50);
        assertTrue(geldwert.getString().equals("20,50"));
        assertFalse(geldwert.istNegativ());
    }
    
}
