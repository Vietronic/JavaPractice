package homework_2;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	
	public QuadraticEquation() {
		// TODO Auto-generated constructor stub
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}
	
	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getA(){
		return this.a;
	}
	
	public double getB(){
		return this.b;
	}
	
	public double getC(){
		return this.c;
	}
	
	// 获取根的数量
	public int getRootNum(){
		double checkNum = b * b - 4 * a * c;
		
		if (checkNum == 0){
			return 1;
		}else if(checkNum > 0){
			return 2;
		}else return 0;
	}
	
	// 获取根
	public void getRoot(){
		double checkNum = b * b - 4 * a * c;
		
		// 有单根时
		if (checkNum == 0){
			// 判断结果为0的情况，防止-0.0出现，并提高速度
			if( b == 0){
				System.out.println("此方程仅有一重根，为：0");
			}else{
				double x = - ( (b) /( 2 * a ));
				System.out.println("此方程仅有一重根，为：" + x);
			}
			
		// 两根时
		}else if(checkNum > 0){
			// 提前运算根的判别式的分母部分
			double x1Denominator = (-b) + Math.sqrt(checkNum);
			double x2Denominator = (-b) - Math.sqrt(checkNum);
			
			double x1, x2;
			
			// 判断结果为0的情况，防止-0.0出现，并提高速度
			if( x1Denominator == 0){
				x1 = 0;
				x2 = ( x2Denominator)/( 2 * a );
			}else if( x2Denominator == 0){
				x1 = ( (-b) + Math.sqrt(checkNum))/( 2 * a );
				x2 = 0;
			}else{
				x1 = ( (-b) + Math.sqrt(checkNum))/( 2 * a );
	            x2 = ( (-b) - Math.sqrt(checkNum))/( 2 * a );
			}
			                    
            System.out.println("此方程有两个根，分别为： " + "x1 = " + x1 + ", x2 = " + x2);
		}else ;
	}
	
	// 两根之和
	public double getSum(){
		double sum;
		if( b == 0){
			sum = 0;
		}else{
			sum = - b / a;
		}
		System.out.println("两根之和为： " + sum);
		return sum;
	}
	
	// 两根之积
	public double getProduct(){
		double product;
		if( c == 0){
			product = 0;
		}else{
			product = c / a;
		}
		System.out.println("两根之积为： " + product);
		
		return product;
	}
	
	
	// 对称轴
	public double getAxis(){
		double axis;
		if( b == 0){
			axis = 0;
		}else{
			axis = - b / ( 2 * a );
		}
		System.out.println("对称轴为： x = " + axis);		
		return axis;
	}
	
	// 重载equals方法
	public boolean equals(QuadraticEquation obj){
		// 
		if(this.getA() == obj.getA() && this.getB() == obj.getB() && this.getC() == obj.getC()){
			return true;
		}else	return false;
	}
	
	// 重载toString方法
	public String toString(){
		return "方程为： (" + a + ") * X^2 + (" + b + ") * X + (" + c +")";
	}
}