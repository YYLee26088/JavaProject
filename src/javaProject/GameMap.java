package javaProject;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javaProject.Blocks.Type;

public class GameMap extends JPanel{

	private Blocks[][] boxes;
	private final int MAP_WIDTH=15;
	private final int MAP_HEIGHT=15;

	public GameMap() {
		this.setLayout(new GridLayout(15,15));
		this.setSize(637, 637);
		boxes= new Blocks[MAP_HEIGHT][MAP_WIDTH];
		for (int i=0; i<MAP_HEIGHT; i++) {
			for(int j=0; j<MAP_WIDTH; j++) {
				boxes[i][j] = new Blocks();
			}
		}
		for(int i=0; i<15; i++) {
			for(int j=0; j<15; j++) {
				if(i==0||i==MAP_WIDTH-1||j==0||j==MAP_HEIGHT-1||(i%2==0&&j%2==0)) {
					boxes[i][j].setType(Type.BRICK);
					boxes[i][j].setBlockIcon();
				}
				else {
					boxes[i][j].setType(Type.EMPTY);
				}
				this.add(boxes[i][j]);
			}
		}
		//�ʱ�ȭ ����

	}

	public JLabel getIndex(int x, int y){
		return boxes[x][y];
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame();

		frame.setSize(637, 637);
		frame.add(new GameMap());

		frame.setVisible(true);
	}
}