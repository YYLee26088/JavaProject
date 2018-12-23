package javaProject;
//MovingPlayer ���� GamePlaying ���� �ٲ� ����
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import javaProject.Blocks.Type;

public class MovingPlayer extends JPanel {
	
	private GameMap stage;
	//private Player p;
	private BufferedImage b=null;
	
	private int stageLevel;

	private XY playerXY;

	int bx,by;

	Color background=new Color(170,164,151);

	public MovingPlayer(BMFrame frame,int num) {
		stage=new GameMap(num);
		//p=new Player();

		playerXY=new XY(stage.getPx(),stage.getPy());

		setBackground(background);//�ٴ� �÷� ����

		this.setLayout(new GridLayout(15,25));
		this.setSize(1005,605);

		Blocks[][] m=stage.getMap();//�� ��������

		for(int i=0;i<15;i++) {
			for (int j=0;j<25;j++) {
				this.add(m[i][j]);
			}
		}

		//Ű �����ʸ� ����Ŭ������ ����
		addKeyListener(new KeyListener() {//�гο� Ű �̺�Ʈ ó���� �߰��� ����
			public void keyPressed(KeyEvent e) {
				int keycode=e.getKeyCode();
				switch(keycode) {

				case KeyEvent.VK_UP://����Ű: ��
					try{
						AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/PlayerWalk.wav"));
						Clip clip = AudioSystem.getClip();
						clip.stop();
						clip.open(ais);
						clip.start();
					}
					catch(Exception ex){System.out.println("�������");}
					//
					if(stage.getPy()-1<0) {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}
					else if(m[stage.getPy()-1][stage.getPx()].movable()==true) {
						System.out.println("���� ����");
						stage.setPy(stage.getPy()-1);
						playerXY.setY(stage.getPy());

						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();

						m[stage.getPy()+1][stage.getPx()].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� �Ʒ���
						m[stage.getPy()+1][stage.getPx()].addIcon();
					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}

					break;
				case KeyEvent.VK_DOWN://����Ű: ��
					try{
						AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/PlayerWalk.wav"));
						Clip clip = AudioSystem.getClip();
						clip.stop();
						clip.open(ais);
						clip.start();
					}
					catch(Exception ex){System.out.println("�������");}
					//
					if(stage.getPy()+1==stage.getEndY()&&stage.getPx()==stage.getEndX()) {
						if(num==2) {
							try{
								AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/sound.wav"));
								Clip clip = AudioSystem.getClip();
								clip.stop();
								clip.open(ais);
								clip.start();
							}
							catch(Exception ex){System.out.println("�������");}
							System.out.println("���� ����.");
							frame.clear();
							stage.setPy(stage.getPy()+1);
							playerXY.setY(stage.getPy());
						}
						else {
							System.out.println("�������� Ŭ����. ���� ���������� �Ѿ�ϴ�...");
							stage.setPy(stage.getPy()+1);
							playerXY.setY(stage.getPy());
							frame.change(num+1);
						}
						
					}
					else if(m[stage.getPy()+1][stage.getPx()].movable()==true) {
						System.out.println("�Ʒ��� ����");
						stage.setPy(stage.getPy()+1);
						playerXY.setY(stage.getPy());

						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();

						m[stage.getPy()-1][stage.getPx()].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ����
						m[stage.getPy()-1][stage.getPx()].addIcon();

					}
					else {
						System.out.println("���� ��");
						stage.setPy(stage.getPy());
						playerXY.setY(stage.getPy());
					}

					break;
				case KeyEvent.VK_LEFT://����Ű: ��
					try{
						AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/PlayerWalk.wav"));
						Clip clip = AudioSystem.getClip();
						clip.stop();
						clip.open(ais);
						clip.start();
					}
					catch(Exception ex){System.out.println("�������");}
					//
					if(m[stage.getPy()][stage.getPx()-1].movable()==true) {
						System.out.println("�������� ����");
						stage.setPx(stage.getPx()-1);
						playerXY.setX(stage.getPx());

						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();

						m[stage.getPy()][stage.getPx()+1].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ������
						m[stage.getPy()][stage.getPx()+1].addIcon();

					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
						playerXY.setX(stage.getPx());
					}

					break;
				case KeyEvent.VK_RIGHT://����Ű: ��
					try{
						AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/PlayerWalk.wav"));
						Clip clip = AudioSystem.getClip();
						clip.stop();
						clip.open(ais);
						clip.start();
					}
					catch(Exception ex){System.out.println("�������");}
					//
					if(m[stage.getPy()][stage.getPx()+1].movable()==true) {
						System.out.println("���������� ����");
						stage.setPx(stage.getPx()+1);
						playerXY.setX(stage.getPx());

						m[stage.getPy()][stage.getPx()].setType(Type.PLAYER);
						m[stage.getPy()][stage.getPx()].addIcon();

						m[stage.getPy()][stage.getPx()-1].setType(Type.EMPTY);//���� �÷��̾� ��ġ�� ����
						m[stage.getPy()][stage.getPx()-1].addIcon();
					}
					else {
						System.out.println("���� ��");
						stage.setPx(stage.getPx());
						playerXY.setX(stage.getPx());
					}

					break;
				case KeyEvent.VK_SPACE: 
					System.out.println("��ź����");

					bx=playerXY.getX()*m[0][0].getWidth();
					by=playerXY.getY()*m[0][0].getHeight();
					try {
						b=ImageIO.read(new File("images/bomb.png"));
					} catch (IOException e2) {
						System.out.println("�̹��� ����");
						System.exit(1);
					}break;

				}

				System.out.println(playerXY.toString());

				repaint();
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});

		this.requestFocus();
		setFocusable(true);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(b,bx,by,null);
	}
}