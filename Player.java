package com.mycompany.finalprojectpemdasjava;

class Player {
    private int id, wins, losses, draws, score;
    private String username;

    public Player(int id, String username, int wins, int losses, int draws, int score) {
        this.id = id; this.username = username;
        this.wins = wins; this.losses = losses;
        this.draws = draws; this.score = score;
    }
    public int getId() { return id; }
    public String getUsername() { return username; }
    public int getWins() { return wins; }
    public int getLosses() { return losses; }
    public int getDraws() { return draws; }
    public int getScore() { return score; }
}