package View;

/**
 * 数组的合并和移动   主要方法 translate()
 * */
public class ArrayTest {
	
	//数组translate   起点(x1,y1,z1)    终点(x2,y2,z2)
	private static void translate(int x1,int y1,int z1,int x2,int y2,int z2,int [][][] array){
		
		//两点重合的情况
		if (y2 == y1 && z2 == z1){
			array[1][y1][z1] = 1;
			array[1][y2][z2] = 1;
			sysprint("EQ");
			return;
		}
		
		//up
		if(z1 == z2&& y1 > y2){
			if (y1 - y2 == 1) {
					if (array[0][y1][z1] == array[0][y2][z2]) {
						array[1][y2][z2] = 2;
						array[1][y1][z1] = 0;
						sysprint("UP");
						return;
					} else {
						array[1][y2][z2] = 1;
						array[1][y1][z1] = 1;
						sysprint("UP");
						return;
					}
			}
			else if(y2!=y1&&array[0][y2][z1] ==array[0][y2 + 1][z2]){
				array[1][y2][z2] = 2;
				array[1][y2+1][z2] = 0;
				translate(0,y1 ,z1 ,0 , y2 + 2, z2,array);
			}
			else if(y2!=y1&&array[0][y2][z1] !=array[0][y2 + 1][z2]){
				array[1][y2][z2] = 1;
				array[1][y2 + 1][z2] = 1;
				translate(0 ,y1 ,z1 ,0, y2 + 1, z2,array);
			}
		}
		
		//down
		if(z1 == z2&& y2 > y1){
			if (y2 - y1 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y1][z1] = 0;
					array[1][y2][z2] = 2;
					sysprint("DOWN");
					return;
				}
				else {
					array[1][y1][z1] = 1;
					array[1][y2][z2] = 1;
					sysprint("DOWN");
					return;
				}
			}
			else if (array[0][y2][z1] == array[0][y2-1][z2]){
				array[1][y2][z2] = 2;
				array[1][y2-1][z2] = 0;
				translate(0 ,y1 ,z2 ,0 ,y2-2 ,z1 ,array);
			}
			else if (array[0][y2][z1] != array[0][y2-1][z2]){
				array[1][y2-1][z2] = 1;
				array[1][y2][z2] = 1;
				translate(0 ,y1 ,z2 ,0 ,y2-1 ,z1 ,array);
			}
			
		}
		
		//right
		if(y1 == y2&& z2 > z1){
			if (z2 - z1 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y2][z2] = 2;
					array[1][y2][z1] = 0;
					sysprint("RIGHT");
					return;
				}
				else {
					array[1][y2][z2] = 1;
					array[1][y2][z1] = 1;
					sysprint("RIGHT");
					return;
				}
			}
			else if (array[0][y1][z2] == array[0][y2][z2 - 1]){
				array[1][y1][z2] = 2;
				array[1][y2][z2 - 1] =0;
				translate(0 ,y1 ,z1 ,0 , y2 ,z2-2 , array);
			}
			else if (array[0][y1][z2] != array[0][y2][z2 - 1]){
				array[1][y1][z2] = 1;
				array[1][y2][z2-1] =1;
				translate(0 ,y1 ,z1,0 , y1 ,z2 -1 , array);
			}
		}
		
		//left
		if(y1 == y2&& z2 < z1){
			if (z1 - z2 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y1][z2] = 2;
					array[1][y2][z1] =0;
					sysprint("LEFT");
					return;
				}
				else {
					array[1][y1][z1] = 1;
					array[1][y2][z2] = 1;
					sysprint("LEFT");
					return;
				}
			}
			else if (array[0][y1][z2] == array[0][y2][z2+1]){
				array[1][y1][z2] = 2;
				array[1][y1][z2+1] =0;
				translate(0 , y1 ,z1 , 0, y1, z2+2, array);
			}
			else if (array[0][y1][z2] != array[0][y2][z2+1]){
				array[1][y1][z2] = 1;
				array[1][y1][z2+1] =1;
				translate(0 , y1 ,z1 , 0, y1, z2+1, array);
			}
		}
		}
	
	//数组重新赋值
	public  static int [][][]  reAssign (int [][][] array){
		
		//数值变化
		for (int i = 0 ; i < array[0].length ; i++){
			for (int j = 0; j<array[0][0].length ;j++){
				array[0] [i][j]= array[0][i][j]*array[1][i][j];
			}
		}
		

		return array;
	}
	
	public static void sysprint( String string){
		
		System.out.println( string + " ");
	}
	
	public static void translate(int [][][] array,String string){
		
		if (string == "LEFT"){
			for (int i = 0 ; i < array[0].length ; i++){
				translate(0,i,array[0][i].length - 1,
						0,i,0,
						array);
			}
			reAssign(array);
			ArrayMoveTestNew.moveArray(array[0],string);
			ArrayUtils.createNewNum(array[0]);
		}
		
		if (string == "RIGHT"){
			for (int i = 0; i< array[0].length ; i++){
				translate(0,i,0,
						0,i,array[0][i].length - 1,
						array);
			}
			reAssign(array);
			ArrayMoveTestNew.moveArray(array[0],string);
			ArrayUtils.createNewNum(array[0]);
		}
		
		if (string == "UP"){
			for (int i = 0 ; i< array[0][0].length ; i++){
				translate(0,array[0].length -1,i,
						0,0,i,
						array);
			}
			reAssign(array);
			ArrayMoveTestNew.moveArray(array[0],string);
			ArrayUtils.createNewNum(array[0]);
		}
		
		if (string == "DOWN"){
			for (int i = 0 ; i< array[0][0].length ; i++){
				translate(0,0,i,
						0,array[0].length -1,i,
						array);
			}
			reAssign(array);
			ArrayMoveTestNew.moveArray(array[0],string);
			ArrayUtils.createNewNum(array[0]);
		}
	}
}
