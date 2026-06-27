package com.mycompany.finalprojectpemdasjava;
import javax.swing.*;
import java.awt.*;

class StatisticsFrame extends JFrame {
    public StatisticsFrame(Player player) {
        setTitle("My Statistics"); setSize(250, 200);
        setLocationRelativeTo(null); setLayout(new GridLayout(4, 1));
        add(new JLabel(" Wins: " + player.getWins()));
        add(new JLabel(" Losses: " + player.getLosses()));
        add(new JLabel(" Draws: " + player.getDraws()));
        add(new JLabel(" Total Score: " + player.getScore()));
    }
}