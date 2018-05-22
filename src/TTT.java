import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.*;

public class TTT extends JPanel {
    private JButton nupud[] = new JButton[9];
    private Mängija mängija1;
    private Mängija mängija2;
    private JFrame aken;
    private int käik = 0;

    // 3*3 mängulaud
    public TTT(Mängija mängija1, Mängija mängija2, JFrame aken) {
        setLayout(new GridLayout(3, 3));
        uusLaud();
        this.mängija1 = mängija1;
        this.mängija2 = mängija2;
        this.aken = aken;
    }

    // Uue laua loomine
    public void uusLaud() {
        for(int i = 0; i < 9; i++) {
            nupud[i] = new JButton();
            nupud[i].setText("");
            nupud[i].addActionListener(new nupuKuular());
            add(nupud[i]);
        }
    }

    // Laua tühjendamine
    public void tühiLaud() {
        for(int i = 0; i < 9; i++) {
            nupud[i].setText("");
        }
        käik = 0;
    }

    // Nupu tähise lisamine
    public void lisaTähis(JButton nupp, Mängija mängija) {
        nupp.setText(String.valueOf(mängija.getTähis()));
    }

    // Nupu kuular
    private class nupuKuular implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton valitudNupp = (JButton) e.getSource();
            // Kui tähis olemas, siis ei ole võimalik nupule vajutada
            try {
                if (!valitudNupp.getText().equals("")) {
                    throw new HõivatudNupuErind("Nupp on hõivatud! Vali uus!");
                }
                // Tähise määramine vastavalt käigu numbrile
                if(käik%2 == 0)
                    lisaTähis(valitudNupp, mängija1);
                else
                    lisaTähis(valitudNupp, mängija2);
            }
            catch (HõivatudNupuErind erind) {
                JFrame aken = new JFrame();
                JOptionPane.showMessageDialog(aken, erind.getMessage(), "Erind", JOptionPane.PLAIN_MESSAGE);
                käik = käik-1;
            }
            // Info võidu puhul
            if(keegiVõitis()) {
                if (käik%2 == 0) {
                    mängija1.setMängeVõidetud(mängija1.getMängeVõidetud()+1);
                    JOptionPane.showMessageDialog(
                            null,
                            "Mängija " + mängija1.getPlayer() +
                                    " on võitnud selle mängu! Palju õnne!" + "\n" + skoor(),
                            "Võit", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    mängija2.setMängeVõidetud(mängija2.getMängeVõidetud()+1);
                    JOptionPane.showMessageDialog(
                            null,
                            "Mängija " + mängija2.getPlayer() +
                                    " on võitnud selle mängu! Palju õnne!" + "\n" + skoor(),
                            "Võit", JOptionPane.INFORMATION_MESSAGE);
                }
                tühiLaud();
            }
            // Info viigi puhul
            if (viik()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Oi kui kahju, tegemist on viigiga!" + "\n" + skoor(),
                        "Viik", JOptionPane.INFORMATION_MESSAGE);
                tühiLaud();
            }
            // Võitja väljastamine ja akna ning programmi sulgemine
            if (mängija1.getMängeVõidetud() == 3 || mängija2.getMängeVõidetud() == 3) {
                try {
                    tulemus("tulemused.txt");
                }
                catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
                if (mängija1.getMängeVõidetud() == 3) {
                    JOptionPane.showMessageDialog(
                            aken,
                            "Kolme mängu tulemusena osutus võitjaks " + mängija1.getPlayer() + "!",
                            "Mäng läbi!", JOptionPane.PLAIN_MESSAGE);
                }
                else if (mängija2.getMängeVõidetud() == 3) {
                    JOptionPane.showMessageDialog(
                            aken,
                            "Kolme mängu tulemusena osutus võitjaks " + mängija2.getPlayer() + "!",
                            "Mäng läbi!", JOptionPane.PLAIN_MESSAGE);
                }
                aken.setVisible(false);
                aken.dispose();
                System.exit(0);
            }
            käik++;
        }

        // Nupu naabri tähise kontrollimine
        public boolean naabriKontroll(int n1, int n2) {
            if (nupud[n1].getText().equals(nupud[n2].getText()) && !nupud[n1].getText().equals("")) {
                return true;
            }
            else {
                return false;
            }
        }

        // Kontrollime, kas viimase käiguga võideti mäng
        public boolean keegiVõitis() {
            // Kontrollime rida
            if(naabriKontroll(0, 1) && naabriKontroll(1, 2)) {
                return true;
            }
            else if(naabriKontroll(3, 4) && naabriKontroll(4, 5)) {
                return true;
            }
            else if (naabriKontroll(6, 7) && naabriKontroll(7, 8)) {
                return true;
            }

            // Kontrollime veergu
            else if (naabriKontroll(0, 3) && naabriKontroll(3, 6)) {
                return true;
            }
            else if (naabriKontroll(1, 4) && naabriKontroll(4, 7)) {
                return true;
            }
            else if (naabriKontroll(2, 5) && naabriKontroll(5, 8)) {
                return true;
            }

            // Diagonaali kontrollimine
            else if (naabriKontroll(0, 4) && naabriKontroll(4, 8)) {
                return true;
            }
            else if (naabriKontroll(2, 4) && naabriKontroll(4, 6)) {
                return true;
            }
            else {
                return false;
            }
        }

        // Kontrollime, kas tegemist on viigiga ehk kui tehtud on 9 käiku, aga keegi ei ole veel võitnud
        public boolean viik() {
            if (käik == 9) {
                return true;
            }
            else {
                return false;
            }
        }

        // Skoori kuvamine
        public String skoor() {
            return "Skoor on " + mängija1.getMängeVõidetud() + " - " + mängija2.getMängeVõidetud() + ".";
        }

        // Mängu tulemuse kirjutamine faili
        public void tulemus(String fail) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fail, true))) {
                bw.write(
                        "Skoor: " + mängija1.getPlayer() + " " + mängija1.getMängeVõidetud() + " - " +
                                mängija2.getMängeVõidetud() + " " + mängija2.getPlayer() +
                                " Aeg: " + LocalDateTime.now());
                bw.newLine();
            }
        }
    }
}
