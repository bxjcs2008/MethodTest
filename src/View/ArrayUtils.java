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
	public static int [] line1  = new int [] {2,4,8,8};
	public static int [] line2  = new int [] {2,8,4,16};
	public static int [] line3  = new int [] {8,8,4,32};
	public static int [] line01  = new int [] {0,0,0,0};
	public static int [] line02  = new int [] {0,0,0,0};
	public static int [] line03  = new int [] {0,0,0,0};
	
	//构建二维数组
	public static int [][] array  = new int [][] {
		line1,
		line2,
		line3
	};
	public static int [][] array0 = new int [][] {
		line01,
		line02,
		line03
	};
	
	//构建三维数组
	public static int [][][]narry = new int[][][]{
		array,
		array0
	};
	
	//数组中生产1个数
	public static void createNewNum(int [][] array){
		
		for (int i = 0 ; i< array.length ; i++){
			for (int j = 0 ; j < array[i].length ; j++){
				if (array[i][j] == 0){
					array[i][j] = 2;
					return;
				}
			}
		}
	}
	
	
}
