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
	 * ��ʱ����
	 * */
	private int [][] array ;
	private JButton btn[][] = new JButton[array.length][array[0].length];
	
	public GridFrame () {
		
		//������壬������Ϊ���񲼾֣�4��4�У����ˮƽ����ֱ����Ϊ3 
		JPanel p=new JPanel(new GridLayout(array.length,array[0].length,10,10));
		//JTextArea t=new JTextArea();        //�����ı��� ����
				
		// Key�¼�
		KeyListener key = new KeyboardAction();
		// ��Key�¼�ͬʱ��Ӹ�JPanel��JTextFieil���
		p.addKeyListener(key);
		
/*		//������ť����
		JButton btn[][];
		//������ť����
		btn=new JButton[array.length][array[0].length];*/
		
		//������������ӵ���ť�� �������壬��ɫ
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j]=new JButton(array[i][j]+"");
				Font f=new Font("����",Font.BOLD,25);//���ð�ť���壬��С����ϸ
				btn[i][j].setBackground(Color.cyan); //���ð�ť����ɫ  ��ɫ
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
		setLocationRelativeTo(null);               //�ô��������ʾ
	}

	//�������������װ�ؽ���ť��
	
	public void loadArray(int [][]array ){
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				if (btn[i][j].getText() != array[i][j] +""){
					
					btn[i][j].setText(array[i][j]+"");
				}
			}
		}
	}
	
	//���������ֵ���ò�ͬ�İ�ť��ɫ
	public void colorArray(JButton button,int array){
		if (array == 0){
			
		}
		else {
			
			button.setBackground(Color.red);
		}
	}
	
	public Color [][] colorList;
	
	
}
