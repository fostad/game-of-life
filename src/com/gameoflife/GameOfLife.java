package com.gameoflife;

import java.awt.Color;

import com.gameoflife.controller.GameController;
import com.gameoflife.controller.GameControllerImpl;
import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;
import com.gameoflife.view.GameView;

public class GameOfLife {

	private static final int BOARD_HIGHT_MIN = 2;
	private static final int BOARD_WIDTH_MIN = 2;
	private static final int CELL_SIZE_MIN = 4;
	private static final int CELL_SIZE_MAX = 20;
	private static final int TIME_INTERVAL_MIN = 500;
	private static final int TIME_INTERVAL_MAX = 10000;
	
	private int boardHight;
	private int boardWidth;
	private int timeInterval;
	private Color boardColor;
	private String boardName;
	
	private int cellSize;
	private Color cellColor;
	
	//Check properties of cell and board to be in reasonable range
	public void checkRanges(int boardHight, int boardWidth, int timeInterval, int cellSize){
	
		if(boardHight < BOARD_HIGHT_MIN) {
			System.out.println("Board hight out of range.");
			System.exit(1);
		}
		
		if(boardWidth < BOARD_WIDTH_MIN) {
			System.out.println("Board hight out of range.");
			System.exit(1);
		}
		
		if(cellSize < CELL_SIZE_MIN || cellSize > CELL_SIZE_MAX) {
			System.out.println("Cell size out of range.");
			System.exit(1);
		}
		
		if(timeInterval < TIME_INTERVAL_MIN || timeInterval > TIME_INTERVAL_MAX) {
			System.out.println("Time interval out of range.");
			System.exit(1);
		}
	}
	
	
	public GameOfLife(int boardHight, int boardWidth, int timeInterval, Color boardColor, int cellSize,
			Color cellColor) {
		super();
		checkRanges(boardHight, boardWidth, timeInterval, cellSize);	
		this.boardHight = boardHight;
		this.boardWidth = boardWidth;
		this.timeInterval = timeInterval;
		this.boardColor = boardColor;
		this.cellSize = cellSize;
		this.cellColor = cellColor;
	}

	public void startGame() {
		GameBoard gameBoard = new GameBoard(boardHight, boardWidth, timeInterval,boardColor);
		Cell cell = new Cell(cellSize, cellColor, boardWidth, boardHight);
		GameController gameController = new GameControllerImpl();
		gameController.initializeCells(cell);
		GameView gameView = new GameView(gameBoard, cell, gameController);
		gameView.createPanel();
	}

	public int getBoardHight() {
		return boardHight;
	}

	public void setBoardHight(int boardHight) {
		this.boardHight = boardHight;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Color getBoardColor() {
		return boardColor;
	}

	public void setBoardColor(Color boardColor) {
		this.boardColor = boardColor;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getCellSize() {
		return cellSize;
	}

	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}

	public Color getCellColor() {
		return cellColor;
	}

	public void setCellColor(Color cellColor) {
		this.cellColor = cellColor;
	}
	
	
}
