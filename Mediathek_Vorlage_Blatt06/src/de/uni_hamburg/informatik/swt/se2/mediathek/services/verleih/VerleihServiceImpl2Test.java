package de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih;

import java.util.ArrayList;
import java.util.List;

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
    
    public VerleihServiceImpl2Test()
    {
        KundenstammService kundenstamm = new KundenstammServiceImpl(
                new ArrayList<Kunde>());
        _kunde = new Kunde(new Kundennummer(123456), "ich", "du");

        _vormerkkunde = new Kunde(new Kundennummer(666999), "paul", "panter");

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

}
