package View;

public class ArrayMoveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayMoveTest amt = new ArrayMoveTest();
		//amt.movArrayLeft(line, "");
		//amt.displayline(amt.movArrayLeft(line, ""));
		amt.display(amt.moveArrayTest(amt.array, "RIGHT"));
	}
	
	public  int [][] array = {
		{2  ,0  ,64  ,16 },
		{4  ,8  ,0  ,16 },
		{2  ,32  ,0  ,16 },
		{2  ,0  ,32  ,16 }
	};
	public static int [] line = {0,0,1,2}; 
	public static int ARRAY_SIZE = 4;
	

	//将4*4数组中的非”0 “元素向左移动
	public int [][] move (int [][] array){
		
		int m;
		int n;
		for (int i = 0;i < ARRAY_SIZE ;i++){
			for (int j = 0; j < ARRAY_SIZE ; j++){
				if (array[i][j]==0){
					
					m = i;
					n = j;
					while(array[i][j]==0&&m<ARRAY_SIZE&&n<ARRAY_SIZE){
						array[i][j] = array[m][n];
						array[m][n] = 0;
						n = n+1;
					}
				}
			}
		}
		System.out.println("over");
		return array;
	}
	
	//输出数组各个数值
	public void display (int [][] array){
		
		for (int i = 0;i <ARRAY_SIZE;i++){
			for (int j = 0; j<ARRAY_SIZE ; j++){
				System.out.print(array[i][j]+"   ");
			}
			System.out.println("");
		}
	}
	
	//输出一维数组各个数值
	public void displayline(int [] line){
		for (int i = 0 ;i< ARRAY_SIZE ;i++){
			System.out.print(line[i] + " ");
		}
		System.out.println("");
	}
	
	//将一维数组中的 非‘0’ 元素向左移动
	public int [] movArrayLeft(int [] array , String type){
		
		for (int i = 0; i < ARRAY_SIZE -1 ;i++ ){
			for (int counter = 1; array[i] == 0&& counter <=ARRAY_SIZE;counter++ ){
				for (int m = i ; m < ARRAY_SIZE - 1; m++){
					array[m] = array[m+1];
					array[m+1] = 0;
				}
			}
		}
		return array;
	}
	

	//将4*4数组中的非“0”元素上下左右移动
	public int [][] moveArrayTest(int [][] array, String type){
		
		int [] test1 = new int [ARRAY_SIZE];
		int [] test2 = new int [ARRAY_SIZE];
		int [] test3 = new int [ARRAY_SIZE];
		int [] test4 = new int [ARRAY_SIZE];
		
		if (type == "LEFT"){
			for (int i = 0 ; i < ARRAY_SIZE; i++){
				for (int j = 0 ; j < ARRAY_SIZE ; j++){
					test1[j] = array[i][j];
				}
				test1  = movArrayLeft(test1,"LEFT");
				
				
				//注意不能写成 array[i] = test1; ( 引用传递，没有实现值传递)
				for (int j =0 ; j <ARRAY_SIZE ; j++){
					array[i][j] = test1[j];
				}
			}
		}
		
						if (type =="RIGHT"){
							for (int i = 0 ; i < ARRAY_SIZE ; i++){
								for (int j = ARRAY_SIZE - 1 ; j >= 0  ;j--){
									test2[ARRAY_SIZE - 1 -j ] = array[i][j];
								}
								test2 = movArrayLeft(test2,"RIGHT");
								for (int j = ARRAY_SIZE - 1 ; j>= 0; j--){
									array[i][j] = test2[ARRAY_SIZE - 1 -j];
								}
							}
						}
		
						if (type == "UP"){
							for (int j =0 ;j<ARRAY_SIZE ; j++ ){
								for (int i = 0 ; i < ARRAY_SIZE ; i++){
									test3[i] = array[i][j];
								}
								test3 = movArrayLeft(test3,"UP");
								for (int i = 0 ; i <ARRAY_SIZE ; i++){
									array[i][j] = test3[i];
								}
							}
						}
				
						if (type == "DOWN") {
							for (int j = 0 ; j<ARRAY_SIZE ;j++){
								for (int i = ARRAY_SIZE -1 ; i >=0 ; i--){
									test4[ARRAY_SIZE -1 - i] = array[i][j];
								}
								test4 = movArrayLeft(test4,"DOWN");
								for (int i = ARRAY_SIZE - 1 ; i >= 0 ; i--){
									array[i][j] = test4[ARRAY_SIZE-1-i];
								}
							}
						}
				
		return array;
	}
	
	//数组复制   sraArray 源数组     desArray 目的数组
	public void arrayClone(int  [] srcArray , int [] desArray , String type){
		
		if (type == "LEFT"){
			desArray = srcArray;
		}
		
		if (type == "RIGHT"){
			for (int i = 0 ; i < ARRAY_SIZE ; i++){
				desArray [i] = srcArray[ARRAY_SIZE -i -1];
			}
		}
		
		if (type =="UP"){
			 desArray = srcArray;
		}
		
		if (type == "DOWN"){
			for (int i = 0 ; i < ARRAY_SIZE ; i++){
				desArray [i] = srcArray[ARRAY_SIZE -i -1];
			}
		}
	}

	public void arrayRevert(int [] array){
		
		for (int i = 0 ; i < ARRAY_SIZE ; i++ ){
			array[i] =0;
		}
	}
}
