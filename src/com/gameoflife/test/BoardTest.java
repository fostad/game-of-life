package com.gameoflife.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gameoflife.model.GameBoard;

public class BoardTest {
	
	private static final int BOARD_HIGHT = 15;
	private static final int BOARD_WIDTH = 15; 
	private static final int TIME_INTERVAL = 1000;
	private static final String BOARD_NAME = "Game of Life";
	private static final Color BOARD_COLOR = Color.lightGray;
	private static GameBoard gameBoard;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting Game Board Test.");
		gameBoard = new GameBoard(BOARD_HIGHT, BOARD_WIDTH, TIME_INTERVAL, BOARD_COLOR);
		gameBoard.setBoardName(BOARD_NAME);
	}
	
	@Test
	public void testBoardHight(){
		assertEquals(BOARD_HIGHT,gameBoard.getHight());
		gameBoard.setHight(45);
		assertEquals(45,gameBoard.getHight());
	}
	
	@Test
	public void testBoardWidth(){
		assertEquals(BOARD_WIDTH,gameBoard.getWidth());
		gameBoard.setWidth(56);
		assertEquals(56,gameBoard.getWidth());
	}
	
	@Test
	public void testTimeInterval(){
		assertEquals(TIME_INTERVAL,gameBoard.getTimeInterval());
		gameBoard.setTimeInterval(2000);
		assertEquals(2000,gameBoard.getTimeInterval());
	}
	
	@Test
	public void testColor(){
		assertEquals(BOARD_COLOR,gameBoard.getColor());
		gameBoard.setColor(Color.green);
		assertEquals(Color.green,gameBoard.getColor());
	}
	
	@Test
	public void testBoardName(){
		assertEquals(BOARD_NAME,gameBoard.getBoardName());
		gameBoard.setBoardName("Fatemeh");
		assertEquals("Fatemeh",gameBoard.getBoardName());
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finished Game Board Test.");
	}

}
