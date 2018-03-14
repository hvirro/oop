import java.util.ArrayList;
import java.util.Scanner;

public class Mängulaud {
    // FIXME: 14.03.18 MUUTUJAD PRIVAATSEKS!
    private char[][] laud;
    // TODO: 14.03.18 kasutada enum objekte mitte char laua jaoks.
    private int käikudeArv = 0;
    private int dimensioon = 3;
    private boolean keegiVõitis = false;
    public Mängulaud() {
        laud = new char[3][3];

    }

    public boolean isKeegiVõitis() {
        return keegiVõitis;
    }


    // Uue tühja laua loomine
    public void tühiLaud() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                laud[i][j] = '-';
            }
        }
        System.out.println("Sisesta soovitava ruudu koordinaadid nii, et kõik numbrid 1-3, ");
        System.out.println("esimene number tähistab rida ja teine veergu Nt: 2 2 paneb märgi teise rea keskele.");

    }

    // Mängulaua hetkeseisu näitamine, mis peaks toimuma pärast iga käiku
    public void hetkeseis() {

        System.out.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(laud[i][j]+ " | ");
                    }
                    System.out.println();
            System.out.println("+---+---+---+");
        }

    }

    // Uue käigu koordinaadid
    public ArrayList<Integer> koordinaadid() {

        ArrayList<Integer> koordinaadid = new ArrayList<>();
        Scanner scan = new Scanner(System.in);


        String käik = scan.nextLine();
        String[] eraldiKäik = käik.split(" ");


        int rida = Integer.parseInt(eraldiKäik[0]) - 1;
        int veerg = Integer.parseInt(eraldiKäik[1]) - 1;


        koordinaadid.add(rida);
        koordinaadid.add(veerg);
        return koordinaadid;

    }

    // Uue käigu lisamine
    public void uusKäik(char mängija) {
        ArrayList<Integer> koordinaadid = koordinaadid();
        int rida = koordinaadid.get(0);
        int veerg = koordinaadid.get(1);

        // Mingi koordinaadi kontrollimine peaks olema (kas ruut on vaba)...
        if (laud[rida][veerg]=='-') {
            laud[rida][veerg] = mängija;
            käikudeArv++;
        }
        else {
            System.out.println("Ruut on täis! Sisesta uus koordinaat!");
            koordinaadid();
        }

//      Kontrollime kas viimase käiguga võideti mäng.

//       Kontrollime veergu

        for (int i = 0; i < dimensioon; i++) {
            if (laud[rida][i] != mängija)
                break;
            if (i == dimensioon-1){
                System.out.println("Mängija " + mängija + " on võitnud! Palju õnne! ");
//              Mängija.setVõitudeArv++;
                keegiVõitis = true;
                break;
            }

        }
//        Kontrollime rea
        for (int i = 0; i < dimensioon; i++) {
            if (laud[i][veerg] != mängija){
                break;
            }
            if (i == dimensioon-1){
                System.out.println("Mängija " + mängija + " on võitnud! Palju õnne! ");
//              Mängija.setVõitudeArv++;
                keegiVõitis = true;
                break;
            }
        }
        if (rida == veerg){
            for (int i = 0; i < dimensioon; i++) {
                if (laud[i][i] != mängija){
                    break;
                }
                if (i == dimensioon-1){
                    System.out.println("Mängija " + mängija + " on võitnud! Palju õnne! ");
//                  Mängija.setVõitudeArv++;
                    keegiVõitis = true;
                    break;
                }
            }
        }
//        teine diagonaal ehk kui rea ja veeru arv on alati v6rdne dimensioon-1'ga
        if (rida + veerg == dimensioon - 1){
            for (int i = 0; i < dimensioon; i++) {
                if (laud[i][(dimensioon - 1)-i] != mängija)
                    break;
                if (i == dimensioon -1){
                    System.out.println("Mängija " + mängija + " on võitnud! Palju õnne! ");
//                  mängija.setVõitudeArv++;
                    keegiVõitis = true;
                    break;
                }
            }
        }
//        Kontrollime, kas tegemist on viigiga
        if (käikudeArv == (Math.pow(dimensioon,2) -1)){
            System.out.println("Oi kui kahju, tegemist on viigiga!");
            keegiVõitis = true;
        }

    }
// puhastame ekraani
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



//    M2ngu voitmine


    // public Mängija mänguVõitmine()
    /* Võimalikud võitmislahendused.

     X-telje peal on üheksa lahendust. Need on siis näiteks
     1. tase; 1 rida täiesti täis, 2. rida täiesti täis või kolmas.
     Sama asi kordub kõikide tasemetega.
     9 tk


     Y- telje võiduvõimalused:
     1. tase; 1 veerg täiesti täis, 2. veerg täiesti täis või kolmas.
     Sama asi kordub kõikide tasemetega.
     9 tk
     */

}
