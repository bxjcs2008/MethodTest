package View;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayTest at = new ArrayTest();
		at.a = ArrayUtils.narry;
		at.translate(0, 0, 0, 0, 0, 2, at.a);
		//System.out.println(at.a[0][0][0] + " " + at.a[0][1][0]);
		ArrayUtils.displayArray(at.a);
	}

	private int [][][] a = new int [3][3][2];
	
	
	//显示数组中所有数字
	private void display(int a [][][]){
		for (int i = 0;i<3;i++){
			for (int j = 0;j <3;j++){
				System.out.print(a[0][i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	//数组translate   起点(x1,y1,z1)    终点(x2,y2,z2)
	private void translate(int x1,int y1,int z1,int x2,int y2,int z2,int [][][] array){
		
		//两点重合的情况
		if (y2 == y1 && z2 == z1){
			array[1][x1][y1] = 1;
			array[1][x2][y2] = 1;
			return;
		}
		
		//up
		if(z1 == z2&& y1 > y2){
			if (y2 - y1 == 1) {
					if (array[0][y1][z1] == array[0][y2][z2]) {
						array[1][y2][z2] = 2;
						array[1][y1][z1] = 0;
						return;
					} else {
						array[1][y2][z2] = 1;
						array[1][y1][z1] = 1;
						return;
					}
			}
			else if(x2!=x1&&array[0][y2][z1] ==array[0][y2+1][z2]){
				array[1][y2][z2] = 2;
				array[1][y2+1][z2] = 0;
				translate(0,y2+2 ,z2 ,0 , y1, z1,array);
			}
			else if(x2!=x1&&array[0][y2][z1] !=array[0][y2+1][z2]){
				array[1][y2][z2] = 1;
				array[1][y2+1][z2] = 1;
				translate(0 ,y2+1 ,z2 ,0, y1, z1,array);
			}
		}
		
		//down
		if(z1 == z2&& y2 > y1){
			if (y1 -y2 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y1][z1] = 0;
					array[1][y2][z2] = 2;
					return;
				}
				else {
					array[1][y1][z1] = 1;
					array[1][y2][z2] = 1;
					return;
				}
			}
			else if (array[0][y2][z1] == array[0][y2+1][z2]){
				array[1][y2+1][z2] = 2;
				array[1][y2][z2] = 0;
				translate(0 ,y2+2 ,z2 ,0 ,y1 ,z1 ,array);
			}
			else if (array[0][y2][z1] != array[0][y2+1][z2]){
				array[1][y2+1][z2] = 1;
				array[1][y2][z2] = 1;
				translate(0 ,y2+1 ,z2 ,0 ,y1 ,z1 ,array);
			}
			
		}
		
		//left
		if(y1 == y2&& z2 < y1){
			if (z1 - z2 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y2][z2] = 2;
					array[1][y2][z1] = 0;
					return;
				}
				else {
					array[1][y2][z2] = 1;
					array[1][y2][z1] = 1;
					return;
				}
			}
			else if (array[0][y1][z2] == array[0][y2][z2+1]){
				array[0][y1][z2] = 2;
				array[0][y2][z2+1] =0;
				translate(0 ,y2 ,z2+2 ,0 , y1 ,z1 , array);
			}
			else if (array[0][y1][z2] != array[0][y2][z2+1]){
				array[0][y1][z2] = 1;
				array[0][y2][z2+1] =1;
				translate(0 ,y2 ,z2+1 ,0 , y1 ,z1 , array);
			}
		}
		
		//right
		if(y1 == y2&& z2 > z1){
			if (z2 - z1 ==1){
				if (array[0][y1][z1] == array[0][y2][z2]){
					array[1][y1][z1] = 2;
					array[1][y2][z2] =0;
					return;
				}
				else {
					array[1][y1][z1] = 1;
					array[1][y2][z2] = 1;
					return;
				}
			}
			else if (array[0][y1][z1] == array[0][y2][z1+1]){
				array[1][y1][z1] = 2;
				array[1][y1][z1+1] =0;
				translate(0 , y1 ,z1+2 , 0, y1, z2, array);
			}
			else if (array[0][y1][z1] != array[0][y2][z1+1]){
				array[1][y1][z1] = 1;
				array[1][y1][z1+1] =1;
				translate(0 , y1 ,z1+1 , 0, y1, z2, array);
			}
		}
		}
	
	//数组重构
	public  int [][][]  relocate (int [][][] a, String type){
		
		//数值变化
		for (int i = 0 ; i<3; i++){
			for (int j = 0; j<3;j++){
				a[i][j][0] = a[i][j][0]*a[i][j][1];
			}
		}
		
		//数值移动
		if (type == "LEFT"){
			for(int i = 0;i < 3;i++){
				for(int j = 0; j < 3;j++){
					while (a[i][j][0] == 0){
						a[i][j][0] = a[i][j+1][0];
						a[i+1][j][0] = 0;
					}
				}
			}
		}
		return a;
	}
}
