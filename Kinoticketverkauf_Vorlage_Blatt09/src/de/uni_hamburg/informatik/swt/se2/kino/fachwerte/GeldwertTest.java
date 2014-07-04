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
    }
    
    @Test
   public void testeSubtrahieren()
    {
        Geldwert differenz = geldwert2.subtrahieren(geldwert);
        assertTrue(differenz.getEurocent() == 1950 && differenz.istNegativ()); 
        /*
        da der wert ja immer positiv gesetzt wird und nur das istNegativ flag gesetzt wird muss hier so geprüft werden
        dazu waren die werte auch falsch rum. 2050-100 ist nicht -1950. hab das umgedreht sodass jetzt geldwert(2050) von
        Geldwert2(100) abgezogen wird.
        */
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
