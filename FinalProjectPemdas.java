package com.mycompany.finalprojectpemdasjava;
import javax.swing.SwingUtilities;


public class FinalProjectPemdas {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}