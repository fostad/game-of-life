package com.gameoflife.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gameoflife.GameOfLife;


public class TopModelTest {

	private static final int BOARD_HIGHT = 15;
	private static final int BOARD_WIDTH = 15; 
	private static final int TIME_INTERVAL = 1000;
	private static final Color BOARD_COLOR = Color.lightGray;
	
	private static final int CELL_SIZE = 20;
	private static final Color CELL_COLOR = Color.BLUE;
	
	private static GameOfLife gameOfLife;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting Top Model Test.");
		gameOfLife = new GameOfLife(BOARD_HIGHT, BOARD_WIDTH, TIME_INTERVAL, BOARD_COLOR, CELL_SIZE, CELL_COLOR);
	}
	
	@Test
	public void boardHightTest() {
		assertEquals(BOARD_HIGHT, gameOfLife.getBoardHight());
		gameOfLife.setBoardHight(7);
		assertEquals(7, gameOfLife.getBoardHight());
	}
	
	@Test
	public void boardWidthTest() {
		assertEquals(BOARD_WIDTH, gameOfLife.getBoardWidth());
		gameOfLife.setBoardWidth(8);
		assertEquals(8, gameOfLife.getBoardWidth());
	}
	
	@Test
	public void timeIntervalTest() {
		assertEquals(TIME_INTERVAL, gameOfLife.getTimeInterval());
		gameOfLife.setTimeInterval(769);
		assertEquals(769, gameOfLife.getTimeInterval());
	}
	
	@Test
	public void boardColorTest() {
		assertEquals(BOARD_COLOR, gameOfLife.getBoardColor());
		gameOfLife.setBoardColor(Color.WHITE);
		assertEquals(Color.WHITE, gameOfLife.getBoardColor());
	}
	
	@Test
	public void cellSizeTest() {
		assertEquals(CELL_SIZE, gameOfLife.getCellSize());
		gameOfLife.setCellSize(5);
		assertEquals(5, gameOfLife.getCellSize());
	}
	
	@Test
	public void cellColoTest() {
		assertEquals(CELL_COLOR, gameOfLife.getCellColor());
		gameOfLife.setCellColor(Color.BLACK);
		assertEquals(Color.BLACK, gameOfLife.getCellColor());
	}
	
	@Test
	public void boardNameTest() {
		gameOfLife.setBoardName("Life game");
		assertEquals("Life game", gameOfLife.getBoardName());
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finished Top Model Test.");
	}
}
