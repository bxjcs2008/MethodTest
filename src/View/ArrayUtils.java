package View;

public class ArrayUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//��ӡһά����
	public static void displayArray(int [] array){
		
		for (int i = 0 ; i< array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}
	
	//��ӡ��ά����
	public static void displayArray(int [][]array){
		
		for (int i = 0 ; i< array.length ; i++){
			displayArray(array[i]);
		}
		System.out.println(" ");
	}
	
	
	//��ӡ��ά����
	public static void displayArray(int [][][]array){
		
		for (int i = 0 ; i< array.length ; i++){
			displayArray(array[i]);
		}
		System.out.println(" ");
	}
	
	//����һά����
	public static int [] line1  = new int [] {2,4,8};
	public static int [] line2  = new int [] {2,8,4};
	public static int [] line3  = new int [] {8,2,4};
	public static int [] line01  = new int [] {0,0,0};
	public static int [] line02  = new int [] {0,0,0};
	public static int [] line03  = new int [] {0,0,0};
	
	//������ά����
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
	
	//������ά����
	public static int [][][]narry = new int[][][]{
		array,
		array0
	};
}
