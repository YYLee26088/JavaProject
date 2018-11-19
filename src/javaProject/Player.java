package javaProject;

import javax.swing.ImageIcon;

public class Player extends Blocks{
	public enum State{
		MOVE_UP,
		MOVE_DOWN,
		MOVE_LEFT,
		MOVE_RIGHT,
		DIE
	}

	public State state;
	public final int MAX_CAPACITY=10;
	public final int MAX_POWER=5;

	public int life;
	public int bombPower;
	public int capacity;

	public Player(int life, int bp,int capacity) {
		this.state=State.MOVE_DOWN;
		this.life=life;
		this.bombPower=bp;
		this.capacity=capacity;
	}

	public Player() {
		this(2, 1, 1);
	}

	public void setPlayerIcon() {
		switch(this.state) {
		case MOVE_UP:
			this.setIcon(new ImageIcon(""));
		case MOVE_LEFT:
		case MOVE_RIGHT:
		case DIE:
			break;
		default:

		}
	}


}













