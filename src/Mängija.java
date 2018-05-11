public class Mängija {
    private char tähis;
    private String Player;
    private int mängeVõidetud = 0;

    public Mängija(String player, int mängeVõidetud) {
        this.Player = player;
        this.mängeVõidetud = mängeVõidetud;
    }

    public int getMängeVõidetud() {
        return mängeVõidetud;
    }

    public void setMängeVõidetud(int mängeVõidetud) {
        this.mängeVõidetud = mängeVõidetud;
    }

    public String getPlayer() {
        return Player;
    }

    public char getTähis() {
        return tähis;
    }

    public void setTähis(char tähis) {
        this.tähis = tähis;
    }

    // Meetod juhusliku tähise määramiseks mängijale
    public char tähis() {
        char[] tähised = {'X', 'O'};
        int indeks = (int)Math.round((Math.random()*1));
        char tähis = tähised[indeks];
        return tähis;
    }
}
