public class Mängija {
    private static int indeks;
    private char[] tähised;
    private char mängija;
    private String Player;
    private int mängeVõidetud = 0;

    public Mängija( String player, int mängeVõidetud) {
        Player = player;
        this.mängeVõidetud = mängeVõidetud;
    }

    public  int getIndeks() {
        return indeks;
    }

    public  void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public  int getMängeVõidetud() {
        return mängeVõidetud;
    }

    public void setMängeVõidetud(int mängeVõidetud) {
        this.mängeVõidetud = mängeVõidetud;
    }

    public char getMängija() {
        return mängija;
    }

    public String getPlayer() {
        return Player;
    }

    public  char tähis() {
        char[] tähised = {'X', 'O'};
        indeks = (int)Math.round((Math.random()*1));
        char mängija = tähised[indeks];
        return mängija;
    }
}
