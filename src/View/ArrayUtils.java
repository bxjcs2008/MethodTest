package View;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//打印一维数组
	public static void displayArray(int [] array){
		
		for (int i = 0 ; i< array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}
	
	//打印二维数组
	public static void displayArray(int [][]array){
		
		for (int i = 0 ; i< array.length ; i++){
			displayArray(array[i]);
		}
		System.out.println(" ");
	}
	
	
	//打印三维数组
	public static void displayArray(int [][][]array){
		
		for (int i = 0 ; i< array.length ; i++){
			displayArray(array[i]);
		}
		System.out.println(" ");
	}
	
	//构建一维数组
	public static int [] line1  = new int [] {2,2,4};
	public static int [] line2  = new int [] {2,2,4};
	public static int [] line3  = new int [] {2,2,4};
	
	//构建二维数组
	public static int [][] array  = new int [][] {
		line1,
		line2,
		line3
	};
	
	//构建三维数组
	public static int [][][]narry = new int[][][]{
		array,
		
	};
}
