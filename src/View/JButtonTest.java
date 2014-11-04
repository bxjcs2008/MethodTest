package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest  extends JButton{

	 private Shape shape = null;
	 private Color quit = new Color(0, 0, 228);// �뿪ʱ��ɫ
	 public JButtonTest(String s) {
	  super(s);
	  //addMouseListener(this);
	  setContentAreaFilled(false);// �Ƿ���ʾ��Χ�������� ѡ��
	 }
	 public void paintComponent(Graphics g) {
	   g.setColor(quit);
	  //���Բ�Ǿ������� Ҳ����Ϊ������ͼ��
	  g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
	      20, 20);
	  //���������� ���򻭲�����
	  super.paintComponent(g);
	 }
	 public void paintBorder(Graphics g) {
	  //���߽�����
	  g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
	      20, 20);
	 }
	 public static void main(String[] argv) {
	  JFrame f = new JFrame();
	  f.setSize(400, 300);
	  JButtonTest btn = new JButtonTest("button");
	  f.setLayout(null);
	  btn.setBounds(100, 100, 80, 30);
	  f.getContentPane().add(btn, BorderLayout.NORTH);
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setVisible(true);
	 }
}
