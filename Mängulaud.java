import java.util.ArrayList;
import java.util.Scanner;

public class Mängulaud {
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
    public void hetkeseis() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Tase "+i);
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
        System.out.println("Sisesta tase (0, 1, 2)");
        int tase = scan.nextInt();
        while (!(tase < 3)) {
            System.out.println("Tase ei sobi! Sisesta uus!");
            tase = scan.nextInt();
        }
        System.out.println("Sisesta rida (0, 1, 2)");
        int rida = scan.nextInt();
        while (!(rida < 3)) {
            System.out.println("Rida ei sobi! Sisesta uus!");
            rida = scan.nextInt();
        }
        System.out.println("Sisesta veerg (0, 1, 2)");
        int veerg = scan.nextInt();
        while (!(veerg < 3)) {
            System.out.println("Veerg ei sobi! Sisesta uus!");
            veerg = scan.nextInt();
        }
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
}
