package javaProject;

public class Player extends Blocks{
	
	public enum State{
		MOVE_UP,
		MOVE_DOWN,
		MOVE_LEFT,
		MOVE_RIGHT,
		DIE
	}
	
	private State state;
//	private final int MAX_CAPACITY=10;
//	private final int MAX_POWER=5;

	public int life;
	public int bombPower;
	public int capacity;
	
	public Player(int life, int bp,int capacity) {
		new XY(1,1);
		this.state=State.MOVE_DOWN;
		this.setType(Type.PLAYER);
		this.life=life;
		this.bombPower=bp;
		this.capacity=capacity;
	}

	public Player() {
		this(2, 1, 1);
	}
	
	public void setState(State state) {
		this.state=state;
	}


}













