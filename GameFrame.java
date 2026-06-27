package com.mycompany.finalprojectpemdasjava;
import javax.swing.*;
import java.awt.*;

class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService = new PlayerService();
    private GameLogic gameLogic = new GameLogic();
    private JButton[] buttons = new JButton[9];

    public GameFrame(Player player) {
        this.currentPlayer = player;
        setTitle("Tic-Tac-Toe"); setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            buttons[i].addActionListener(e -> handlePlayerMove(index));
            add(buttons[i]);
        }
    }
    private void handlePlayerMove(int index) {
        if (gameLogic.makeMove(index, 'X')) {
            buttons[index].setText("X");
            if (gameLogic.checkWinner('X')) { finishGame("WIN"); return; }
            if (gameLogic.isDraw()) { finishGame("DRAW"); return; }
            int compMove = gameLogic.computerMove();
            if (compMove != -1) {
                buttons[compMove].setText("O");
                if (gameLogic.checkWinner('O')) { finishGame("LOSE"); return; }
                if (gameLogic.isDraw()) { finishGame("DRAW"); return; }
            }
        }
    }
    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game result: " + result);
        Player updated = playerService.login(currentPlayer.getUsername(), "12345"); // Sesuaikan password
        new MainMenuFrame(updated != null ? updated : currentPlayer).setVisible(true);
        this.dispose();
    }
}