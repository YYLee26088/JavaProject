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

		Blocks[][] m=stage.getMap();//�� ��������

		//Ű �����ʸ� ����Ŭ������ ����
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {
				
				case KeyEvent.VK_UP://����Ű: ��
					if(m[stage.getPx()][stage.getPy()-1].movable()==true) {
						System.out.println("���� ����");
						stage.setPy(stage.getPy()-1);
					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
					}
					System.out.println("�÷��̾��� �ε���"+stage.getPy()+","+stage.getPx());
					//System.out.println("�÷��̾��� �ε���"+);
					break;
				case KeyEvent.VK_DOWN://����Ű: ��
					if(m[stage.getPx()][stage.getPy()+1].movable()==true) {
						System.out.println("�Ʒ��� ����");
						stage.setPy(stage.getPy()+1);
					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
					}
					System.out.println("�÷��̾��� �ε���"+stage.getPy()+","+stage.getPx());
					break;
				case KeyEvent.VK_LEFT://����Ű: ��
					if(m[stage.getPx()-1][stage.getPy()].movable()==true) {
						System.out.println("�������� ����");
						stage.setPx(stage.getPx()-1);
					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
					}
					System.out.println("�÷��̾��� �ε���"+stage.getPy()+","+stage.getPx());
					break;
				case KeyEvent.VK_RIGHT://����Ű: ��
					if(m[stage.getPx()+1][stage.getPy()].movable()==true) {
						System.out.println("���������� ����");
						stage.setPx(stage.getPx()+1);
					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
					}
					System.out.println("�÷��̾��� �ε���"+stage.getPy()+","+stage.getPx());
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