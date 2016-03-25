package com.gameoflife.controller;

import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public interface GameController {
	
	//Initialize cell values
	public void initializeCells(Cell cell);
	
	//Create next generation
	public void updateCells(GameBoard gameBoard, Cell cell);
}
