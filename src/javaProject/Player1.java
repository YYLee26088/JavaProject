package javaProject;

import javax.swing.JFrame;

public class Player1 extends JFrame{
	public Player1() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MovingPlayer());
		setVisible(true);
	}

	public static void main(String[] args) {
		Player1 p=new Player1();
	}
}
