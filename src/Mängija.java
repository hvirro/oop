public class Mängija {
    private static int indeks;
    private char[] tähised;
    private char mängija;
    private int mängeVõidetud = 0;

    public Mängija(char[] tähised, char mängija, int mängeVõidetud) {
        this.tähised = tähised;
        this.mängija = mängija;
        this.mängeVõidetud = mängeVõidetud;
    }

    public static int getIndeks() {
        return indeks;
    }

    public static void setIndeks(int indeks) {
        Mängija.indeks = indeks;
    }

    public char[] getTähised() {
        return tähised;
    }

    public void setTähised(char[] tähised) {
        this.tähised = tähised;
    }

    public char getMängija() {
        return mängija;
    }

    public void setMängija(char mängija) {
        this.mängija = mängija;
    }

    public int getMängeVõidetud() {
        return mängeVõidetud;
    }

    public void setMängeVõidetud(int mängeVõidetud) {
        this.mängeVõidetud = mängeVõidetud;
    }

    public static char tähis() {
        char[] tähised = {'X', 'O'};
        indeks = (int)Math.round((Math.random()*1));
        char mängija = tähised[indeks];
        return mängija;
    }
}
