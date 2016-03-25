package com.gameoflife.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gameoflife.controller.GameController;
import com.gameoflife.controller.GameControllerImpl;
import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public class ControllerTest {
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting Controller Test.");
	}
	
	@Test
	public void cellIsAliveTest() {
		GameControllerImpl gameControllerImpl = new GameControllerImpl();
		
		assertFalse(gameControllerImpl.cellIsAlive(true, 0));
		assertFalse(gameControllerImpl.cellIsAlive(true, 1));
		assertTrue(gameControllerImpl.cellIsAlive(true, 2));
		assertTrue(gameControllerImpl.cellIsAlive(true, 3));
		assertFalse(gameControllerImpl.cellIsAlive(true, 4));
		assertFalse(gameControllerImpl.cellIsAlive(true, 5));
		assertFalse(gameControllerImpl.cellIsAlive(true, 6));
		assertFalse(gameControllerImpl.cellIsAlive(true, 7));
		assertFalse(gameControllerImpl.cellIsAlive(true, 8));
		assertFalse(gameControllerImpl.cellIsAlive(false, 0));
		assertFalse(gameControllerImpl.cellIsAlive(false, 1));
		assertFalse(gameControllerImpl.cellIsAlive(false, 2));
		assertTrue(gameControllerImpl.cellIsAlive(false, 3));
		assertFalse(gameControllerImpl.cellIsAlive(false, 4));
		assertFalse(gameControllerImpl.cellIsAlive(false, 5));
		assertFalse(gameControllerImpl.cellIsAlive(false, 6));
		assertFalse(gameControllerImpl.cellIsAlive(false, 7));
		assertFalse(gameControllerImpl.cellIsAlive(false, 8));
				
	}
	
	@Test
	public void findFirstNeighbourTest() {
		GameControllerImpl gameControllerImpl = new GameControllerImpl();
		
		assertEquals(0,gameControllerImpl.findFirstNeighbor(0));
		assertEquals(0,gameControllerImpl.findFirstNeighbor(1));
		assertEquals(1,gameControllerImpl.findFirstNeighbor(2));
	}
	
	@Test
	public void findLastNeighbourTest() {
		GameControllerImpl gameControllerImpl = new GameControllerImpl();
		
		assertEquals(1,gameControllerImpl.findLastNeighbor(0,10));
		assertEquals(2,gameControllerImpl.findLastNeighbor(1,10));
		assertEquals(3,gameControllerImpl.findLastNeighbor(2,10));
		assertEquals(9,gameControllerImpl.findLastNeighbor(8,10));
		assertEquals(9,gameControllerImpl.findLastNeighbor(9,10));
		assertEquals(0,gameControllerImpl.findLastNeighbor(0,1));
		assertEquals(1,gameControllerImpl.findLastNeighbor(0,2));
		assertEquals(1,gameControllerImpl.findLastNeighbor(1,2));
	}
	
	@Test
	public void calculateAliveNeighbours() {
		GameControllerImpl gameControllerImpl = new GameControllerImpl();
	
		boolean[][] cells = new boolean[10][10];
		
		cells[3][1] = true;
		cells[4][1] = true;
		cells[5][1] = true;
		assertEquals(2,gameControllerImpl.calculateAliveNeighbors(cells, 10, 10, 4, 1));
		//TODO add more here
		//TODO test corners
	}
	
	@Test
	public void updateCellsTest() {
		GameBoard gameBoard = new GameBoard(15, 15, 1000,Color.LIGHT_GRAY);
		Cell cell = new Cell(5, Color.BLUE, 15, 15);
		GameController gameController = new GameControllerImpl();
		gameController.initializeCells(cell);
		
		assertTrue(cell.cellIsAlive(3, 1));
		assertTrue(cell.cellIsAlive(4, 1));
		assertTrue(cell.cellIsAlive(5, 1));
		assertTrue(cell.cellIsAlive(9, 1));
		assertTrue(cell.cellIsAlive(10, 1));
		assertTrue(cell.cellIsAlive(11, 1));
		
		assertFalse(cell.cellIsAlive(1, 1));
		assertFalse(cell.cellIsAlive(0, 1));
		assertFalse(cell.cellIsAlive(7, 1));
		
		assertTrue(cell.cellIsAlive(1, 3));
		assertTrue(cell.cellIsAlive(1, 4));
		assertTrue(cell.cellIsAlive(1, 5));
		
		assertTrue(cell.cellIsAlive(6, 3));
		assertTrue(cell.cellIsAlive(6, 4));
		assertTrue(cell.cellIsAlive(6, 5));
		
		assertTrue(cell.cellIsAlive(8, 3));
		assertTrue(cell.cellIsAlive(8, 4));
		assertTrue(cell.cellIsAlive(8, 5));
		
		assertTrue(cell.cellIsAlive(13, 3));
		assertTrue(cell.cellIsAlive(13, 4));
		assertTrue(cell.cellIsAlive(13, 5));
		
		assertTrue(cell.cellIsAlive(3, 6));
		assertTrue(cell.cellIsAlive(4, 6));
		assertTrue(cell.cellIsAlive(5, 6));
		assertTrue(cell.cellIsAlive(9, 6));
		assertTrue(cell.cellIsAlive(10, 6));
		assertTrue(cell.cellIsAlive(11, 6));
		
		assertTrue(cell.cellIsAlive(3, 8));
		assertTrue(cell.cellIsAlive(4, 8));
		assertTrue(cell.cellIsAlive(5, 8));
		assertTrue(cell.cellIsAlive(9, 8));
		assertTrue(cell.cellIsAlive(10, 8));
		assertTrue(cell.cellIsAlive(11, 8));
		
		assertTrue(cell.cellIsAlive(1, 9));
		assertTrue(cell.cellIsAlive(1, 10));
		assertTrue(cell.cellIsAlive(1, 11));
		
		assertTrue(cell.cellIsAlive(6, 9));
		assertTrue(cell.cellIsAlive(6, 10));
		assertTrue(cell.cellIsAlive(6, 11));
		
		assertTrue(cell.cellIsAlive(8, 9));
		assertTrue(cell.cellIsAlive(8, 10));
		assertTrue(cell.cellIsAlive(8, 11));
		
		assertTrue(cell.cellIsAlive(13, 9));
		assertTrue(cell.cellIsAlive(13, 10));
		assertTrue(cell.cellIsAlive(13, 11));
		
		assertTrue(cell.cellIsAlive(3, 13));
		assertTrue(cell.cellIsAlive(4, 13));
		assertTrue(cell.cellIsAlive(5, 13));
		assertTrue(cell.cellIsAlive(9, 13));
		assertTrue(cell.cellIsAlive(10, 13));
		assertTrue(cell.cellIsAlive(11, 13));
		
		gameController.updateCells(gameBoard, cell);
		gameController.updateCells(gameBoard, cell);
		
		
		assertTrue(cell.cellIsAlive(3, 1));
		assertTrue(cell.cellIsAlive(4, 1));
		assertTrue(cell.cellIsAlive(10, 1));
		assertTrue(cell.cellIsAlive(4, 2));
		assertTrue(cell.cellIsAlive(5, 2));
		assertTrue(cell.cellIsAlive(9, 2));
		assertTrue(cell.cellIsAlive(10, 2));
		
		gameController.updateCells(gameBoard, cell);
		
		assertTrue(cell.cellIsAlive(3, 1));
		assertTrue(cell.cellIsAlive(4, 1));
		assertTrue(cell.cellIsAlive(5, 1));
		assertTrue(cell.cellIsAlive(9, 1));
		assertTrue(cell.cellIsAlive(10, 1));
		assertTrue(cell.cellIsAlive(11, 1));
		
		assertFalse(cell.cellIsAlive(1, 1));
		assertFalse(cell.cellIsAlive(0, 1));
		assertFalse(cell.cellIsAlive(7, 1));
		
		assertTrue(cell.cellIsAlive(1, 3));
		assertTrue(cell.cellIsAlive(1, 4));
		assertTrue(cell.cellIsAlive(1, 5));
		
		assertTrue(cell.cellIsAlive(6, 3));
		assertTrue(cell.cellIsAlive(6, 4));
		assertTrue(cell.cellIsAlive(6, 5));
		
		assertTrue(cell.cellIsAlive(8, 3));
		assertTrue(cell.cellIsAlive(8, 4));
		assertTrue(cell.cellIsAlive(8, 5));
		
		assertTrue(cell.cellIsAlive(13, 3));
		assertTrue(cell.cellIsAlive(13, 4));
		assertTrue(cell.cellIsAlive(13, 5));
		
		assertTrue(cell.cellIsAlive(3, 6));
		assertTrue(cell.cellIsAlive(4, 6));
		assertTrue(cell.cellIsAlive(5, 6));
		assertTrue(cell.cellIsAlive(9, 6));
		assertTrue(cell.cellIsAlive(10, 6));
		assertTrue(cell.cellIsAlive(11, 6));
		
		assertTrue(cell.cellIsAlive(3, 8));
		assertTrue(cell.cellIsAlive(4, 8));
		assertTrue(cell.cellIsAlive(5, 8));
		assertTrue(cell.cellIsAlive(9, 8));
		assertTrue(cell.cellIsAlive(10, 8));
		assertTrue(cell.cellIsAlive(11, 8));
		
		assertTrue(cell.cellIsAlive(1, 9));
		assertTrue(cell.cellIsAlive(1, 10));
		assertTrue(cell.cellIsAlive(1, 11));
		
		assertTrue(cell.cellIsAlive(6, 9));
		assertTrue(cell.cellIsAlive(6, 10));
		assertTrue(cell.cellIsAlive(6, 11));
		
		assertTrue(cell.cellIsAlive(8, 9));
		assertTrue(cell.cellIsAlive(8, 10));
		assertTrue(cell.cellIsAlive(8, 11));
		
		assertTrue(cell.cellIsAlive(13, 9));
		assertTrue(cell.cellIsAlive(13, 10));
		assertTrue(cell.cellIsAlive(13, 11));
		
		assertTrue(cell.cellIsAlive(3, 13));
		assertTrue(cell.cellIsAlive(4, 13));
		assertTrue(cell.cellIsAlive(5, 13));
		assertTrue(cell.cellIsAlive(9, 13));
		assertTrue(cell.cellIsAlive(10, 13));
		assertTrue(cell.cellIsAlive(11, 13));

		//TODO test with different initial values
		//TODO test corners
		//TODO test with small board size
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finished Controller Test.");
	}
}
