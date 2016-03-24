package com.gameoflife;

import java.awt.Color;

import com.gameoflife.controller.GameController;
import com.gameoflife.controller.GameControllerImpl;
import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;
import com.gameoflife.view.GameView;

public class Main {

	private static final int HIGHT = 15;
	private static final int WIDTH = 15; 
	private static final int TIME_INTERVAL = 1000;
	private static final String BOARD_NAME = "Game of Life";
	private static final Color BOARD_COLOR = Color.lightGray;
	
	private static final int CELL_SIZE = 20;
	private static final Color CELL_COLOR = Color.BLUE;
	
	public static void main(String[] args) {
		GameBoard gameBoard = new GameBoard(HIGHT, WIDTH, TIME_INTERVAL,BOARD_COLOR);
		gameBoard.setBoardName(BOARD_NAME);
		Cell cell = new Cell(CELL_SIZE, CELL_COLOR, WIDTH, HIGHT);
		GameController gameController = new GameControllerImpl();
		gameController.initializeCells(cell);
		GameView gameView = new GameView(gameBoard, cell, gameController);
		gameView.createPanel();
	}

}
