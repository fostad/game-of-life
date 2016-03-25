package com.gameoflife.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gameoflife.model.Cell;

public class CellTest {
	private static final int CELL_SIZE = 20;
	private static final Color CELL_COLOR = Color.BLUE;
	private static final int BOARD_HIGHT = 15;
	private static final int BOARD_WIDTH = 15; 
	private static Cell cell;
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Starting Cell Test.");
		cell = new Cell(CELL_SIZE,CELL_COLOR,BOARD_HIGHT,BOARD_WIDTH);
	}
	
	@Test
	public void testCellSize() {
		assertEquals(CELL_SIZE,cell.getSize());
		cell.setSize(30);
		assertEquals(30,cell.getSize());
	}
	
	@Test
	public void testCellColor() {
		assertEquals(CELL_COLOR,cell.getColor());
		cell.setColor(Color.RED);
		assertEquals(Color.RED,cell.getColor());
	}
	
	@Test
	public void testAddCell() {
		for(int i = 0; i < BOARD_WIDTH; i++) {
			for(int j = 0; j < BOARD_HIGHT; j++) {
				cell.addCell(i,j);
				assertTrue(cell.cellIsAlive(i, j));
			}
		}
	}
	
	@Test
	public void testRemoveCell() {
		for(int i = 0; i < BOARD_WIDTH; i++) {
			for(int j = 0; j < BOARD_HIGHT; j++) {
				cell.removeCell(i,j);
				assertFalse(cell.cellIsAlive(i, j));		
			}
		}
	}
	
	@Test
	public void testCellMatrix() {
		boolean[][] cells = new boolean[BOARD_WIDTH][BOARD_HIGHT];
		for(int i = 0; i < BOARD_WIDTH; i++) {
			for(int j = 0; j < BOARD_HIGHT; j++) {
				if(Math.random()*100 < 50)
					cells[i][j] = true;
			}
		}
		
		cell.setCells(cells);
		assertArrayEquals(cells, cell.getCells());
	}
	
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Finished Cell Test.");
	}
}
