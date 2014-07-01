package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
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
    testeAddieren()
    {
        Geldwert summe = geldwert.addieren(geldwert2);
        assertTrue(summe.getEurocent() == 2150);
    }
    
    @Test
    testeSubtrahieren()
    {
        Geldwert differenz = geldwert.subtrahieren(geldwert2);
        assertTrue(differenz.getEurocent() == -1950);
    }
    
    @Test
    testeMultiplizieren()
    {
        Geldwert produkt = geldwert2.multiplizieren(5);
        assertTrue(produkt.getEurocent() == 500);
    }
    
    @Test
    testeGetMethoden()
    {
        assertTrue(geldwert.getEurocent() == 2050);
        assertTrue(geldwert2.getEurocent() == 100);
        assertTrue(geldwert.getEuro() == 20);
        assertTrue(geldwert.getCent() == 50);
        assertTrue(geldwert.toString().equals("20,50"));
        assertFalse(geldwert.istNegativ());
    }
    
}
