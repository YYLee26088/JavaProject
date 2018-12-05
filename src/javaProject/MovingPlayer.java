package javaProject;
//MovingPlayer 에서 GamePlaying 으로 바꿀 예정
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javaProject.Blocks.Type;

public class MovingPlayer extends JPanel {

	GameMap stage=new GameMap();
	int bx=0,by=0;
	
	Color background=new Color(174,174,174);

	public MovingPlayer() {
		
		
		setBackground(background);

		this.setLayout(new GridLayout(15,15));
		this.setSize(600,600);

		Blocks[][] m=stage.getMap();//맵 가져오기
		
		for(int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				this.add(m[i][j]);
			}
		}

		//키 리스너를 무명클래스로 구현
		addKeyListener(new KeyListener() {//패널에 키 이벤트 처리를 추가한 것임
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				
				case KeyEvent.VK_UP://방향키: 상
					if(m[stage.getPy()-1][stage.getPx()].movable()==true) {
						System.out.println("위로 가기");
						stage.setPy(stage.getPy()-1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()+1][stage.getPx()].setType(Type.EMPTY);//현재 플레이어 위치의 아래쪽
						m[stage.getPy()+1][stage.getPx()].setIcon(null);
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_DOWN://방향키: 하
					if(m[stage.getPy()+1][stage.getPx()].movable()==true) {
						System.out.println("아래로 가기");
						stage.setPy(stage.getPy()+1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()-1][stage.getPx()].setType(Type.EMPTY);//현재 플레이어 위치의 위쪽
						m[stage.getPy()-1][stage.getPx()].setIcon(null);
						
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_LEFT://방향키: 좌
					if(m[stage.getPy()][stage.getPx()-1].movable()==true) {
						System.out.println("왼쪽으로 가기");
						stage.setPx(stage.getPx()-1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()][stage.getPx()+1].setType(Type.EMPTY);//현재 플레이어 위치의 오른쪽
						m[stage.getPy()][stage.getPx()+1].setIcon(null);

					}
					else {
						System.out.println("막힌 길");
						stage.setPx(stage.getPx());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_RIGHT://방향키: 우
					if(m[stage.getPy()][stage.getPx()+1].movable()==true) {
						System.out.println("오른쪽으로 가기");
						stage.setPx(stage.getPx()+1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()][stage.getPx()-1].setType(Type.EMPTY);//현재 플레이어 위치의 왼쪽
						m[stage.getPy()][stage.getPx()-1].setIcon(null);
					}
					else {
						System.out.println("막힌 길");
						stage.setPx(stage.getPx());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_SPACE: 
					System.out.println("폭탄놓기");
					//bx=px; by=py; 
				}

				repaint();
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});

		this.requestFocus();
		setFocusable(true);
	}

}