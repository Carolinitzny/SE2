package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    private Vormerkkarte _karte;
    private Kunde _kunde;
    private Kunde _kunde2;
    private List<Kunde> _vormerker;
    private Medium _medium;

    public VormerkkarteTest()
    {
        _kunde = new Kunde(new Kundennummer(123456), "ich", "du");
        _kunde2 = new Kunde(new Kundennummer(123457), "i", "d");
        _vormerker = new LinkedList<Kunde>();
        _vormerker.add(_kunde2);
        
        _medium = new CD("bar", "baz", "foo", 123);
        _karte = new Vormerkkarte(_kunde, _medium, _vormerker);
    }

    @Test
    public void testegetFormatiertenString() throws Exception
    {
        assertNotNull(_karte.getFormatiertenString());
    }

    @Test
    public void testeKonstruktor() throws Exception
    {
        assertEquals(_kunde, _karte.getEntleiher());
        assertEquals(_medium, _karte.getMedium());
        assertEquals(_vormerker, _karte.getVormerker());
    }

}
