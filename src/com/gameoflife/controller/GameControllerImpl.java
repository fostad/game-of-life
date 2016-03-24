package com.gameoflife.controller;

import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public class GameControllerImpl implements GameController{
		
	public void initializeCells(Cell cell) {
	
		cell.addCell(3, 1);
		cell.addCell(4, 1);
		cell.addCell(5, 1);
		cell.addCell(9, 1);
		cell.addCell(10, 1);
		cell.addCell(11, 1);
		
		cell.addCell(1, 3);
		cell.addCell(1, 4);
		cell.addCell(1, 5);
		
		cell.addCell(6, 3);
		cell.addCell(6, 4);
		cell.addCell(6, 5);
		
		cell.addCell(8, 3);
		cell.addCell(8, 4);
		cell.addCell(8, 5);
		
		cell.addCell(13, 3);
		cell.addCell(13, 4);
		cell.addCell(13, 5);
		
		cell.addCell(3, 6);
		cell.addCell(4, 6);
		cell.addCell(5, 6);
		cell.addCell(9, 6);
		cell.addCell(10, 6);
		cell.addCell(11, 6);
		
		cell.addCell(3, 8);
		cell.addCell(4, 8);
		cell.addCell(5, 8);
		cell.addCell(9, 8);
		cell.addCell(10, 8);
		cell.addCell(11, 8);
		
		cell.addCell(1, 9);
		cell.addCell(1, 10);
		cell.addCell(1, 11);
		
		cell.addCell(6, 9);
		cell.addCell(6, 10);
		cell.addCell(6, 11);
		
		cell.addCell(8, 9);
		cell.addCell(8, 10);
		cell.addCell(8, 11);
		
		cell.addCell(13, 9);
		cell.addCell(13, 10);
		cell.addCell(13, 11);
		
		cell.addCell(3, 13);
		cell.addCell(4, 13);
		cell.addCell(5, 13);
		cell.addCell(9, 13);
		cell.addCell(10, 13);
		cell.addCell(11, 13);
	}
	
	public void updateCells(GameBoard gameBoard, Cell cell) {
		boolean[][] cells = new boolean[gameBoard.getWidth()]
				[gameBoard.getHight()];
		
		boolean[][] tempCells = new boolean[gameBoard.getWidth()]
                [gameBoard.getHight()];
		
		cells = cell.getCells();
		int aliveNeighbours;
		
		for(int i = 0; i < gameBoard.getWidth(); i++) {
			for(int j = 0; j < gameBoard.getHight(); j++) {
				aliveNeighbours = calculateAliveNeighbours(cells, gameBoard.getWidth(), 
						gameBoard.getHight(), i,j);
				if(!cells[i][j]) {
					if(aliveNeighbours == 3)
						tempCells[i][j] = true; 
					else
						tempCells[i][j] = false; 
				} else {
					if((aliveNeighbours < 2) || (aliveNeighbours > 3))
						tempCells[i][j] = false; 
					else 
						tempCells[i][j] = true; 
				}
			}
		}
		
		cell.setCells(tempCells);
	}
	
	public int calculateAliveNeighbours(boolean[][] cells, int width, int hight, int column, int row) {
		
		int startX, startY;
		int endX, endY;
		int aliveNeighbours = 0;
		
		if(column > 0)
			startX = column - 1;
		else 
			startX = column + 1;
		
		if(column < width - 1)
			endX = column + 1;
		else
			endX = column - 1;
		
		if(row > 0)
			startY = row - 1;
		else 
			startY = row + 1;
		
		if(row < hight - 1)
			endY = row + 1;
		else
			endY = row - 1;
		
		for(int i = startX; i <= endX; i++) {
			for(int j = startY; j <= endY; j++) {
				if(((i != column) || (j != row)) && (cells[i][j] == true))
					aliveNeighbours++;
			}
		}

		return aliveNeighbours;
	}

}
