import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestTTT {
    // Mängija nime määramine
    static String mängijaNimi() {
        String nimi = JOptionPane.showInputDialog(
                null, "Sisesta nimi:", "Mängija nimi", JOptionPane.PLAIN_MESSAGE);
        if (nimi.equals("")) {
            throw new MängijaNimeErind("Sisend oli tühi. Sisesta uus nimi!");
        }
        return nimi;
    }

    // Tervituse sisse lugemine veebilehelt ja selle väljastamine
    static void tervitus(String fail) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(fail).openStream()))) {
            String rida = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (rida != null) {
                sb.append(rida+"\n");
                rida = br.readLine();
            }
            JFrame aken = new JFrame();
            JOptionPane.showMessageDialog(aken, sb, "TTT", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) throws Exception {
        // Tervitus
        tervitus("https://raw.githubusercontent.com/hvirro/oop/master/src/tervitus.txt");

        // Uued mängijad
        int nimeLugeja = 0;
        String[] nimed = new String[2];
        while (nimeLugeja != 2) {
            try {
                String nimi = mängijaNimi();
                nimed[nimeLugeja] = nimi;
                nimeLugeja++;
            }
            catch (MängijaNimeErind e) {
                JFrame aken = new JFrame();
                JOptionPane.showMessageDialog(aken, e.getMessage(), "Erind", JOptionPane.PLAIN_MESSAGE);
            }
        }
        Mängija mängija1 = new Mängija(nimed[0],0);
        Mängija mängija2 = new Mängija(nimed[1],0);

        // Tähise määramine mängijatele
        char[] tähised = {'X', 'O'};
        mängija1.setTähis(mängija1.tähis());
        if (mängija1.getTähis() == 'X') {
            mängija2.setTähis('O');
        }
        else {
            mängija2.setTähis('X');
        }

        if (mängija1.getPlayer() != null || mängija2.getPlayer() != null) {
            JFrame aken = new JFrame("TTT");
            aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aken.getContentPane().add(new TTT(mängija1, mängija2));
            aken.setBounds(0, 0, 600, 600);
            aken.setVisible(true);
            aken.setResizable(false);
        }
    }
}
