package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

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

    // Eigenschaften einer Vormerkkarte
    private final Kunde _entleiher;
    private final Kunde _vormerker1;
    private final Kunde _vormerker2;
    private final Kunde _vormerker3;
    private final Medium _medium;

    /**
     * Initialisert eine neue Vormerkkarte mit den gegebenen Daten.
     * 
     * @param vormerker1 Ein Kunde, der das Medium vormerkt.
     * @param vormerker2 Ein Kunde, der das Medium vormerkt.
     * @param vormerker3 Ein Kunde, der das Medium vormerkt.
     * @param entleiher Ein Kunde, der das Medium ausgeliehen hat.
     * @param medium Ein vorgemerktes Medium.
     * 
     * @require entleiher != null
     * @require medium != null
     * 
     * @ensure #getEntleiher() == entleiher
     * @ensure #getMedium() == medium
     * @ensure #getVormerker1() == vormerker1
     * @ensure #getVormerker2() == vormerker2
     * @ensure #getVormerker3() == vormerker3
     */
    public Vormerkkarte(Kunde entleiher, Medium medium, Kunde vormerker1, Kunde vormerker2, Kunde vormerker3)
    {
        assert entleiher != null : "Vorbedingung verletzt: entleiher != null";
        assert medium != null : "Vorbedingung verletzt: medium != null";

        _entleiher = entleiher;
        _medium = medium;
        _vormerker1 = vormerker1;
        _vormerker2 = vormerker2;
        _vormerker3 = vormerker3;
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return Der Vormerker Nummer 1
     * 
     * 
     */
    public Kunde getVormerker1()
    {
        return _vormerker1;
    }
    
    /**
     * Gibt den Vormerker zurück.
     * 
     * @return Der Vormerker Nummer 2
     * 
     * 
     */
    public Kunde getVormerker2()
    {
        return _vormerker2;
    }

    /**
     * Gibt den Vormerker zurück.
     * 
     * @return Der Vormerker Nummer 3
     * 
     * 
     */
    public Kunde getVormerker3()
    {
        return _vormerker3;
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
