package javaProject;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame{

	JLabel[][] temp;
	JLabel p;
	JLabel wall;
	int px, py;//길이, 너비

	MyMap newMap=new MyMap();

	public Test(){
		setTitle("테스트");
		setSize(300,300); // 창크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시역활
		this.setContentPane(newMap); // 패널 적용
		setVisible(true); // 창패널 보여주기 여부
		newMap.requestFocus(); // 포커스 점령
	}

//	public void setMap(JLabel[][] map) {
//		for(int h=0;h<13;h++) {
//			for(int w=0;w<13;w++) {
//				if(h==0||h==12||w==0||w==12||(h%2==0&&w%2==0)) {
//					map[h][w].setText("■");
//
//				}
//			}
//		}
//	}

	class MyMap extends JPanel{
		public MyMap(){
			setLayout(new GridLayout(13,13));
			temp=new JLabel[13][13];

			p=new JLabel("@");

			px=1; py=1;
			p.setSize(20,20);
			
			for(int i=0;i<13;i++) {
				for(int j=0;j<13;j++) {
					temp[i][j]=new JLabel();
					if(i==0||i==12||j==0||j==12||(i%2==0&&j%2==0)) {
						temp[i][j].setText("■");
						temp[i][j]=wall;

					}
					add(temp[i][j]);
				}
			}

			addKeyListener(new KeyListener() {//무명클래스
				public void keyPressed(KeyEvent e) {
					int keycode=e.getKeyCode();

					switch(keycode) {
					case KeyEvent.VK_UP://방향키: 상
						if(temp[px][py-1]==wall) {//==wall
							System.out.println("막힘");
						}
						else {
							System.out.println("위로 1칸");
						}
						break;
					case KeyEvent.VK_DOWN://방향키: 하
						if(temp[px][py-1].getText().equals("■")) {
							System.out.println("막힘");
						}
						else {
							System.out.println("아래로 1칸");
						}
						break;
					case KeyEvent.VK_LEFT://방향키: 좌
						if(temp[px][py-1].getText().equals("■")) {
							System.out.println("막힘");
						}
						else {
							System.out.println("왼쪽으로 1칸");
						}
						break;
					case KeyEvent.VK_RIGHT://방향키: 우
						if(temp[px][py-1].getText().equals("■")) {
							System.out.println("막힘");
						}
						else {
							System.out.println("오른쪽으로 1칸");
						}
						break;
					}
				}

				public void keyTyped(KeyEvent e) {}
				public void keyReleased(KeyEvent e) {}
			});
		}
	}
	public static void main(String args[]) {
		new Test();

	}


}




