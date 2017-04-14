package homework_2;

import homework_2.QuadraticEquation;

public class main {

	private static void test(int a, int b, int c){
		QuadraticEquation question = new QuadraticEquation( a, b, c);
		System.out.println(question);
		System.out.println("此方程根的数量为：" + question.getRootNum());
		question.getRoot();
		question.getSum();
		question.getProduct();
		question.getAxis();
		System.out.println(' ');
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test( 1, -9, 8);
		
		test( 1, 10, -200);
		
		
	}

}