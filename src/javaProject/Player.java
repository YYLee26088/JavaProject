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
	public final int MAX_CAPACITY=10;//�ִ� ��ź ���� ���� ���
	public final int MAX_POWER=5;//�ִ� �Ŀ� ���
	
	public int life;
	public int bombPower;
	public int capacity;
	

}
