import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestTTT {
    static String mängijaNimi() {
        String nimi = JOptionPane.showInputDialog("Sisesta nimi:");
        if (nimi.equals("")) {
            throw new MängijaNimeErind("Sisend oli tühi. Sisesta uus nimi!");
        }
        return nimi;
    }

    static void tervitus(String fail) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(fail).openStream()))) {
            String rida = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (rida != null) {
                sb.append(rida+"\n");
                rida = br.readLine();
            }
            JFrame aken = new JFrame();
            JOptionPane.showMessageDialog(aken, sb, null, JOptionPane.PLAIN_MESSAGE);
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
                JOptionPane.showMessageDialog(aken, e.getMessage());
            }
        }

        Mängija mängija1 = new Mängija(nimed[0],0);
        Mängija mängija2 = new Mängija(nimed[1],0);

        if (mängija1.getPlayer() != null || mängija2.getPlayer() != null) {
            JFrame aken = new JFrame("TTT");
            aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aken.getContentPane().add(new TTT());
            aken.setBounds(0, 0, 600, 600);
            aken.setVisible(true);
            aken.setResizable(false);
        }
    }
}
