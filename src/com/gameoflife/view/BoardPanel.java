package com.gameoflife.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public class BoardPanel extends JPanel {
	

	private static final long serialVersionUID = 4698821056039497431L;
	
	private GameBoard gameBoard;
	private Cell cell;
	
	public BoardPanel(GameBoard gameBoard, Cell cell){
		super();
		this.gameBoard = gameBoard;
		this.cell = cell;
	}
	
	//Draw horizontal and vertical lines in the GUI to create matrix of cells
	public void drawLines(Graphics g) {
		
		int cellSize = cell.getSize();
		
		//Y axis
		for(int i = 0; i <= gameBoard.getWidth(); i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, cellSize * gameBoard.getWidth());
        }
        
		//X axis
		for(int i = 0; i <= gameBoard.getHight(); i++) {
			g.drawLine(0, i * cellSize, cellSize * gameBoard.getHight(), i * cellSize);
        }
	}
	
	//Color alive cells
	public void drawCells(Graphics g) {
		
		int cellSize = cell.getSize();
		
		//TODO I am not sure if we need to synchronize like this or JAVA take care of this
		synchronized(this) {
			g.setColor(cell.getColor());
			for(int i = 0; i < gameBoard.getWidth(); i++) {
				for(int j = 0; j < gameBoard.getHight(); j++) {
					if(cell.cellIsAlive(i, j)) { //if the cell is alive color it in the board
						g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
					}
				}
			}
		}
	}
	
	//paint GUI
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Dimension d = new Dimension(cell.getSize() * gameBoard.getWidth() + 1,
        		cell.getSize() * gameBoard.getHight() + 1);
         
        setSize(d);							 //Set size of the board panel
        setBackground(gameBoard.getColor()); //Set background color of the board panel
        drawLines(g);						 //Draw lines
        drawCells(g);						 //Color alive cells
      
	}

}
