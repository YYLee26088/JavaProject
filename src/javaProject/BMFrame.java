/*
 * ���� ������ ����
 * ������
 */
package javaProject;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BMFrame extends JFrame{
	
	public StartMenu sm=null;
	public GamePlaying gp=null;
	
	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Bomber Man: ���� ��");
		setSize(1013,637);//������ ũ��
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img=kit.getImage("images/Icon.png");//�ӽ� ������
		setIconImage(img);//�����ӿ� �г� �߰�
		
		add(new StartMenu());
	}
	
	public void change(String name) {
		if(name.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(sm);
			revalidate();
			repaint();
		}
		else if(name.equals("panel02")){
			getContentPane().removeAll();
			getContentPane().add(gp);
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
}
