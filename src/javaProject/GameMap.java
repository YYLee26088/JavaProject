package javaProject;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javaProject.Blocks.Type;

public class GameMap extends JPanel{

	private Blocks[][] boxes;
	private final int MAP_WIDTH=15;
	private final int MAP_HEIGHT=15;
	private XY playerPoint;//플레이어의 위치를 저장할 변수

	public GameMap() {
		playerPoint=new XY(1,1);//초기 좌표는 (1,1)로 둔다
		this.setLayout(new GridLayout(15,15));//규칙적인 레이블 배치를 위해 grid layout으로 구현
		this.setSize(637, 637);
		boxes= new Blocks[MAP_HEIGHT][MAP_WIDTH];
		for (int i=0; i<MAP_HEIGHT; i++) {
			for(int j=0; j<MAP_WIDTH; j++) {
				boxes[i][j] = new Blocks();
			}
		}
		
		for(int i=0; i<MAP_HEIGHT; i++) {
			for(int j=0; j<MAP_WIDTH; j++) {
				if(i==0||i==MAP_HEIGHT-1||j==0||j==MAP_WIDTH-1||(i%2==0&&j%2==0)) {
					boxes[i][j].setType(Type.BRICK);
					boxes[i][j].setBlockIcon();
				}
				else {
					boxes[i][j].setType(Type.EMPTY);
				}
				this.add(boxes[i][j]);
			}
		}
		//초기화 내용
	}
	
	public Blocks[][] getMap(){
		return boxes;
	}
	
	public int getPx() {
		return playerPoint.getX();
	}
	public void setPx(int x) {
		this.playerPoint.setX(x);
	}
	
	public int getPy() {
		return playerPoint.getY();
	}
	public void setPy(int y) {
		this.playerPoint.setY(y);
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();

		frame.setSize(637, 637);
		frame.add(new GameMap());

		frame.setVisible(true);
	}
}