import javax.swing.*;

public class TestTTT {
    public static void main(String[] args) {
        JFrame aken = new JFrame("TTT");
        aken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aken.getContentPane().add(new TTT());
        aken.setBounds(0,0,600,600);
        aken.setVisible(true);
        aken.setResizable(false);
    }
}
