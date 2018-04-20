package com.mohamed.tictactoe.model;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private Player currentPlayer;

    public Game(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
        this.currentPlayer = players.get(0);
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
}
