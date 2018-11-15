package javaProject;

import java.awt.GridLayout;
import javax.swing.*;

public class GameMap extends JPanel{

	public GameMap() {

		this.setLayout(new GridLayout(15,15));
		this.setSize(637, 637);
		JLabel[][] boxes= new JLabel[15][15];
		for (int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				boxes[i][j] = new JLabel();
			}
		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(i==0||i==14||j==0||j==14||(i%2==0&&j%2==0))
					boxes[i][j].setIcon(new ImageIcon("images/box.png"));
				this.add(boxes[i][j]);
			}
		}
		//패널 초기화 내용

	}
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setVisible(true);

		frame.setSize(637, 637);
		frame.add(new GameMap());
	}
}