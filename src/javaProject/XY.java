package javaProject;
/*
 * 플레이어의 XY 좌표를 구하는 클래스
 */
public class XY {
	private int x=0;
	private int y=0;
	
	public XY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y=y;
	}
}
