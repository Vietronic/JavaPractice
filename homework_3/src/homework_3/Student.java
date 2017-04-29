package homework_3;

public class Student extends Person {
	private int id;
	private String depart;
	private String enterDate;
	private String signInfo;
	
	public Student(){
		super();
		this.id = -1;
		this.depart = "不详";
		this.enterDate = "不详";
		this.signInfo = "不详";
	}
	
	public Student( String name, int sex, String birth, int id, String depart, String enterDate, String signInfo){
		super( name, sex, birth);
		this.id = id;
		this.depart = depart;
		this.enterDate = enterDate;
		this.signInfo = signInfo;
	}
	
	public void getInfo(){
		super.getInfo();
		
		System.out.print("编号：");
		System.out.println(id);
		
		System.out.print("系别:");
		
		System.out.println(depart);
		
		System.out.print("入校日期：");
		System.out.println(enterDate);
		
		System.out.print("注册信息：");
		System.out.println(signInfo);
	}
}
