/*
 * ���� ������ ����
 */
package javaProject;

import javax.swing.*;
import java.awt.*;

public class BMFrame extends JFrame{
	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();
		
		setTitle("Bomber Man: ���� ��");
		setSize(800,500);//�ӽ� �ʱ�ȭ
		setLocation(screen.width/2, screen.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		this.add(panel);
		Image img=kit.getImage("BIcon.png");
		setIconImage(img);
		setVisible(true);
	}

}
