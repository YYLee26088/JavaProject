/*
 * ���� ������ ����
 * ������
 */
package javaProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMFrame extends JFrame{

	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Maze Escape: �̷� Ż��");
		setSize(1010,633);//������ ũ��
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setLayout(null);
		
		setResizable(false);

		getContentPane().setBackground(Color.black);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img=kit.getImage("images/Icon.png");//�ӽ� ������
		setIconImage(img);//�����ӿ� �г� �߰�

		add(new StartMenu(this));
	}

	public void change(int stage) {
		MovingPlayer game=new MovingPlayer(this,stage);
		getContentPane().removeAll();
		getContentPane().add(game);
		
		game.requestFocus();
		
		revalidate();
		repaint();
	}
	
	public void clear() {
		Ending end=new Ending(this);
		getContentPane().removeAll();
		getContentPane().add(end);
		
		end.requestFocus();
		
		revalidate();
		repaint();
	}

}

//	public void setScreen(ameState state) {
//		switch(state.getID()) {
//		case 0:
//			this.add(new StartMenu());
//		case 1:
//			this.add(new GamePlaying());
//		}
//	}

