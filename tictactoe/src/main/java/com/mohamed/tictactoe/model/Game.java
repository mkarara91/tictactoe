package com.mohamed.tictactoe.model;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private Difficulty difficulty;

    public Game(List<Player> players, Board board,Difficulty difficulty) {
        this.players = players;
        this.board = board;
        this.currentPlayer = players.get(0);
        this.difficulty = difficulty;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
