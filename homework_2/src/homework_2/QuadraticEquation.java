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
	
	// ��ȡ��������
	public int getRootNum(){
		double checkNum = b * b - 4 * a * c;
		
		if (checkNum == 0){
			return 1;
		}else if(checkNum > 0){
			return 2;
		}else return 0;
	}
	
	// ��ȡ��
	public void getRoot(){
		double checkNum = b * b - 4 * a * c;
		
		// �е���ʱ
		if (checkNum == 0){
			// �жϽ��Ϊ0���������ֹ-0.0���֣�������ٶ�
			if( b == 0){
				System.out.println("�˷��̽���һ�ظ���Ϊ��0");
			}else{
				double x = - ( (b) /( 2 * a ));
				System.out.println("�˷��̽���һ�ظ���Ϊ��" + x);
			}
			
		// ����ʱ
		}else if(checkNum > 0){
			// ��ǰ��������б�ʽ�ķ�ĸ����
			double x1Denominator = (-b) + Math.sqrt(checkNum);
			double x2Denominator = (-b) - Math.sqrt(checkNum);
			
			double x1, x2;
			
			// �жϽ��Ϊ0���������ֹ-0.0���֣�������ٶ�
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
			                    
            System.out.println("�˷��������������ֱ�Ϊ�� " + "x1 = " + x1 + ", x2 = " + x2);
		}else ;
	}
	
	// ����֮��
	public double getSum(){
		double sum;
		if( b == 0){
			sum = 0;
		}else{
			sum = - b / a;
		}
		System.out.println("����֮��Ϊ�� " + sum);
		return sum;
	}
	
	// ����֮��
	public double getProduct(){
		double product;
		if( c == 0){
			product = 0;
		}else{
			product = c / a;
		}
		System.out.println("����֮��Ϊ�� " + product);
		
		return product;
	}
	
	
	// �Գ���
	public double getAxis(){
		double axis;
		if( b == 0){
			axis = 0;
		}else{
			axis = - b / ( 2 * a );
		}
		System.out.println("�Գ���Ϊ�� x = " + axis);		
		return axis;
	}
	
	// ����equals����
	public boolean equals(QuadraticEquation obj){
		// 
		if(this.getA() == obj.getA() && this.getB() == obj.getB() && this.getC() == obj.getC()){
			return true;
		}else	return false;
	}
	
	// ����toString����
	public String toString(){
		return "����Ϊ�� (" + a + ") * X^2 + (" + b + ") * X + (" + c +")";
	}
}