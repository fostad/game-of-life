package com.gameoflife.controller;

import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public interface GameController {
	
	public void initializeCells(Cell cell);
	public void updateCells(GameBoard gameBoard, Cell cell);
}
