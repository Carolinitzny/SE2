package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe von Vormerkkarten werden beim Vormerken eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde vorgemerkt? Wer
 * hat das Medium vorgemerkt? Wer ist der aktuelle Entleiher?
 * 
 * Wenn der letzte Vormerker das Medium ausleiht, kann die zugehörige Verleihkarte entsorgt
 * werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author 
 * @version SoSe 2014
 */
public class Vormerkkarte
{

    // Eigenschaften einer VormerkkartMediume
    private final Kunde _entleiher;
    private final List<Kunde> _vormerker;
    private final Medium _medium;

    /**
     * Initialisert eine neue Vormerkkarte mit den gegebenen Daten.
     * 
     * @param vormerkerer Guys die gierig auf die medien sind.
     * @param entleiher Ein Kunde, der das Medium ausgeliehen hat.
     * @param medium Ein vorgemerktes Medium.
     * 
     * @require entleiher != null
     * @require medium != null
     * 
     * @ensure #getEntleiher() == entleiher
     * @ensure #getMedium() == medium
     */
    public Vormerkkarte(Kunde entleiher, Medium medium, List<Kunde> vormerker)
    {
        assert entleiher != null : "Vorbedingung verletzt: entleiher != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";

        _entleiher = entleiher;
        _medium = medium;
        // TODO: Vormerker müssen auch irgendwo gespeichert werden, gell
        _vormerker = new LinkedList<Kunde>();
        
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return Der Vormerker Nummer 1
     * 
     * 
     */
    public List<Kunde> getVormerker()
    {
        return _vormerker;
    }
        /**
     * Gibt den Entleiher zurück.
     * 
     * @return den Kunden, der das Medium entliehen hat.
     * 
     * @ensure result != null
     */
    public Kunde getEntleiher()
    {
        return _entleiher;
    }

    /**
     * Gibt eine String-Darstellung der Vormerkkarte (enhält Zeilenumbrüche)
     * zurück.
     * 
     * @return Eine formatierte Stringrepäsentation der Vormerkkarte. Enthält
     *         Zeilenumbrüche.
     * 
     * @ensure result != null
     */
    public String getFormatiertenString()
    {
        return _medium.getFormatiertenString() + " verliehen an\n"
                + _entleiher.getFormatiertenString();
    }

    /**
     * Gibt das Medium, dessen Ausleihe auf der Karte vermerkt ist, zurück.
     * 
     * @return Das Medium, dessen Ausleihe auf dieser Karte vermerkt ist.
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }
}
