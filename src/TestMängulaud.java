// Programmi käivitamiseks tuleks sisestada konsoolis vastavas kaustas: java TestMängulaud

import java.util.Scanner;

public class TestMängulaud {
    public static void main(String[] args) throws Exception {
        // Uus mängulaua objekt
        Mängulaud laud = new Mängulaud();

        // Uued mängijad
        Scanner scan = new Scanner(System.in);
        System.out.println("Mängija 1 nimi:");
        String nimi1 = scan.nextLine();
        System.out.println("Mängija 2 nimi:");
        String nimi2 = scan.nextLine();
        Mängija mängija1 = new Mängija(nimi1,0);
        Mängija mängija2 = new Mängija(nimi2,0);

        // Tähise määramine mängijatele
        char[] tähised = {'X', 'O'};
        mängija1.setTähis(mängija1.tähis());
        if (mängija1.getTähis() == 'X') {
            mängija2.setTähis('O');
        }
        else {
            mängija2.setTähis('X');
        }

        // Tervituse ja mängu reeglite väljastamine
        System.out.println("Tere tulemast mängima trips-traps-trulli, mis kestab kolme võiduni!");
        System.out.println("Sisesta soovitud ruudu koordinaadid nii, et kõik numbrid on vahemikus 1-3, kusjuures ");
        System.out.println("esimene number tähistab rida ja teine veergu. Nt: 2 2 paneb tähise teise rea keskele.");

        // Tühi mängulaud
        laud.tühiLaud();

        // Mäng käib, kuni üks mängija saavutab kolmanda võidu
        while (true) {
            if (mängija1.getMängeVõidetud() == 3) break;
            if (mängija2.getMängeVõidetud() == 3) break;
            while (!laud.isKeegiVõitis()) {
                laud.hetkeseis();
                laud.uusKäik(mängija1.getTähis(), mängija1);
                laud.clearScreen();
                if (laud.isKeegiVõitis()) {
                    break;
                }
                laud.hetkeseis();
                laud.uusKäik(mängija2.getTähis(), mängija2);
                laud.clearScreen();
                if (laud.isKeegiVõitis()) {
                    break;
                }
            }
            // Skoori kuvamine
            System.out.println("Skoor on");
            System.out.println(mängija1.getMängeVõidetud() + " - " + mängija2.getMängeVõidetud());
            laud.setKeegiVõitis(false);
            laud.setKäikudeArv(0);

            // Laua taastamine
            laud.tühiLaud();
        }

        // Võitja väljastamine
        System.out.println("Kolme mängu tulemusena osutus võitjaks:");
        if (mängija1.getMängeVõidetud() < mängija2.getMängeVõidetud()) System.out.println(mängija2.getPlayer());
        else System.out.println(mängija1.getPlayer());
    }
}
