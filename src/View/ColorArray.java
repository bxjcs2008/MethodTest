package View;

import java.awt.Color;
import java.util.HashMap;

public class ColorArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public  HashMap colormap;

	
	//分配不同的颜色给不同的数值
	public ColorArray(){
		
		HashMap<String , Color> map = new HashMap<String , Color>(); 
		map.put("2", Color.red);
		
	}
}
