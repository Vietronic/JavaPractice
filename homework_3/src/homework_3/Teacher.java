package homework_3;

public class Teacher extends Person{
	private int id;
	private String post;
	private String signDate;
	
	public Teacher(){
		super();
		this.id = -1;
		this.post = "����";
		this.signDate = "����";
	}
	
	public Teacher( String name, int sex, String birth, int id, String post, String signDate){
		super( name, sex, birth);
		this.id = id;
		this.post = post;
		this.signDate = signDate;
	}
	
	public void getInfo(){
		super.getInfo();
		
		System.out.print("��ţ�");
		System.out.println(id);
		
		System.out.print("ְ��:");
		
		System.out.println(post);
		
		System.out.print("ǩ������֤���ڣ�");
		System.out.println(signDate);
	}
	
}
