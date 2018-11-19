package javaProject;

public class Bomb {
	
	public enum State{//���� ��ź�� ����
		NORMAL,//�������
        EXPLODING//����
	}
	
	//��ź ��ü�� �Ӽ�
	public float countDown;//ī��Ʈ�ٿ�
    public State state;//����
    public int power;//��ź ����  
    
	public Bomb(int power, float countDown) {
		this.power=power;
		this.countDown=countDown;
		state=State.NORMAL;
	}
	
	public Bomb() {
		this(1,3.0f);
	}
	
	public Bomb(int power) {
        this(power, 2.0f);
    }
	
	public void setMove(Bomb.State state) {
        this.state = state;
    }

}
