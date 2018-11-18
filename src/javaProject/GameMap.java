package javaProject;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javaProject.Blocks.Type;

public class GameMap extends JPanel{

	private Blocks[][] boxes;

	public GameMap() {
		this.setLayout(new GridLayout(15,15));
		this.setSize(637, 637);
		boxes= new Blocks[15][15];
		for (int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				boxes[i][j] = new Blocks();
			}
		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(i==0||i==14||j==0||j==14||(i%2==0&&j%2==0)) {
					boxes[i][j].setType(Type.BRICK);
					boxes[i][j].setBlockIcon();
				}
				else {
					boxes[i][j].setType(Type.EMPTY);
					boxes[i][j].setBlockIcon();
				}
				this.add(boxes[i][j]);
			}
		}
		//초기화 내용

	}

	public JLabel getIndex(int x, int y){
		return boxes[x][y];
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame();

		frame.setSize(637, 640);
		frame.add(new GameMap());

		frame.setVisible(true);
	}
}