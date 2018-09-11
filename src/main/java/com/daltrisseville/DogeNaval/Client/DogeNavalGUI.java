package com.daltrisseville.DogeNaval.Client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DogeNavalGUI implements MouseListener, ActionListener {
	private final Color myGreen = new Color(63, 182, 63); // 51, 204, 51);
	private final Color myRed = new Color(255, 76, 76);// 255, 51, 0);
	private final Color myYellow = new Color(255, 211, 0);// 189, 145, 15);
	private final Color myGray = new Color(57, 49, 49);// 121, 134, 134);
	private final Color myBlue = new Color(3, 201, 169);
	private final Color myWhite = new Color(236, 240, 241);

	int test = 0;

	GenericBoard board;

	JFrame frame = new JFrame("DogeNavalClient");
	JPanel container = new JPanel();
	JPanel firstPage = new JPanel();
	JPanel secondPage = new JPanel();

	JPanel secondPage_top = new JPanel();
	BoardPanel boardPanel;

	JButton buttonOne = new JButton("Switch to second panel/workspace");
	JButton buttonSecond = new JButton("Switch to first panel/workspace");
	JButton buttonTest = new JButton("Test");

	CardLayout cl = new CardLayout();
	
	
	public DogeNavalGUI() {

		initGUI();
		
		
	}

	public void initGUI() {
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setSize(new Dimension(500, 770));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container.setLayout(cl);
		secondPage.setLayout(new BorderLayout());

		board = new GenericBoard();
		boardPanel = new BoardPanel(board);

		firstPage.add(buttonOne);
		secondPage_top.add(buttonSecond);
		secondPage_top.add(buttonTest);

		firstPage.setBackground(myGreen);
		secondPage_top.setBackground(myGray);

		secondPage.add(secondPage_top, BorderLayout.NORTH);
		secondPage.add(boardPanel, BorderLayout.CENTER);

		container.add(firstPage, "1");
		container.add(secondPage, "2");
		cl.show(container, "1");

		buttonOne.setActionCommand("1");
		buttonSecond.setActionCommand("2");
		buttonTest.setActionCommand("3");
		buttonOne.addActionListener(this);
		buttonSecond.addActionListener(this);
		buttonTest.addActionListener(this);

		frame.add(container);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		boardPanel.addMouseListener(this);

		// test
		updateBoard(new GenericBoard());

	}

	public void updateBoard(GenericBoard newBoard) {
		boardPanel.setBoard(newBoard);

		boardPanel.updateUI();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "1":
			cl.show(container, "2");
			break;
		case "2":

			cl.show(container, "1");

			break;
		case "3":
			// Tests
			boardPanel.getBoard().getTiles()[test][test].setTileType(TileType.Miss);
			test++;
			updateBoard(boardPanel.getBoard());
			break;
		default:
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " - " + e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
