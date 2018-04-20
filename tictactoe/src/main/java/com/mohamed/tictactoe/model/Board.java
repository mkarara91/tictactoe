package com.mohamed.tictactoe.model;

public class Board {
	private Character[][] cells;
	private int size;
	
	//create a size*size board
	public Board(int size){
		this.size = size;
		cells = new Character[size][size];
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				cells[i][j] = '-';
			}
		}
	}

	public Character[][] getCells() {
		return cells;
	}

	public void setCells(Character[][] cells) {
		this.cells = cells;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
