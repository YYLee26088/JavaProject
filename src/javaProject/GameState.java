package javaProject;

public class GameState {
	
	private State state;
	
	public enum State{
		StartMenu,//0
		GamePlaying,//1
		GameOver,//2
		End;//3
		
		int id;
	}
	

}
