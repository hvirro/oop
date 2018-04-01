import java.util.ArrayList;
import java.util.Scanner;

public class Mängulaud {
    private char[][] laud;
    private int käikudeArv = 0;
    private int dimensioon = 3;
    private boolean keegiVõitis = false;

    public void setKeegiVõitis(boolean keegiVõitis) {
        this.keegiVõitis = keegiVõitis;
    }

    public void setKäikudeArv(int käikudeArv) {
        this.käikudeArv = käikudeArv;
    }

    // 3*3 mängulaud
    public Mängulaud() {
        laud = new char[dimensioon][dimensioon];
    }

    // Võitja olemasolu tuvastamine
    public boolean isKeegiVõitis() {
        return keegiVõitis;
    }

    // Uue tühja laua loomine
    public void tühiLaud() {
        for (int i = 0; i < dimensioon; i++) {
            for (int j = 0; j < dimensioon; j++) {
                laud[i][j] = '-';
            }
        }
    }

    // Mängulaua hetkeseisu näitamine, mis toimub pärast iga käiku
    public void hetkeseis() {
        System.out.println("+---+---+---+");
        for (int i = 0; i < dimensioon; i++) {System.out.print("| ");
                for (int j = 0; j < dimensioon; j++) {
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
        // Sisendi teisendamine rea ja veeru numbriks
        int rida = Integer.parseInt(eraldiKäik[0]) - 1;
        int veerg = Integer.parseInt(eraldiKäik[1]) - 1;
        // Koordinaatide lisamine listi
        koordinaadid.add(rida);
        koordinaadid.add(veerg);
        return koordinaadid;
    }

    // Uue käigu lisamine
    public void uusKäik(char mängija, Mängija mängur) {
        ArrayList<Integer> koordinaadid = koordinaadid();
        int rida = koordinaadid.get(0);
        int veerg = koordinaadid.get(1);
        // Vaba ruudu olemasolu kontrollimine
        if (laud[rida][veerg] == '-') {
            laud[rida][veerg] = mängija;
            käikudeArv++;
        }
        else {
            System.out.println("Ruut on täis! Sisesta uus koordinaat!");
            koordinaadid();
        }

        // Kontrollime, kas viimase käiguga võideti mäng

        // Kontrollime veergu
        for (int i = 0; i < dimensioon; i++) {
            if (laud[rida][i] != mängija)
                break;
            if (i == dimensioon - 1){
                hetkeseis();
                System.out.println("Mängija " + mängur.getPlayer() + " on võitnud selle mängu! Palju õnne!");
                mängur.setMängeVõidetud(mängur.getMängeVõidetud()+1);
                keegiVõitis = true;
                break;
            }
        }

        // Kontrollime rida
        for (int i = 0; i < dimensioon; i++) {
            if (laud[i][veerg] != mängija){
                break;
            }
            if (i == dimensioon - 1) {
                hetkeseis();
                System.out.println("Mängija " + mängur.getPlayer() + " on võitnud selle mängu! Palju õnne!");
                mängur.setMängeVõidetud(mängur.getMängeVõidetud()+1);
                keegiVõitis = true;
                break;
            }
        }

        // Esimese diagonaali kontrollimine
        if (rida == veerg){
            for (int i = 0; i < dimensioon; i++) {
                if (laud[i][i] != mängija){
                    break;
                }
                if (i == dimensioon - 1){
                    hetkeseis();
                    System.out.println("Mängija " + mängur.getPlayer() + " on võitnud selle mängu! Palju õnne!");
                    mängur.setMängeVõidetud(mängur.getMängeVõidetud()+1);
                    keegiVõitis = true;
                    break;
                }
            }
        }

        // Teine diagonaal ehk kui rea ja veeru arv on võrdub dimensioon-1
        if (rida + veerg == dimensioon - 1){
            for (int i = 0; i < dimensioon; i++) {
                if (laud[i][(dimensioon - 1) - i] != mängija)
                    break;
                if (i == dimensioon - 1){
                    hetkeseis();
                    System.out.println("Mängija " + mängur.getPlayer() + " on võitnud selle mängu! Palju õnne!");
                    mängur.setMängeVõidetud(mängur.getMängeVõidetud()+1);
                    keegiVõitis = true;
                    break;
                }
            }
        }

        // Kontrollime, kas tegemist on viigiga ehk kui tehtud on 8 käiku, aga keegi ei ole veel võitnud
        if (käikudeArv == (Math.pow(dimensioon, 2) - 1)){
            System.out.println("Oi kui kahju, tegemist on viigiga!");
            keegiVõitis = true;
        }
    }

    // Puhastame ekraani
    public static void clearScreen() {
        //System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
