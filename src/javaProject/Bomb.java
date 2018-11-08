package javaProject;

public class Bomb {
	
	public enum State{//현재 폭탄의 상태
		NORMAL,//보통상태
        EXPLODING//터짐
	}
	
	//폭탄 객체의 속성
	public float countDown;//카운트다운
    public State state;//상태
    public int power;//폭탄 위력

    
    //생성자
	public Bomb(int power, float countDown) {
		this.power=power;
		this.countDown=countDown;
		state=State.NORMAL;//초기 상태는 보통상태임
	}
	
	public Bomb() {//기본 폭탄 값(아이템을 얻지 못했을 때)
		this(1,3.0f);
	}
	
	public Bomb(int power) {//파워 업 아이템을 먹었을 때의 폭탄
        this(power, 2.0f);
    }
	
	public void setMove(Bomb.State state) {//폭탄이 보통상태인지 터졌는지 정해줌
        this.state = state;
    }

}
