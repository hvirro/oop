public class TestMängulaud {

    
    public static void main(String[] args) {
        Mängulaud laud = new Mängulaud();
        // Tähise määramine
        char mängija1 = Mängija.tähis();
        char mängija2;
        if (mängija1 == 'X') {
            mängija2 = 'O';
        }
        else {
            mängija2 = 'X';
        }

        laud.tühiLaud();
        laud.hetkeseis();
        laud.uusKäik(mängija1);
        laud.uusKäik(mängija1);
    }
}
