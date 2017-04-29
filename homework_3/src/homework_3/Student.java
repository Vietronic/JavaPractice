package homework_3;

public class Student extends Person {
	private int id;
	private String depart;
	private String enterDate;
	private String signInfo;
	
	public Student(){
		super();
		this.id = -1;
		this.depart = "����";
		this.enterDate = "����";
		this.signInfo = "����";
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
		
		System.out.print("��ţ�");
		System.out.println(id);
		
		System.out.print("ϵ��:");
		
		System.out.println(depart);
		
		System.out.print("��У���ڣ�");
		System.out.println(enterDate);
		
		System.out.print("ע����Ϣ��");
		System.out.println(signInfo);
	}
}
