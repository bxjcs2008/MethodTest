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
 * �������е���Ϣչʾ�������� aarayShow()����
 * */
public class GridFrame extends JFrame{


	
	//�����ı�����������
	public int array[][];
	
	public void arrayShow(int [][] array){
		
		//������壬������Ϊ���񲼾֣�4��4�У����ˮƽ����ֱ����Ϊ3 
		JPanel p=new JPanel(new GridLayout(array.length,array[0].length,4,4));
		JTextArea t=new JTextArea();        //�����ı��� ����
		
		// Key�¼�
		KeyListener key = new KeyboardAction();
		// ��Key�¼�ͬʱ��Ӹ�JPanel��JTextFieil���
		p.addKeyListener(key);
		
		//������ť����
		JButton btn[][];
		//������ť����
		btn=new JButton[array.length][array[0].length];
		
		
		
		//ѭ�����尴ť
	/*	for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j]=new JButton(array[i][j]+"");
				p.add(btn[i][j]);
				btn[i][j].addKeyListener(key);
			}
		}*/
		
		initals(btn,key,p,array);
		
		//���������ڴ��� CENTER λ��
		getContentPane().add(p,BorderLayout.CENTER);
		setVisible(true);
		p.requestFocus();
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);               //�ô��������ʾ
		
	}
	
	//��ʾ��������
	//����JButton���� ����ɫ
	//λ��ť���Ӽ�����
	public  void initals( JButton [][] btn, KeyListener key,JPanel p, int [][]array){
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
	}
	
	//���췽��
	public  GridFrame(String s){
		
		super(s);
		setLayout(new BorderLayout());     //���崰�岼��Ϊ�߽粼��
	}
	
	public static void main(String[] args){

        GridFrame gl=new GridFrame("����");

        while(1 ==1 ){
        	gl.arrayShow(ArrayUtils.array);
        }
        }
	
}
