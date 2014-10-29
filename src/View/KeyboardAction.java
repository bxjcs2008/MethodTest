package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardAction implements KeyListener{

	public int [][][] array;
	
	public void keyPressed(KeyEvent e) {
		
		String str;
		switch(e.getKeyCode())
		{
		  case KeyEvent.VK_UP: 
				str = "UP";
				System.out.print(str);
				ArrayTest.translate(array, str);
				break;
		  case KeyEvent.VK_DOWN:
				str = "DOWN";
				System.out.print(str);
				break;
		  case KeyEvent.VK_LEFT:
				str = "LEFT";
				System.out.print(str);
				break;
		  case KeyEvent.VK_RIGHT:	  
				str = "RIGHT";
				System.out.print(str);
				break;
		}
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}
	public int[][][] getArray() {
		return array;
	}
	public void setArray(int[][][] array) {
		this.array = array;
	}
	
	
}
