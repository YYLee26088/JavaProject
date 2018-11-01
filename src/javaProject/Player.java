package javaProject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	BufferedImage img=null;
	int x=100,y=100;

	public MyPanel() {
		try {
			img=ImageIO.read(new File("character2.png"));
		}catch(IOException e) {
			System.out.println("이미지 없음");
			System.exit(1);
		}
		//키 리스너를 무명클래스로 구현
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				case KeyEvent.VK_UP: y-=10; break;//방향키: 상
				case KeyEvent.VK_DOWN: y+=10; break;//방향키: 하
				case KeyEvent.VK_RIGHT: x+=10; break;//방향키: 우
				case KeyEvent.VK_LEFT: x-=10; break;//방향키: 좌
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
		g.drawImage(img,x,y,null);
	}
}

public class Player extends JFrame{
	public Player() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}

	public static void main(String[] args) {
		Player c=new Player();
	}
}
