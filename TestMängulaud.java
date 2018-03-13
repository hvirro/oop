public class TestMängulaud {
    public static void main(String[] args) {
        Mängulaud laud = new Mängulaud();
        char mängija1 = 'X';
        char mängija2 = 'O';

        laud.tühiLaud();
        laud.hetkeseis();
        laud.uusKäik(mängija1);
        laud.uusKäik(mängija1);
    }
}
