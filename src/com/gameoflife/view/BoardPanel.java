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
	
	public void drawLines(Graphics g) {
		
		int cellSize = cell.getSize();
		
		for(int i = 0; i <= gameBoard.getWidth(); i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, cellSize * gameBoard.getWidth());
        }
        
		for(int i = 0; i <= gameBoard.getHight(); i++) {
			g.drawLine(0, i * cellSize, cellSize * gameBoard.getHight(), i * cellSize);
        }
	}
	
	public void drawCells(Graphics g) {
		
		int cellSize = cell.getSize();
		
		synchronized(this) {
			for(int i = 0; i < gameBoard.getWidth(); i++) {
				for(int j = 0; j < gameBoard.getHight(); j++) {
					if(cell.getCell(i, j)) {
						g.setColor(cell.getColor());
						g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
					}
				}
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Dimension d = new Dimension(cell.getSize() * gameBoard.getWidth() + 1,
        		cell.getSize() * gameBoard.getHight() + 1);
         
        setSize(d);
        setBackground(gameBoard.getColor());
        drawLines(g);
        drawCells(g);
      
	}

}
