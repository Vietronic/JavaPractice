package homework_1;

public class matrix {
	private int [][] maze;
	private int length;
	
	// ���캯�����ɾ���
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
	
	// �����ӡ����
	public void printMatrix(){
		System.out.println("�������£�");
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				System.out.print(maze[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	// ��ȡ����������
	public int getLength(){
		return length;
	}
	
	public boolean checkMagic(){
		// ������Ľ������������
		int[][] checkNum = new int[3][length];
		
		// ��ȡ��ֵ֮��
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				checkNum[0][i] += maze[i][j];
			}
		}
		
		// ��ȡ��ֵ֮��
		for(int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				checkNum[1][j] += maze[i][j];
			}
		}
		
		// ��ȡ�Խ���֮��
		for(int i=0, j=length-1; i<length; i++, j--){
			checkNum[2][0] += maze[i][i];
			checkNum[2][1] += maze[i][j];
		}
		
		// ��ӡ�������
		System.out.println("����������£�");
		for(int i=0; i<3; i++){
			for(int j=0; j<length; j++){
				System.out.print(checkNum[i][j]+" ");
			}
			System.out.print("\n");
		}
		
		// ��������ֵ�Ƿ����
		for(int i=0; i<2; i++){
			for(int j=0; j<length; j++){
				if(checkNum[0][0]!=checkNum[i][j]){
					return false;
				}
			}
		}
		// ����Խ���ֵ�Ƿ����
		if(checkNum[0][0]!=checkNum[2][0] || checkNum[0][0]!=checkNum[2][1]){
			return false;
		}
		
		// ����ͨ��
		return true;
	}
	
}
