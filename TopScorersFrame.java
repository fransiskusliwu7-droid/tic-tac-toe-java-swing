package com.mycompany.finalprojectpemdasjava;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class TopScorersFrame extends JFrame {
    private PlayerService playerService = new PlayerService();
    public TopScorersFrame() {
        setTitle("Top 5 Scorers"); setSize(400, 200);
        setLocationRelativeTo(null);
        String[] columns = {"Username", "Wins", "Losses", "Draws", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Player p : playerService.getTopFives()) {
            model.addRow(new Object[]{p.getUsername(), p.getWins(), p.getLosses(), p.getDraws(), p.getScore()});
        }
        add(new JScrollPane(new JTable(model)));
    }
}