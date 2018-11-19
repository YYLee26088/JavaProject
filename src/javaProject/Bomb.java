package javaProject;

public class Bomb {
	
	public enum State{//ÇöÀç ÆøÅºÀÇ »óÅÂ
		NORMAL,//º¸Åë»óÅÂ
        EXPLODING//ÅÍÁü
	}
	
	//ÆøÅº °´Ã¼ÀÇ ¼Ó¼º
	public float countDown;//Ä«¿îÆ®´Ù¿î
    public State state;//»óÅÂ
    public int power;//ÆøÅº À§·Â  
    
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
