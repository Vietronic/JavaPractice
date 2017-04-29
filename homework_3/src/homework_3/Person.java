package homework_3;

public class Person {
	private String name;
	private int sex;
	private String birth;
	
	public Person(){
		this.name = "佚名";
		this.sex = -1;
		this.birth = "不详";
	}
	
	public Person( String name, int sex, String birth ){
		this.name = name;
		this.sex = sex;
		this.birth = birth;
	}
	
	public void getInfo(){
		System.out.print("姓名：");
		System.out.println(name);
		
		System.out.print("性别：");
		
		String sexText = "不详";
		if( sex == 1)
			sexText = "男";
		else if ( sex == 0)
			sexText = "女";
		
		System.out.println(sexText);
		
		System.out.print("出生日期：");
		System.out.println(birth);
	}
}
