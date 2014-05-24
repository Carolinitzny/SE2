package de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Datum;
import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Verleihkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.kundenstamm.KundenstammService;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.kundenstamm.KundenstammServiceImpl;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.medienbestand.MedienbestandService;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.medienbestand.MedienbestandServiceImpl;

public class VerleihServiceImpl2Test {
	
    private Kunde _kunde;
    private VerleihService _service;
    private List<Medium> _medienListe;
    private Kunde _vormerkkunde;
    private Kunde _vormerkkunde2;
    private Kunde _vormerkkunde3;
    private Datum _datum;
    
    public VerleihServiceImpl2Test()
    {
    	
    	_datum = new Datum(3, 4, 2009);
        KundenstammService kundenstamm = new KundenstammServiceImpl(
                new ArrayList<Kunde>());
        _kunde = new Kunde(new Kundennummer(123456), "ich", "du");

        _vormerkkunde = new Kunde(new Kundennummer(666999), "paul", "panter");
        _vormerkkunde2 = new Kunde(new Kundennummer(667000), "aa", "bb");
        _vormerkkunde2 = new Kunde(new Kundennummer(667001), "cc", "dd");

        kundenstamm.fuegeKundenEin(_kunde);
        kundenstamm.fuegeKundenEin(_vormerkkunde);
        MedienbestandService medienbestand = new MedienbestandServiceImpl(
                new ArrayList<Medium>());
        Medium medium = new CD("CD1", "baz", "foo", 123);
        medienbestand.fuegeMediumEin(medium);
        medium = new CD("CD2", "baz", "foo", 123);
        medienbestand.fuegeMediumEin(medium);
        medium = new CD("CD3", "baz", "foo", 123);
        medienbestand.fuegeMediumEin(medium);
        medium = new CD("CD4", "baz", "foo", 123);
        medienbestand.fuegeMediumEin(medium);
        _medienListe = medienbestand.getMedien();
        _service = new VerleihServiceImpl(kundenstamm, medienbestand,
                new ArrayList<Verleihkarte>());
    }
    
    @Test
    public void testeNachInitialisierungIstNichtsVorgemerkt() throws Exception
    {
        assertTrue(_service.getVormerkkarteFuerKunde(_vormerkkunde).get(0) == null);
        assertTrue(_service.istVormerkenMoeglich(_vormerkkunde, _medienListe.get(0)));
    }
    
    @Test
    public void testVormerken()
    {
        assertTrue(_service.istVormerkenMoeglich(_vormerkkunde, _medienListe.get(0)));
        _service.merkeVor(_vormerkkunde, _medienListe.get(0));
        assertTrue(_service.getVormerkkarteFuerMedium(_medienListe.get(0)).getVormerker().contains(_vormerkkunde));
        assertTrue(_service.getVormerkkarteFuerKunde(_vormerkkunde).get(0).getMedium() == _medienListe.get(0));
    }
    
    @Test
    public void testNichtDerSelbeVormerker()
    {
        assertFalse(_service.istVormerkenMoeglich(_vormerkkunde, _medienListe.get(0)));
    }
    
    @Test
    public void testNichtDerEntleiher() throws Exception
    {
    	List<Medium> listevormerken = new ArrayList<Medium>();
    	listevormerken.add(_medienListe.get(1));
    	_service.verleiheAn(_vormerkkunde, listevormerken, _datum);
        assertFalse(_service.istVormerkenMoeglich(_vormerkkunde, _medienListe.get(1)));
    }
    
    @Test
    public void test3Vormerker()
    {
        assertTrue(_service.istVormerkenMoeglich(_vormerkkunde2, _medienListe.get(0)));
        assertTrue(_service.istVormerkenMoeglich(_vormerkkunde3, _medienListe.get(0)));
        _service.merkeVor(_vormerkkunde2, _medienListe.get(0));
        _service.merkeVor(_vormerkkunde3, _medienListe.get(0));
        assertFalse(_service.istVormerkenMoeglich(_kunde, _medienListe.get(0)));
    }
    
    @Test
    public void testVerleihenAnVormerker()
    {
    	List<Medium> listeverleihen = new ArrayList<Medium>();
    	listeverleihen.add(_medienListe.get(0));
        assertFalse(_service.istVerleihenMoeglich(_vormerkkunde2, listeverleihen));
        assertTrue(_service.istVerleihenMoeglich(_vormerkkunde, listeverleihen));
    }
}
