package javaProject;

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
	
//	private ImageIcon i=new ImageIcon("temp/back.png");
//	
//	JPanel background=new JPanel() {
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(i.getImage(), 0, 0, null);
//			repaint();
//		}
//	};

	public MovingPlayer() {

//		this.add(background);
		setBackground(background);

		this.setLayout(new GridLayout(15,15));
		this.setSize(600,600);

		Blocks[][] m=stage.getMap();//�� ��������
		
		for(int i=0;i<15;i++) {
			for (int j=0;j<15;j++) {
				this.add(m[i][j]);
			}
		}

		//Ű �����ʸ� ����Ŭ������ ����
		addKeyListener(new KeyListener() {//�гο� Ű �̺�Ʈ ó���� �߰��� ����
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				
				case KeyEvent.VK_UP://����Ű: ��
					if(m[stage.getPy()-1][stage.getPx()].movable()==true) {
						System.out.println("���� ����");
						stage.setPy(stage.getPy()-1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()+1][stage.getPx()].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� �Ʒ���
						m[stage.getPy()+1][stage.getPx()].setIcon(null);
					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_DOWN://����Ű: ��
					if(m[stage.getPy()+1][stage.getPx()].movable()==true) {
						System.out.println("�Ʒ��� ����");
						stage.setPy(stage.getPy()+1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()-1][stage.getPx()].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ����
						m[stage.getPy()-1][stage.getPx()].setIcon(null);
						
					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_LEFT://����Ű: ��
					if(m[stage.getPy()][stage.getPx()-1].movable()==true) {
						System.out.println("�������� ����");
						stage.setPx(stage.getPx()-1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()][stage.getPx()+1].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ������
						m[stage.getPy()][stage.getPx()+1].setIcon(null);

					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_RIGHT://����Ű: ��
					if(m[stage.getPy()][stage.getPx()+1].movable()==true) {
						System.out.println("���������� ����");
						stage.setPx(stage.getPx()+1);
						
						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].setIcon(new ImageIcon("images/character.png"));
						
						m[stage.getPy()][stage.getPx()-1].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ����
						m[stage.getPy()][stage.getPx()-1].setIcon(null);
					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
					}
					System.out.println(stage.getPoint());
					break;
				case KeyEvent.VK_SPACE: 
					System.out.println("��ź����");
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