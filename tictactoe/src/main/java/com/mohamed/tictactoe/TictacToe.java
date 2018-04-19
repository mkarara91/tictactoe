package com.mohamed.tictactoe;

import java.util.Scanner;

import model.Player;
import model.PlayerType;

public class TictacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to TicTacToe");
		System.out.println("please enter symbol for player 1:");
		char player1Symbol = sc.next().charAt(0);
		Player player1 = new Player(1, player1Symbol, PlayerType.Human);
		System.out.println("please enter symbol for player 2:");
		char player2Symbol = sc.next().charAt(0);
		Player player2 = new Player(2, player2Symbol, PlayerType.Human);
		
	}

}
