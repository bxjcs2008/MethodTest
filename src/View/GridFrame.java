package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 1.��ʾ���� ��ʼ��   JFrame ʹ�����񲼾� GridLayout
 * 2.
 * 3.�������е���Ϣչʾ��������  װ�ط��� loadArray()
 * */
public class GridFrame extends JFrame{


	
	//�����ı�����������
	public int array[][] = ArrayUtils.array;
	//������ť����
	public JButton btn[][] = new JButton[array.length][array[0].length];

	
	//���췽��
	public  GridFrame(String s){
		
		super(s);
		setLayout(new BorderLayout());     //���崰�岼��Ϊ�߽粼��
		
		//����JFrame ��������
		setResizable(false); 
		
		//������壬������Ϊ���񲼾֣�4��4�У����ˮƽ����ֱ����Ϊ3 
		JPanel p=new JPanel(new GridLayout(array.length,array[0].length,8,8));
		JTextArea t=new JTextArea();        //�����ı��� ����
		//p.setSize(500, 500);
		p.setPreferredSize(new Dimension(500, 500)); // ����JPanel ��С
		p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// Key�¼�
		KeyListener key = new KeyboardAction();
		// ��Key�¼�ͬʱ��Ӹ�JPanel��JTextFieil���
		p.addKeyListener(key);
		
		//��ʾ��������
		//����JButton���� ����ɫ
		//λ��ť���Ӽ�����
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j]=new JButton(array[i][j]+"");
				btn[i][j].setPreferredSize(new Dimension(80, 80));
				
				Font f=new Font("����",Font.BOLD,25);//���ð�ť���壬��С����ϸ
				btn[i][j].setBackground(Color.cyan); //���ð�ť����ɫ  ��ɫ
				btn[i][j].setFont(f);
				p.add(btn[i][j]);
				btn[i][j].addKeyListener(key);
			}
		}
		
		//���������ڴ��� CENTER λ��
		getContentPane().add(p,BorderLayout.CENTER);
		setVisible(true);
		p.requestFocus();
		setSize(500,500);
		setPreferredSize(new Dimension (500,500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);               //�ô��������ʾ
	}
	
	public void loadArray(int [][]array ){
		for (int i = 0 ; i < array.length ; i ++){
			for (int j = 0 ; j < array[i].length ; j++){
				btn[i][j].setText(array[i][j]+"");
			}
		}
	}
	
	
	
}
