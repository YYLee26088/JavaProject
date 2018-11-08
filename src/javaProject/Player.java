package javaProject;

public class Player {
	
	public enum State{
		MOVE_UP,
		MOVE_DOWN,
		MOVE_LEFT,
		MOVE_RIGHT,
		DIE
	}
	
	public State state;
	public final int MAX_CAPACITY=10;//최대 폭탄 생산 개수 상수
	public final int MAX_POWER=5;//최대 파워 상수
	
	public int life;
	public int bombPower;
	public int capacity;
	

}
