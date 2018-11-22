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
				case KeyEvent.VK_UP: py-=10;//방향키: 상 
				
				break;
				case KeyEvent.VK_DOWN: py+=10;//방향키: 하
				
				break;
				case KeyEvent.VK_LEFT: px-=10;//방향키: 좌
				
				break;
				case KeyEvent.VK_RIGHT: px+=10;//방향키: 우
				break;
				case KeyEvent.VK_SPACE: bx=px; by=py; 
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