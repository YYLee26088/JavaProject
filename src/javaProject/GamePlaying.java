package javaProject;
//삭제할 클래스임
import javax.swing.JPanel;

public class GamePlaying extends JPanel{
	
	private BMFrame frame;
	private MovingPlayer temp;
	private State state;
	
	public GamePlaying(BMFrame frame) {
		frame=new BMFrame();
		state=State.GamePlaying;
		
		this.setLayout(null);
		setSize(frame.getWidth(),frame.getHeight()+20);
		
		temp=new MovingPlayer();
		this.add(temp);
		temp.setBounds(0, 0, 637, 637);
		
	}
	
	public State getState(){
		return this.state;
	}
}
