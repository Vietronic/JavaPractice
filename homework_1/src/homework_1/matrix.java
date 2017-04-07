package homework_1;

public class matrix {
	private int [][] maze;
	private int length;
	
	// 构造函数生成矩阵
	public matrix(){
		length = 3;
		maze = new int[length][length];
		
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				maze[i][j] = 1;
			}
		}
		maze[0][0] = 5;
		maze[0][1] = 4;
		maze[1][0] = 5;
		maze[1][1] = 4;
	}
	
	// 矩阵打印函数
	public void printMatrix(){
		System.out.println("矩阵如下：");
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	// 获取矩阵行列数
	public int getLength(){
		return length;
	}
	
	public boolean checkMagic(){
		// 将计算的结果放入数组中
		int[][] checkNum = new int[3][length];
		
		// 获取行值之和
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				checkNum[0][i] += maze[i][j];
			}
		}
		
		// 获取列值之和
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				checkNum[1][j] += maze[i][j];
			}
		}
		
		// 获取对角线之和
		for(int i=0, j=length-1; i<length; i++, j--){
			checkNum[2][0] += maze[i][i];
			checkNum[2][1] += maze[i][j];
		}
		
		// 打印检验矩阵
		System.out.println("检验矩阵如下：");
		for(int i=0; i<3; i++){
			for(int j=0; j<length; j++){
				System.out.print(checkNum[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		// 检验行列值是否相等
		for(int i=0; i<2; i++){
			for(int j=0; j<length; j++){
				if(checkNum[0][0]!=checkNum[i][j]){
					return false;
				}
			}
		}
		// 检验对角线值是否相等
		if(checkNum[0][0]!=checkNum[2][0] || checkNum[0][0]!=checkNum[2][1]){
			return false;
		}
		
		// 检验通过
		return true;
	}
	
}
