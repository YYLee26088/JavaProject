/*
 * ���� ������ ����
 */
package javaProject;

import javax.swing.*;
import java.awt.*;

public class BMFrame extends JFrame{

	ImageIcon i=new ImageIcon("images/FrameTitle.jpg");
	Image bg=i.getImage();

	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();

		setTitle("Bomber Man: ���� ��");
		setSize(1013,637);//������ ũ��
		setLocation(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg, 0, 0, null);
			}
		};//��ư�� �̹��� ���� �� �г�
		background.setLayout(null);//��ġ������ ����: ������ġ�� ��ġ���� null
		this.add(background);//�����ӿ� �г� �߰�
		Image img=kit.getImage("images/Icon.png");//�ӽ� ������
		setIconImage(img);
		
		ImageIcon gs=new ImageIcon("images/gamestart.png");
		JButton gameStart=new JButton(gs);
		gameStart.setBorderPainted(false);
		gameStart.setContentAreaFilled(false);
		gameStart.setFocusPainted(false);

		gameStart.setBounds(590, 430, gs.getIconWidth(), gs.getIconHeight());
		background.add(gameStart);

		setVisible(true);
	}

}
