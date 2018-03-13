public class TestMängulaud {
    public static char tähis() {
        char[] tähised = {'X', 'O'};
        int indeks = (int)Math.round((Math.random()*1));
        char mängija = tähised[indeks];
        return mängija;
    }
    
    public static void main(String[] args) {
        Mängulaud laud = new Mängulaud();
        // Tähise määramine
        char mängija1 = tähis();
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
