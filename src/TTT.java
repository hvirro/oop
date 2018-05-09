import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TTT extends JPanel {
    private JButton nupud[] = new JButton[9];
    private int käik = 0;

    // 3*3 mängulaud
    public TTT() {
        setLayout(new GridLayout(3,3));
        tühiLaud();
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
    }

    //
    private class nupuKuular implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Valitud nupp
            JButton valitudNupp = (JButton)e.getSource();
            if(käik%2 == 0)
                valitudNupp.setText("X");
            else
                valitudNupp.setText("O");

            if(keegiVõitis() == true) {
                JOptionPane.showConfirmDialog(null, "Mäng läbi!");
                tühiLaud();
            }

            if (viik() == true) {
                JOptionPane.showConfirmDialog(null, "Oi kui kahju, tegemist on viigiga!");
                tühiLaud();
            }

            käik++;
        }

        // Nupu naabri kontrollimine
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

        // Kontrollime, kas tegemist on viigiga ehk kui tehtud on 8 käiku, aga keegi ei ole veel võitnud
        public boolean viik() {
            if (käik == 8) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
