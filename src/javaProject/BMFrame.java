/*
 * ���� ������ ����
 * ������
 */
package javaProject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMFrame extends JFrame{

	ImageIcon i=new ImageIcon("images/FrameTitle.jpg");
	Image bg=i.getImage();

	public BMFrame() {
		//���� ȭ���� ũ�� ���
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Bomber Man: ���� ��");
		setSize(1013,637);//������ ũ��
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg, 0, 0, null);
			}
		};
		
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
		
		gameStart.addActionListener(new GameStart());

		setVisible(true);
	}
	
	class GameStart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new GamePlaying();
		}
		
	}

}
