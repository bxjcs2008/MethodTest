package View;

public class ArrayMoveTestNew {
	
	public static int ARRAY_SIZE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayMoveTest amt = new ArrayMoveTest();
		amt.display(moveArray(amt.array, "RIGHT"));
	}
	
	//��һά�����е� �ǡ�0�� Ԫ�������ƶ�
	//e1.   m < array.length  - 1  (����Խ�����)
 		public static int [] movArrayLeft(int [] array , String type){
			
			for (int i = 0; i < array.length ;i++ ){
				for (int counter = 1; array[i] == 0&& counter <=array.length ; counter++ ){
					for (int m = i ; m < array.length -1 ; m++){
						array[m] = array[m+1];
						array[m+1] = 0;
					}
				}
			}
			return array;
		}
		
		//��4*4�����еķǡ�0��Ԫ�����������ƶ�
		public static int [][] moveArray(int [][] array, String type){
			
			int [] test1 = new int [array[0].length];
			int [] test2 = new int [array[0].length];
			int [] test3 = new int [ARRAY_SIZE];
			int [] test4 = new int [ARRAY_SIZE];
			
			if (type == "LEFT"){
				for (int i = 0 ; i < array.length; i++){
					for (int j = 0 ; j < array[i].length ; j++){
						test1[j] = array[i][j];
					}
					test1  = movArrayLeft(test1,"LEFT");
					
					
					//ע�ⲻ��д�� array[i] = test1; ( ���ô��ݣ�û��ʵ��ֵ����)
					for (int j =0 ; j <array[i].length ; j++){
						array[i][j] = test1[j];
					}
				}
			}
			
							if (type =="RIGHT"){
								for (int i = 0 ; i < array.length ; i++){
									for (int j = array[i].length - 1 ; j >= 0  ;j--){
										test2[array[i].length - 1 -j ] = array[i][j];
									}
									test2 = movArrayLeft(test2,"RIGHT");
									for (int j = array[i].length - 1 ; j>= 0; j--){
										array[i][j] = test2[array[i].length - 1 -j];
									}
								}
							}
			
							if (type == "UP"){
								for (int j =0 ;j<array[0].length ; j++ ){
									for (int i = 0 ; i < array.length ; i++){
										test2[i] = array[i][j];
									}
									test2 = movArrayLeft(test2,"UP");
									for (int i = 0 ; i <array.length ; i++){
										array[i][j] = test2[i];
									}
								}
							}
					
							if (type == "DOWN") {
								for (int j = 0 ; j<array[0].length ;j++){
									for (int i = array.length -1 ; i >=0 ; i--){
										test2[array.length -1 - i] = array[i][j];
									}
									test2 = movArrayLeft(test2,"DOWN");
									for (int i = array.length - 1 ; i >= 0 ; i--){
										array[i][j] = test2[array.length-1-i];
									}
								}
							}
					
			return array;
		}

}
