package homework_3;

public class Person {
	private String name;
	private int sex;
	private String birth;
	
	public Person(){
		this.name = "����";
		this.sex = -1;
		this.birth = "����";
	}
	
	public Person( String name, int sex, String birth ){
		this.name = name;
		this.sex = sex;
		this.birth = birth;
	}
	
	public void getInfo(){
		System.out.print("������");
		System.out.println(name);
		
		System.out.print("�Ա�");
		
		String sexText = "����";
		if( sex == 1)
			sexText = "��";
		else if ( sex == 0)
			sexText = "Ů";
		
		System.out.println(sexText);
		
		System.out.print("�������ڣ�");
		System.out.println(birth);
	}
}
