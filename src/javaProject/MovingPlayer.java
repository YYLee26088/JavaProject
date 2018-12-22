package javaProject;
//MovingPlayer 에서 GamePlaying 으로 바꿀 예정
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import javaProject.Blocks.Type;

public class MovingPlayer extends JPanel {

	private GameMap stage;
	private Player p;
	private BufferedImage b=null;
	
	//Timer timer=new Timer();
	
	private XY playerXY;
	
	int bx,by;
	
	Color background=new Color(170,164,151);

	public MovingPlayer() {
		
		stage=new GameMap();
		p=new Player();
		
		playerXY=new XY(stage.getPx(),stage.getPy());
		
		setBackground(background);//바닥 컬러 설정

		this.setLayout(new GridLayout(15,25));
		this.setSize(1005,605);

		Blocks[][] m=stage.getMap();//맵 가져오기
		
		for(int i=0;i<15;i++) {
			for (int j=0;j<25;j++) {
				this.add(m[i][j]);
			}
		}

		//키 리스너를 무명클래스로 구현
		addKeyListener(new KeyListener() {//패널에 키 이벤트 처리를 추가한 것임
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				
				case KeyEvent.VK_UP://방향키: 상
					if(stage.getPy()-1<0) {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}
					else if(m[stage.getPy()-1][stage.getPx()].movable()==true) {
						System.out.println("위로 가기");
						stage.setPy(stage.getPy()-1);
						playerXY.setY(stage.getPy());
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();
						
						m[stage.getPy()+1][stage.getPx()].setType(Type.EMPTY);//현재 플레이어 위치의 아래쪽
						m[stage.getPy()+1][stage.getPx()].addIcon();
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}

					break;
				case KeyEvent.VK_DOWN://방향키: 하
					if(stage.getPy()+1>14) {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}
					else if(m[stage.getPy()+1][stage.getPx()].movable()==true) {
						System.out.println("아래로 가기");
						stage.setPy(stage.getPy()+1);
						playerXY.setY(stage.getPy());
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();
						
						m[stage.getPy()-1][stage.getPx()].setType(Type.EMPTY);//현재 플레이어 위치의 위쪽
						m[stage.getPy()-1][stage.getPx()].addIcon();
						
					}
					else {
						System.out.println("막힌 길");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}

					break;
				case KeyEvent.VK_LEFT://방향키: 좌
					if(m[stage.getPy()][stage.getPx()-1].movable()==true) {
						System.out.println("왼쪽으로 가기");
						stage.setPx(stage.getPx()-1);
						playerXY.setX(stage.getPx());
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();
						
						m[stage.getPy()][stage.getPx()+1].setType(Type.EMPTY);//현재 플레이어 위치의 오른쪽
						m[stage.getPy()][stage.getPx()+1].addIcon();

					}
					else {
						System.out.println("막힌 길");
						stage.setPx(stage.getPx());
						playerXY.setX(stage.getPx());
					}
					
					break;
				case KeyEvent.VK_RIGHT://방향키: 우
					if(m[stage.getPy()][stage.getPx()+1].movable()==true) {
						System.out.println("오른쪽으로 가기");
						stage.setPx(stage.getPx()+1);
						playerXY.setX(stage.getPx());
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();
						
						m[stage.getPy()][stage.getPx()-1].setType(Type.EMPTY);//현재 플레이어 위치의 왼쪽
						m[stage.getPy()][stage.getPx()-1].addIcon();
					}
					else {
						System.out.println("막힌 길");
						stage.setPx(stage.getPx());
						playerXY.setX(stage.getPx());
					}
					
					break;
				case KeyEvent.VK_SPACE: 
					System.out.println("폭탄놓기");
					
					bx=playerXY.getX()*m[0][0].getWidth();
					by=playerXY.getY()*m[0][0].getHeight();
					try {
						b=ImageIO.read(new File("images/bomb.png"));
					} catch (IOException e2) {
						System.out.println("이미지 없음");
						System.exit(1);
					}break;
					
				}
				
				System.out.println(playerXY.toString());
				
				repaint();
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});

		this.requestFocus();
		setFocusable(true);
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(b,bx,by,null);
	}
}