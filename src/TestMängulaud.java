public class TestMängulaud {
    public static void main(String[] args) {
        Mängulaud laud = new Mängulaud();
        // Tähise määramine
        char[] tähised = {'X', 'O'};
        Mängija mängija1 = new Mängija("Salme",0);
        Mängija mängija2 = new Mängija("Peedu",0);
        if (mängija1.tähis() == 'X') {
            mängija2.setIndeks('O');

        }
        else {
            mängija2.setIndeks('X');
        }

        laud.tühiLaud();
        while (mängija1.getMängeVõidetud() != 3 || mängija2.getMängeVõidetud() != 3) {
            while (!(laud.isKeegiVõitis())) {
                laud.hetkeseis();
                laud.uusKäik(mängija1.getMängija(), mängija1);
                laud.clearScreen();
                if (laud.isKeegiVõitis()) {
                    laud.hetkeseis();
                    break;
                }
                laud.hetkeseis();
                laud.uusKäik(mängija2.getMängija(), mängija2);
                laud.clearScreen();
            }
            System.out.println("Skoor on ");
            while (!(laud.isKeegiVõitis())) {
                laud.hetkeseis();
                laud.uusKäik(mängija1.getMängija(),mängija1);
                laud.clearScreen();
                if (laud.isKeegiVõitis()) {
                    laud.hetkeseis();
                    break;
                }
                laud.hetkeseis();
                laud.uusKäik(mängija2.getMängija(),mängija2);
                laud.clearScreen();
            }
            laud.tühiLaud();
        }
        System.out.println("Kolme mängu tulemusena osutus võitjaks:");
        if (mängija1.getMängeVõidetud() < mängija2.getMängeVõidetud()) System.out.println(mängija2.getPlayer());
        else System.out.println(mängija1.getPlayer());

    }
}
