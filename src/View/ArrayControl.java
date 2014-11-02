package View;

public class ArrayControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GridFrame gl=new GridFrame("´°¿Ú");
		KeyboardAction.setGf(gl);
		System.out.print("OVER");
	}

	public static String type = null;
	
	public static int [][][] array = ArrayUtils.narry;
	
	public static void check(String type, GridFrame gl){
		
		while(type != null ){
			
			ArrayTest.translate(array, type);
			gl.loadArray(array[0]);
			type = null;
		}
	}

}
