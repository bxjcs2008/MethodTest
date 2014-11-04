package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest  extends JButton{

	 private Shape shape = null;
	 private Color quit = new Color(0, 0, 228);// 离开时颜色
	 public JButtonTest(String s) {
	  super(s);
	  //addMouseListener(this);
	  setContentAreaFilled(false);// 是否显示外围矩形区域 选否
	 }
	 public void paintComponent(Graphics g) {
	   g.setColor(quit);
	  //填充圆角矩形区域 也可以为其它的图形
	  g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1,
	      20, 20);
	  //必须放在最后 否则画不出来
	  super.paintComponent(g);
	 }
	 public void paintBorder(Graphics g) {
	  //画边界区域
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
