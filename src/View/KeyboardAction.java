package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardAction implements KeyListener{

	public  static int [][][] array = ArrayUtils.narry;
	
	public static GridFrame gf;
	
	public void keyPressed(KeyEvent e) {
		
		 String str;
		
		switch(e.getKeyCode())
		{
		  case KeyEvent.VK_UP: 
				str = "UP";
				System.out.print(str);
				ArrayControl.type = str;
				ArrayControl.check(str,  gf);
				break;
		  case KeyEvent.VK_DOWN:
				str = "DOWN";
				System.out.print(str);
				ArrayControl.type = str;
				ArrayControl.check(str,  gf);
				break;
		  case KeyEvent.VK_LEFT:
				str = "LEFT";
				System.out.print(str);
				ArrayControl.type = str;
				ArrayControl.check(str,  gf);
				break;
		  case KeyEvent.VK_RIGHT:	  
				str = "RIGHT";
				System.out.print(str);
				ArrayControl.type = str;
				ArrayControl.check(str,  gf);
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
	public static GridFrame getGf() {
		return gf;
	}
	public static void setGf(GridFrame gf) {
		KeyboardAction.gf = gf;
	}
	
	
}
