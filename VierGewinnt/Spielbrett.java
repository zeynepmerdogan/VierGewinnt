package VierGewinnt;

import java.util.Scanner;


    public class Spielbrett extends VierGewinntSpiel {



        private char[][] brett;

        Scanner sc = new Scanner(System.in);

        public Spielbrett (int zeile, int spalte) {

            this.brett = new char[zeile][spalte];
        }

        public void generateBrett() {
            for(int i=0 ;i<6 ;i++) {

                for(int j = 0; j<7; j++) {
                    setField(i,j,'X');
                }
            }
        }

        public void setField(int zeile, int spalte, char zeichen) {
            brett[zeile][spalte] = zeichen;
        }

        public void setField(int spalte, char zeichen) {
            int i = 5;
            if (brett[0][spalte]!='X' && spalte>6) {

                System.out.println("Die Spalte ist voll! ");
                spalte = sc.nextInt();
                while(i>=0) {
                    if (brett[i][spalte]=='X') {	brett[i][spalte]=zeichen;
                        break;
                    }
                    else {	i--;	}
                }
            }else {
                while(i>=0) {
                    if (brett[i][spalte]=='X') {	brett[i][spalte]=zeichen;
                        break;
                    }
                    else {	i--;	}
                }
            }

        }

        public void showBrett() {

            for(int i = 0; i<6;i++) {
                for(int j = 0; j<7; j++) {
                    System.out.print(brett[i][j]+"\s");
                }
                System.out.println();
            }
            for(int i = 1; i<=7;i++) {
                System.out.print(i+"\s");
            }

            System.out.println();
            System.out.println();

        }

        public boolean controll() {
            int punkte = 0;

            for(int i = 0; i<7; i++) {
                if (brett[0][i]!='X') {
                    punkte ++;
                }
            }
            if(punkte==7) {
                return true;
            }
            else {	return false;	}
        }

        public boolean controll(char zeichen) {
            if (controllS(zeichen) == true || controllW(zeichen) == true) {
                return true;
            }else if (controllDL(zeichen) == true || controllDR(zeichen) == true){
                return true;
            }
            return false;
        }

        private boolean controllS(char zeichen) {
            int punkte = 0;
            for (int i = 0;i<7;i++) {
                for (int j = 5;j>=0;j--) {
                    if(brett[j][i]==zeichen) {
                        punkte++;
                    }
                    else if(brett[j][i]!=zeichen && punkte!=0 ) {
                        punkte = 0;
                    }
                    if(punkte == 4) {	return true;}
                }
            }
            return false;
        }

        private boolean controllW(char zeichen) {
            int punkte = 0;
            for (int i = 5;i>=0;i--) {
                for (int j = 0;j<7;j++) {
                    if(brett[i][j]==zeichen) {	punkte++;	}
                    else if(brett[i][j]!=zeichen && punkte!=0 ) {
                        punkte = 0;	}
                    if(punkte == 4) {
                        return true;	}
                }
            }
            return false;
        }

        private boolean controllDL(char zeichen){
            int punkte = 0;	int runde = 1;

            int s = 0;	int z = 5;
            int x = 6;	int y = -1;

            while(runde != 6) {
                while(s!=x&&z!=y) {
                    if(punkte == 4) {	return true;	}
                    if(brett[z][s]==zeichen) {	punkte ++;	}
                    else if(brett[z][s]!=zeichen && punkte!=0 ) {	punkte = 0;	}
                    s++;
                    z--;
                }

                switch(runde) {

                    case 1:	s = 1;	z = 5;	x = 7;	break;

                    case 2:	s = 2;	z = 5;	y = 0;	break;

                    case 3:	s = 3;	z = 5;	y = 1;	break;

                    case 4:	s = 0;	z = 4;	x = 5;	y = -1;	break;

                    case 5:	s = 0;	z = 3;	x = 4;	break;

                }

                runde ++;
            }

            return false;

        }

        private boolean controllDR(char zeichen){
            int punkte = 0;	int runde = 1;

            int s = 6;	int z = 5;
            int x = 0;	int y = -1;

            while(runde != 6) {
                while(s!=x&&z!=y) {
                    if(punkte == 4) {	return true;	}
                    if(brett[z][s]==zeichen) {	punkte ++;	}
                    else if(brett[z][s]!=zeichen && punkte!=0 ) {	punkte = 0;	}
                    s--;
                    z--;
                }

                switch(runde) {

                    case 1:	s = 5;	z = 5;	x = -1;	break;

                    case 2:	s = 4;	z = 5;	y = 0;	break;

                    case 3:	s = 3;	z = 5;	y = 1;	break;

                    case 4:	s = 6;	z = 4;	x = 1;	y = -1;	break;

                    case 5:	s = 6;	z = 3;	x = 2;	break;

                }
                runde ++;
            }
            return false;

        }
    }

