package homework_1;

import homework_1.matrix;

public class main {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		matrix maze = new matrix();
		maze.printMatrix();
		
		if( maze.checkMagic()){
			System.out.println("该矩阵是魔方阵。");
		}else{
			System.out.println("该矩阵不是魔方阵。");
		}

		
	}

}
