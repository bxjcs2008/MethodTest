package View;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayTest at = new ArrayTest();
		at.a = ArrayUtils.narry;
		at.translate(0, 0, 0, 0, 2, 0, at.a);
		ArrayUtils.displayArray(at.a);
	}

	private int [][][] a = new int [3][3][2];
	
	
	//显示数组中所有数字
	private void display(int a [][][]){
		for (int i = 0;i<3;i++){
			for (int j = 0;j <3;j++){
				System.out.print(a[i][j][0]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	//数组translate   起点(x1,y1,z1)    终点(x2,y2,z2)
	private void translate(int x1,int y1,int z1,int x2,int y2,int z2,int [][][] array){
		
		//两点重合的情况
		if (x2 == x1 && y2 == y1){
			return;
		}
		
		//up
		if(y1 == y2&& x1 > x2){
			if (x2 - x1 == 1) {
					if (array[x1][y1][0] == array[x2][y2][0]) {
						array[x2][y2][1] = 2;
						array[x1][y1][1] = 0;
						return;
					} else {
						array[x2][y2][1] = 1;
						array[x1][y1][1] = 1;
						return;
					}
			}
			else if(x2!=x1&&array[x2][y1][0] ==array[x2+1][y2][0]){
				array[x2][y2][1] = 2;
				array[x2+1][y2][1] = 0;
				translate(x2+2 ,y2 ,0, x1, y1,0 ,array);
			}
			else if(x2!=x1&&array[x2][y1][0] !=array[x2+1][y2][0]){
				array[x2][y2][1] = 1;
				array[x2+1][y2][1] = 1;
				translate(x2+1 ,y2 ,0, x1, y1,0 ,array);
			}
		}
		
		//down
		if(y1 == y2&& x2 > x1){
			if (x1 -x2 ==1){
				if (array[x1][y1][0] == array[x2][y2][0]){
					array[x1][y1][1] = 0;
					array[x2][y2][1] = 2;
					return;
				}
				else {
					array[x1][y1][1] = 1;
					array[x2][y2][1] = 1;
					return;
				}
			}
			else if (array[x2][y1][0] == array[x2+1][y2][0]){
				array[x2+1][y2][1] = 2;
				array[x2][y2][1] = 0;
				translate(x2+2 ,y2 ,0 ,x1 ,y1 ,0 ,array);
			}
			else if (array[x2][y1][0] != array[x2+1][y2][0]){
				array[x2+1][y2][1] = 1;
				array[x2][y2][1] = 1;
				translate(x2+1 ,y2 ,0 ,x1 ,y1 ,0 ,array);
			}
			
		}
		
		//left
		if(x1 == x2&& y2 < y1){
			if (y1 - y2 ==1){
				if (array[x1][y1][0] == array[x2][y2][0]){
					array[x2][y2][1] = 2;
					array[x2][y1][1] = 0;
					return;
				}
				else {
					array[x2][y2][1] = 1;
					array[x2][y1][1] = 1;
					return;
				}
			}
			else if (array[x1][y2][0] == array[x2][y2+1][0]){
				array[x1][y2][0] = 2;
				array[x2][y2+1][0] =0;
				translate(x2 ,y2+2 ,0 , x1 ,y1 ,0 , array);
			}
			else if (array[x1][y2][0] != array[x2][y2+1][0]){
				array[x1][y2][0] = 1;
				array[x2][y2+1][0] =1;
				translate(x2 ,y2+1 ,0 , x1 ,y1 ,0 , array);
			}
		}
		
		//right
		if(x1 == x2&& y2 > y1){
			if (y2 - y1 ==1){
				if (array[x1][y1][0] == array[x2][y2][0]){
					array[x1][y1][1] = 2;
					array[x2][y2][1] =0;
					return;
				}
				else {
					array[x1][y1][1] = 1;
					array[x2][y2][1] =1;
					return;
				}
			}
			else if (array[x1][y1][0] == array[x2][y1+1][0]){
				array[x1][y1][1] = 2;
				array[x1][y1+1][1] =0;
				translate(x1 , y1+2 ,0 , x1, y2, 0, array);
			}
			else if (array[x1][y1][0] != array[x2][y1+1][0]){
				array[x1][y1][1] = 1;
				array[x1][y1+1][1] =1;
				translate(x1 , y1+1 ,0 , x1, y2, 0, array);
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
				for(int j = 0; j<3;j++){
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
