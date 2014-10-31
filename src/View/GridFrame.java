package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 将数组中的信息展示到窗口中 aarayShow()方法
 * */
public class GridFrame extends JFrame{


	
	//定义文本框内容数组
	public int array[][];
	
	public void arrayShow(int [][] array){
		
		//定义面板，并设置为网格布局，4行4列，组件水平、垂直间距均为3 
		JPanel p=new JPanel(new GridLayout(array.length,array[0].length,4,4));
		JTextArea t=new JTextArea();        //定义文本框 分数
		
		// Key事件
		KeyListener key = new KeyboardAction();
		// 将Key事件同时添加给JPanel和JTextFieil组件
		p.addKeyListener(key);
		
		//声明按钮数组
		JButton btn[][];
		//创建按钮数组
		btn=new JButton[array.length][array[0].length];
		
		
		
		//循环定义按钮
	/*	for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j]=new JButton(array[i][j]+"");
				p.add(btn[i][j]);
				btn[i][j].addKeyListener(key);
			}
		}*/
		
		initals(btn,key,p,array);
		
		//将面板放置在窗体 CENTER 位置
		getContentPane().add(p,BorderLayout.CENTER);
		setVisible(true);
		p.requestFocus();
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);               //让窗体居中显示
		
	}
	
	//显示数组内容
	//设置JButton字体 背景色
	//位按钮增加监听器
	public  void initals( JButton [][] btn, KeyListener key,JPanel p, int [][]array){
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j]=new JButton(array[i][j]+"");
				Font f=new Font("宋体",Font.BOLD,25);//设置按钮字体，大小，粗细
				btn[i][j].setBackground(Color.cyan); //设置按钮背景色  青色
				btn[i][j].setFont(f);
				p.add(btn[i][j]);
				btn[i][j].addKeyListener(key);
			}
		}
	}
	
	//构造方法
	public  GridFrame(String s){
		
		super(s);
		setLayout(new BorderLayout());     //定义窗体布局为边界布局
	}
	
	public static void main(String[] args){

        GridFrame gl=new GridFrame("窗口");

        while(1 ==1 ){
        	gl.arrayShow(ArrayUtils.array);
        }
        }
	
}
