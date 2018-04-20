package com.mohamed.tictactoe.model;

public class Player {

	private int id;
	private char symbol;
	private PlayerType type;
	public Player(int id, char symbol, PlayerType type){
		this.id = id;
		this.symbol = symbol;
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public PlayerType getType() {
		return type;
	}
	public void setType(PlayerType type) {
		this.type = type;
	}
	
	
}
