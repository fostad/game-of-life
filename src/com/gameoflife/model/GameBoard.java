package com.gameoflife.model;

import java.awt.Color;

public class GameBoard {

	private int hight;			//Number of cells in Y axis
	private int width;			//Number of cells in X axis
	private int timeInterval;	//Time intervals between patterns on the game board
	private Color color;		//Color of the game board in GUI
	private String boardName;	//Name of the GUI
	
	public GameBoard(int hight, int width, int timeInterval, Color color) {
		super();
		this.hight = hight;
		this.width = width;
		this.timeInterval = timeInterval;
		this.color = color;
	}
	
	public int getHight() {
		return hight;
	}
	public void setHight(int hight) {
		this.hight = hight;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
