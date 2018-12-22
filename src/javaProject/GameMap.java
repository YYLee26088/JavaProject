package javaProject;

import javax.swing.ImageIcon;

import javaProject.Blocks.Type;

public class GameMap{

	private Integer[][] maze;
	private Blocks[][] block;//�迭 ����
	private final int MAP_WIDTH=25;
	private final int MAP_HEIGHT=15;
	private XY playerPoint;//�÷��̾��� ��ġ�� ������ ����

	public GameMap() {
		this.maze=new GetMaze().getData();
		playerPoint=new XY(1,0);//�ʱ� ��ǥ�� (1,1)�� �д�
		
		block= new Blocks[MAP_HEIGHT][MAP_WIDTH];
		
		for (int i=0; i<MAP_HEIGHT; i++) {
			for(int j=0; j<MAP_WIDTH; j++) {
				block[i][j] = new Blocks();
				if(maze[i][j]==2) {
					block[i][j].setType(Type.PLAYER);
					block[i][j].setIcon(new ImageIcon("images/character.png"));
				}
				
				else if(maze[i][j]==0) {
					block[i][j].setType(Type.BRICK);
					block[i][j].setIcon(new ImageIcon("images/brick.png"));
				}
				
				else {
					block[i][j].setType(Type.EMPTY);
				}
			}
		}
		
		//�ʱ�ȭ ����
	}
	
	public Blocks[][] getMap(){//������ �� ��ȯ
		return block;
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
	
}