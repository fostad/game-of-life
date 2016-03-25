package com.gameoflife.model;

import java.awt.Color;

public class Cell {
	
	private int size; 			//size of a one cell in game board
	private Color color; 		//color of the alive cell
	private boolean[][] cells;  //current pattern of the board
	
	public Cell(int size, Color color, int Width, int hight) {
		this.size = size;
		this.color = color;
		this.cells = new boolean[Width][hight];
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean[][] getCells() {
		return cells;
	}

	public void setCells(boolean[][] cells) {
		this.cells = cells;
	}
	
	public boolean cellIsAlive(int column, int row) {
		return cells[column][row];
	}

	public void addCell(int column, int row) {
		cells[column][row] = true;
	}
	
	public void removeCell(int column, int row) {
		cells[column][row] = false;
	}
	
}
