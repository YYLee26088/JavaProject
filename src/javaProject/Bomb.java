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

    
    //������
	public Bomb(int power, float countDown) {
		this.power=power;
		this.countDown=countDown;
		state=State.NORMAL;//�ʱ� ���´� ���������
	}
	
	public Bomb() {//�⺻ ��ź ��(�������� ���� ������ ��)
		this(1,3.0f);
	}
	
	public Bomb(int power) {//�Ŀ� �� �������� �Ծ��� ���� ��ź
        this(power, 2.0f);
    }
	
	public void setMove(Bomb.State state) {//��ź�� ����������� �������� ������
        this.state = state;
    }

}
