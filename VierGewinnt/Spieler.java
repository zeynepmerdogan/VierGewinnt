package VierGewinnt;
//314165 Zeynep Melek Erdogan
public class Spieler extends VierGewinntSpiel{


    private final String farbe;
    private final char zeichen;


    public Spieler(String farbe, char zeichen) {
        this.farbe = farbe;
        this.zeichen = zeichen;
    }

    public String getFarbe() {
        return farbe;
    }


    public char getZeichen() {
        return zeichen;
    }

}
