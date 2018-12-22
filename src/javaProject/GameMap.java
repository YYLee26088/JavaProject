package javaProject;

import javax.swing.ImageIcon;

import javaProject.Blocks.Type;

public class GameMap{

	private Integer[][] maze;
	private Blocks[][] block;//배열 선언
	private final int MAP_WIDTH=25;
	private final int MAP_HEIGHT=15;
	private XY playerPoint;//플레이어의 위치를 저장할 변수

	public GameMap() {
		this.maze=new GetMaze().getData();
		playerPoint=new XY(1,0);//초기 좌표는 (1,1)로 둔다
		
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
		
		//초기화 내용
	}
	
	public Blocks[][] getMap(){//생성된 맵 반환
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