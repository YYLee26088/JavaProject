package javaProject;

import javax.swing.ImageIcon;

import javaProject.Blocks.Type;

public class GameMap{

	private Blocks[][] boxes;//�迭 ����
	private final int MAP_WIDTH=15;
	private final int MAP_HEIGHT=15;
	private XY playerPoint;//�÷��̾��� ��ġ�� ������ ����

	public GameMap() {
		playerPoint=new XY(1,1);//�ʱ� ��ǥ�� (1,1)�� �д�
		
		boxes= new Blocks[MAP_HEIGHT][MAP_WIDTH];
		
		for (int i=0; i<MAP_HEIGHT; i++) {
			for(int j=0; j<MAP_WIDTH; j++) {
				
				boxes[i][j] = new Blocks();
				if(i==playerPoint.getY()&&j==playerPoint.getX()) {
					boxes[i][j].setType(Type.PLAYER);
					boxes[i][j].setIcon(new ImageIcon("images/character.png"));
				}
				
				
				else if(i==0||i==MAP_HEIGHT-1||j==0||j==MAP_WIDTH-1||(i%2==0&&j%2==0)) {
					boxes[i][j].setType(Type.BRICK);
					boxes[i][j].setIcon(new ImageIcon("images/brick.png"));
				}
				else {
					boxes[i][j].setType(Type.EMPTY);
					boxes[i][j].setIcon(new ImageIcon("images/floor.png"));
					
				}
			}
		}
		
		//�ʱ�ȭ ����
	}
	
	public Blocks[][] getMap(){//������ �� ��ȯ
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
	
	public String getPoint() {
		return "�÷��̾� ��ǥ ("+this.playerPoint.getY()+","+this.playerPoint.getX()+")";
	}
	
}