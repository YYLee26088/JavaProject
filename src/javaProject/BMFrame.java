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
		
		JPanel panel=new JPanel();//��ư�� �̹��� ���� �� �г�
		panel.setLayout(new FlowLayout());//��ġ������ ����: FlowLayout
		this.add(panel);//�����ӿ� �г� �߰�
		Image img=kit.getImage("BIcon.png");//�ӽ� ������
		setIconImage(img);
		
		JButton gameStart=new JButton("���� ����");
		JButton option=new JButton("�ɼ�");
		panel.add(gameStart);
		panel.add(option);
		
		setVisible(true);
	}

}
