package VierGewinnt;

//314165 Zeynep Melek Erdogan

import java.util.Scanner;
import java.util.Random;
public class VierGewinntSpiel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();



        Spielbrett brett = new Spielbrett(6,7);
        Spieler [] spieler = {new Spieler("Rot",'R'), new Spieler("Gelb",'G')};

        boolean gewinner = false;
        boolean unentschieden = false;

        System.out.println("Herzlich willkommen bei Vier Gewinnt ");

        System.out.println("Wieviele Spieler möchten Spielen 1 oder 2?  ");


        int anzahl = sc.nextInt();
        brett.generateBrett();

        brett.showBrett();

        int asp = 0;
        int spalte = 0;

        while(!gewinner&&!unentschieden) {
            if (asp == 2) {	asp = 0;	}

            if(anzahl==1&&asp==1) {
                spalte=r.nextInt(7);
                if (spalte == 0) {	spalte = 1;	}
            }
            else {
                System.out.println("Spieler "+spieler[asp].getFarbe()+ " ist dran.");
                System.out.print("Wähle bitte eine Spalte: ");
                spalte = sc.nextInt();
            }


            brett.setField(spalte-1, spieler[asp].getZeichen());

            brett.showBrett();

            gewinner = brett.controll(spieler[asp].getZeichen());

            if(gewinner == true) {
                System.out.println("Gratuliere Spieler "+spieler[asp].getFarbe()+" hat gewonnen!");
            }else if (unentschieden == true) {
                System.out.println("Es steht Unentschieden, vielleicht beim nächsten mal.");
            }

            asp++;

        }

    }


}
