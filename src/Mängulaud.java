import java.util.ArrayList;
import java.util.Scanner;

public class Mängulaud {
    // FIXME: 14.03.18 MUUTUJAD PRIVAATSEKS!
    private char[][][] laud;

    public Mängulaud() {
        laud = new char[3][3][3];
    }

    // Uue tühja laua loomine
    public void tühiLaud() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    laud[i][j][k] = '-';
                }
            }
        }
    }

    // Mängulaua hetkeseisu näitamine, mis peaks toimuma pärast iga käiku
    // TODO: 14.03.18 Possible upgrade: Tasemed üksteise kõrvale, siis kulub vähem kõrgus-ruumi terminalis.
    public void hetkeseis() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Tase "+ (i + 1));
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    {
                        System.out.print(laud[i][j][k]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Uue käigu koordinaadid
    public ArrayList<Integer> koordinaadid() {

        ArrayList<Integer> koordinaadid = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Sisesta soovitava ruudu koordinaadid nii, et kõik numbrid 1-3, ");
        System.out.println("esimene number tähistab taset, teine rida ja kolmas veergu. Nt: 2 2 2 paneb märgi teise taseme keskele.");

        String käik = scan.nextLine();
        String[] eraldiKäik = käik.split(" ");

        int tase = Integer.parseInt(eraldiKäik[0]) - 1;
        int rida = 3 - Integer.parseInt(eraldiKäik[1]);
        int veerg = Integer.parseInt(eraldiKäik[2]) - 1;

        koordinaadid.add(tase);
        koordinaadid.add(rida);
        koordinaadid.add(veerg);
        return koordinaadid;
    }

    // Uue käigu lisamine
    public void uusKäik(char mängija) {
        ArrayList<Integer> koordinaadid = koordinaadid();
        int tase = koordinaadid.get(0);
        int rida = koordinaadid.get(1);
        int veerg = koordinaadid.get(2);
        // Mingi koordinaadi kontrollimine peaks olema (kas ruut on vaba)...
        if (laud[tase][rida][veerg]=='-') {
            laud[tase][rida][veerg] = mängija;
        }
        else {
            System.out.println("Ruut on täis! Sisesta uus koordinaat!");
            koordinaadid();
        }
    }

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

     Z- telje peal võiduvõimalused:
     1. tase 1 1  ning 2. tase 1 1 ning 3. tase 1 1 teevad kokku kogu võidu"rea!.
     Selliseid  võiduvõimalusi üksteise all on 9.
     9tk


     Järele jäävad diagonaalid.
     Igal tasemel endal on 2 diagonaalid x 3 = 6 diagonaali.
     6tk

     Igal Y telje tasemel (püstised) on samuti 6 diagonaali ühtepidi ning samuti veel 6 diagonaali teistpidi vaadates.
     12tk

     Järele jäävad vaid "3D diagonaalid". Ehk neid on 8 tk.
     4tk

     Kokku tuleb peale igat käiku kontrollida: 53 lahendust. */
}
