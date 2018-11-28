package javaProject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MovingPlayer extends JPanel {

	GameMap stage=new GameMap();
	int bx=0,by=0;

	public MovingPlayer() {
		this.setLayout(null);
		this.add(stage);

		Blocks[][] m=stage.getMap();//맵 가져오기

		//키 리스너를 무명클래스로 구현
		addKeyListener(new KeyListener() {//패널에 키 이벤트 처리를 추가한 것임
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				
				case KeyEvent.VK_UP://방향키: 상
					if(m[stage.getPx()][stage.getPy()-1].movable()==true) {
						System.out.println("위로 가기");
						stage.setPy(stage.getPy()-1);
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_DOWN://방향키: 하
					if(m[stage.getPx()][stage.getPy()+1].movable()==true) {
						System.out.println("아래로 가기");
						stage.setPy(stage.getPy()+1);
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_LEFT://방향키: 좌
					if(m[stage.getPx()-1][stage.getPy()].movable()==true) {
						System.out.println("왼쪽으로 가기");
						stage.setPx(stage.getPx()-1);
					}
					else {
						System.out.println("막힌 길");
						stage.setPx(stage.getPx());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_RIGHT://방향키: 우
					if(m[stage.getPx()+1][stage.getPy()].movable()==true) {
						System.out.println("오른쪽으로 가기");
						stage.setPx(stage.getPx()+1);
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