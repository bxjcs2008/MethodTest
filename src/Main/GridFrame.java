package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.KeyboardAction;

public class GridFrame extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 临时数据
	 * */
	private int [][] array ;
	private JButton btn[][] = new JButton[array.length][array[0].length];
	
	public GridFrame () {
		
		//定义面板，并设置为网格布局，4行4列，组件水平、垂直间距均为3 
		JPanel p=new JPanel(new GridLayout(array.length,array[0].length,10,10));
		//JTextArea t=new JTextArea();        //定义文本框 分数
				
		// Key事件
		KeyListener key = new KeyboardAction();
		// 将Key事件同时添加给JPanel和JTextFieil组件
		p.addKeyListener(key);
		
/*		//声明按钮数组
		JButton btn[][];
		//创建按钮数组
		btn=new JButton[array.length][array[0].length];*/
		
		//将数组内容添加到按钮中 设置字体，颜色
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
		
		getContentPane().add(p,BorderLayout.CENTER);
		setVisible(true);
		p.requestFocus();
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);               //让窗体居中显示
	}

	//将新数组的内容装载进按钮中
	
	public void loadArray(int [][]array ){
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				if (btn[i][j].getText() != array[i][j] +""){
					
					btn[i][j].setText(array[i][j]+"");
				}
			}
		}
	}
	
	//更具数组的值设置不同的按钮颜色
	public void colorArray(JButton button,int array){
		if (array == 0){
			
		}
		else {
			
			button.setBackground(Color.red);
		}
	}
	
	public Color [][] colorList;
	
	
}
