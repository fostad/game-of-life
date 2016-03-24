package com.gameoflife.model;

import java.awt.Color;

public class GameBoard {

	private int hight;
	private int width;
	private int timeInterval;
	private Color color;
	private String boardName;
	
	public GameBoard(int hight, int width, int timeInterval, Color color) {
		super();
		this.hight = hight;
		this.width = width;
		this.timeInterval = timeInterval;
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
