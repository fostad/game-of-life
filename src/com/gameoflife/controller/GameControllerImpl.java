package com.gameoflife.controller;

import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public class GameControllerImpl implements GameController {
		
	//Initialize cells value to Pulsar pattern
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
	
	//Find the first neighbor of current cell in X or Y axis
	public int findFirstNeighbor(int currentPosition) {
		if(currentPosition > 0)
			return currentPosition - 1;
		else  //current cell is located at zero and the first neighbor is in same axis
			return currentPosition;
	}
	
	//Find the last neighbor of current cell in X or Y axis
	public int findLastNeighbor(int currentPosition, int lastPosition) {
		if(currentPosition < lastPosition -1)
			return currentPosition + 1;
		else  //current cell is located at last position and the last neighbor is 
			  //in same axis
			return currentPosition;
	}
	
	//Calculate number of alive neighbors 
	public int calculateAliveNeighbors(boolean[][] cells, int width, int hight, int column, int row) {
		
		int startX, startY;
		int endX, endY;
		int aliveNeighbours = 0;
		
		//First neighbor
		startX = findFirstNeighbor(column);
		startY = findFirstNeighbor(row);
		
		//Last neighbor
		endX = findLastNeighbor(column, width);
		endY = findLastNeighbor(row, hight);
		
		for(int i = startX; i <= endX; i++) {
			for(int j = startY; j <= endY; j++) {
				//if this cell is not the cell itself and is alive 
				if(((i != column) || (j != row)) && (cells[i][j] == true))
					aliveNeighbours++;
			}
		}

		return aliveNeighbours;
	}
	
	//Check if the cell would be alive in next generation
	public boolean cellIsAlive(boolean cellValue, int aliveNeighbours) {
		if(!cellValue) { 			 //if cell is dead
			if(aliveNeighbours == 3) //and have 3 alive neighbors
				return true; 		 //would be alive in next generation
			else
				return false; 		 //other wise would be dead
		} else {					 //if cell is alive and have 2 or 3 alive neighbors would
									 //be alive in next generation other wise would die
			if((aliveNeighbours < 2) || (aliveNeighbours > 3))
				return false; 
			else 
				return true; 
		}
	}
	
	//create next generation
	public void updateCells(GameBoard gameBoard, Cell cell) {
		boolean[][] cells = new boolean[gameBoard.getWidth()]
				[gameBoard.getHight()];
		
		boolean[][] tempCells = new boolean[gameBoard.getWidth()] 
                [gameBoard.getHight()];
		
		cells = cell.getCells();
		int aliveNeighbours;
		for(int i = 0; i < gameBoard.getWidth(); i++) {
			for(int j = 0; j < gameBoard.getHight(); j++) {
				//Calculate number of alive neighbors
				aliveNeighbours = calculateAliveNeighbors(cells,gameBoard.getWidth(),gameBoard.getHight(), i,j);
				//set new status of cell
				tempCells[i][j] = cellIsAlive(cells[i][j],aliveNeighbours);
			}
		}	
		//copy updated cell pattern to shared array to be used in view
		cell.setCells(tempCells);
	}

}
