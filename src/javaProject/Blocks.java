package javaProject;

import javax.swing.*;

public class Blocks extends JLabel{
	
	public enum Type{
		EMPTY,//0
		BRICK,//1
		BOX,//2
		PLAYER,//3
		KEY//4
	}
	
	private Type type;
	
	public void setType(Type t) {
		this.type=t;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public boolean breakable() {
		if(this.type.equals(Type.BOX)||this.type.equals(Type.PLAYER)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean movable() {
		if(this.type==Type.BOX||this.type==Type.BRICK) {
			return false;
		}
		else
			return true;
	}
	
	public void addIcon() {
		switch(this.type) {
		case EMPTY:
			this.setIcon(null);
			break;
		case BRICK:
			this.setIcon(new ImageIcon("images/brick.png"));
			break;
		case BOX:
			break;
		case KEY:
			this.setIcon(new ImageIcon("images/key.png"));
			break;
		case PLAYER:
			this.setIcon(new ImageIcon("images/character.png"));
		default:
			break;
		}
	}
}
