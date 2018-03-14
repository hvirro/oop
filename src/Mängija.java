public class Mängija {
    private static int indeks;
    private static char[] tähised;
    private char mängija;

    public Mängija(char[] tähised, char mängija) {
        this.tähised = tähised;
        this.mängija = mängija;
    }

    public static char tähis() {
        tähised = new char[]{'X', 'O'};
        indeks = (int)Math.round((Math.random()*1));
        char mängija = tähised[indeks];
        return mängija;
    }
}
