import javax.swing.*;

public class TestTTT {
    static String mängijaNimi() {
        String nimi = JOptionPane.showInputDialog("Sisesta nimi:");
        if (nimi.equals("")) {
            throw new MängijaNimeErind("Sisend oli tühi. Sisesta uus nimi!");
        }
        return nimi;
    }

    public static void main(String[] args) {
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
