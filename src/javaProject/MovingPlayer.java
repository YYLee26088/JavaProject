package javaProject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MovingPlayer extends JPanel {

	GameMap newStage=new GameMap();
	Player player=new Player();

	BufferedImage p=null;
	BufferedImage b=null;

	int px=0,py=0;
	int bx=0,by=0;

	public MovingPlayer() {
		try {
			p=ImageIO.read(new File("images/character.png"));
		}catch(IOException e1) {
			System.out.println("이미지 없음");
			System.exit(1);
		}
		//키 리스너를 무명클래스로 구현
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				case KeyEvent.VK_UP://방향키: 상
					System.out.println("위로 가기");
					player.setState(Player.State.MOVE_UP);
					py-=42;
					break;
				case KeyEvent.VK_DOWN://방향키: 하
					System.out.println("아래로 가기");
					py+=42;
					break;
				case KeyEvent.VK_LEFT://방향키: 좌
					System.out.println("왼쪽으로 가기");
					px-=42;
					break;
				case KeyEvent.VK_RIGHT://방향키: 우
					System.out.println("오른쪽으로 가기");
					px+=42;
					break;
				case KeyEvent.VK_SPACE: 
					System.out.println("폭탄놓기");
					bx=px; by=py; 
					try {
						b=ImageIO.read(new File("images/bomb.png"));
					} catch (IOException e2) {
						System.out.println("이미지 없음");
						System.exit(1);
					}break;
				}

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
		g.drawImage(p,px,py,null);
		g.drawImage(b,bx,by,null);
	}
}