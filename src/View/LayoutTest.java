package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 测试JFrame各种布局
 * 
 * */

public class LayoutTest  extends JPanel{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("GridBag Layout Example");
		LayoutTest layout = new LayoutTest();
		f.add(layout);
		layout.init();
		
		f.setVisible(true);
        f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);               //让窗体居中显示
	}
	
	

	public  void init(){
		
		GridBagLayout gridbag = new GridBagLayout(); 
		GridBagConstraints  c = new GridBagConstraints ();
		
		JButton [][] btn;
		
        this.setLayout(gridbag);
        //c.fill = GridBagConstraints.BOTH;
        for (int i = 0 ; i < 4 ; i ++){ 
        	for (int j = 0 ; j < 4 ;j++){
        		c.gridx = j;
        		c.gridy = i;
				this.add(new JButton(i +" "+ j ),c);
        	}
		}

        
	}
}
