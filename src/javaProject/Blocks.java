package javaProject;

import javax.swing.*;

public class Blocks extends JLabel{
	
	private Type type;
	private boolean movable;
	
	public enum Type{
		EMPTY,
		BRICK,
		BOX,
		PLAYER,
		ENEMY
	}
	
	public void setType(Type t) {
		this.type=t;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public boolean breakable() {
		if(this.type==Type.BOX||this.type==Type.ENEMY||
				this.type==Type.PLAYER) {
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
	
	public void setBlockIcon() {
		switch(this.type) {
		case EMPTY:
			this.setIcon(new ImageIcon("images/floor.png"));
			break;
		case BRICK:
			this.setIcon(new ImageIcon("images/brick.png"));
			break;
		case BOX:
			break;
		case ENEMY:
			break;
		}
	}
}
