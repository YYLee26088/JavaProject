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
	
	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Bomber Man: ���� ��");
		setSize(1013,637);//������ ũ��
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img=kit.getImage("images/Icon.png");//�ӽ� ������
		setIconImage(img);
		this.add(new StartMenu());//�����ӿ� �г� �߰�

		setVisible(true);

	}
}
