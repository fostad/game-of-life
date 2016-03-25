package com.gameoflife;

import java.awt.Color;

public class Main {

	private static final int BOARD_HIGHT = 15;
	private static final int BOARD_WIDTH = 15; 
	private static final int TIME_INTERVAL = 1000;
	private static final String BOARD_NAME = "Game of Life";
	private static final Color BOARD_COLOR = Color.lightGray;
	
	private static final int CELL_SIZE = 20;
	private static final Color CELL_COLOR = Color.BLUE;
	
	public static void main(String[] args) {
		GameOfLife gameOfLife = new GameOfLife(BOARD_HIGHT, BOARD_WIDTH, TIME_INTERVAL, BOARD_COLOR, CELL_SIZE, CELL_COLOR);
		gameOfLife.setBoardName(BOARD_NAME);
		gameOfLife.startGame();
	}

}
