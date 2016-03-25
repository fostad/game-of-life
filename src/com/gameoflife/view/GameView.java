package com.gameoflife.view;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.gameoflife.controller.GameController;
import com.gameoflife.model.Cell;
import com.gameoflife.model.GameBoard;

public class GameView extends JPanel {

	private static final long serialVersionUID = -7326749366227765977L;
	
	private GameBoard gameBoard;
	private Cell cell;
	private GameController gameController;
	private Timer timer;
	private JButton pauseButton;
	private BoardPanel boardPanel;
	
	public GameView(GameBoard gameBoard, Cell cell, GameController gameController) {
		this.gameBoard = gameBoard;
		this.cell = cell;
		this.gameController = gameController;
	}

	public void createPanel() {
		JFrame mainFrame = new JFrame();
		JPanel mainPanel = new JPanel(new GridLayout());
		boardPanel = new BoardPanel(gameBoard, cell);
		JPanel controlPanel = new JPanel(new GridLayout());
		pauseButton = new JButton("Pause");
		
		pauseButton.addActionListener(new ButtonActionListener());
		controlPanel.add(pauseButton);
		mainPanel.add(boardPanel);
		mainPanel.add(controlPanel);
		if(gameBoard.getBoardName() != null)
			mainFrame.setTitle(gameBoard.getBoardName());
		mainFrame.setContentPane(mainPanel);
		mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		//Next pattern timer
		timer = new Timer(gameBoard.getTimeInterval(), new TimerActionListener());
		timer.setRepeats(true);
		timer.start();
	}
	
	class TimerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//create next generation
			gameController.updateCells(gameBoard, cell);
			//update the game board
			boardPanel.repaint();
		}
		
	} 
	
	class ButtonActionListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {	
			//If the pressed button label is pause stop the timer otherwise start it
			//Toggle the button text 
			if(pauseButton.getText().equals("Pause")) {
				timer.stop();
				pauseButton.setText("Continue");
			} else {
				timer.start();
				pauseButton.setText("Pause");
			}
		}
		
	}
 
}
