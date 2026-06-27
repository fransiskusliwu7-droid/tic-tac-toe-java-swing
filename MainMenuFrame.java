package com.mycompany.finalprojectpemdasjava;
import javax.swing.*;
import java.awt.*;

class MainMenuFrame extends JFrame {
    public MainMenuFrame(Player player) {
        setTitle("Main Menu - " + player.getUsername());
        setSize(300, 250); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); setLayout(new GridLayout(4, 1, 5, 5));
        JButton btnStart = new JButton("Start Game");
        JButton btnStat = new JButton("View My Statistics");
        JButton btnTop = new JButton("View Top 5 Scorers");
        JButton btnExit = new JButton("Exit");
        add(btnStart); add(btnStat); add(btnTop); add(btnExit);
        btnStart.addActionListener(e -> { new GameFrame(player).setVisible(true); this.dispose(); });
        btnStat.addActionListener(e -> new StatisticsFrame(player).setVisible(true));
        btnTop.addActionListener(e -> new TopScorersFrame().setVisible(true));
        btnExit.addActionListener(e -> System.exit(0));
    }
}