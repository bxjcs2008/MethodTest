package View;

import java.util.Arrays;

public class ArrayDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayDisplay ad = new ArrayDisplay();
		ad.display(ad.array_core3);
	}

	
	public int [][][] array = {
			{
				
			}
	};
	
	//创建1 维数组
	public int [] array_core1 = {1,2,3,4,5};
	public int [] array_value1 = {0,0,0,0,0};
	
	//创建2维数组
	public int [][] array_core2 = {
			this.array_core1,
			this.array_core1,
			this.array_core1,
			this.array_core1,
			this.array_core1
	};
	public int [][] array_value2 = {
			this.array_value1,
			this.array_value1,
			this.array_value1,
			this.array_value1,
			this.array_value1
	};
	
	//创建3维数组
	public int [][][] array_core3 ={
		this.array_core2,
		this.array_value2
	};
	
	//输出1维数组
	public void display(int [] array){
		
		for (int i = 0; i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	//输出2维数组
	public void display(int [][]array){
		
		for (int i = 0; i<array.length; i++){
			display(array[i]);
			System.out.println(" ");
		}
	}
	
	//输出3维数组
	public void display (int [][][] array){
		
/*		for (int i = 0 ; i< array.length; i++){
			display(array[i]);
			System.out.println(" ");
		}*/
		
		String a = Arrays.toString(array);
		System.out.print(a);
	}
}


