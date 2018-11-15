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
				boxes[i][j].setIcon(new ImageIcon("images/box.png"));
				this.add(boxes[i][j]);
			}
		}
		//패널 초기화 내용

	}
}