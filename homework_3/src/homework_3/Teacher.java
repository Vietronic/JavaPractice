package homework_3;

public class Teacher extends Person{
	private int id;
	private String post;
	private String signDate;
	
	public Teacher(){
		super();
		this.id = -1;
		this.post = "不详";
		this.signDate = "不详";
	}
	
	public Teacher( String name, int sex, String birth, int id, String post, String signDate){
		super( name, sex, birth);
		this.id = id;
		this.post = post;
		this.signDate = signDate;
	}
	
	public void getInfo(){
		super.getInfo();
		
		System.out.print("编号：");
		System.out.println(id);
		
		System.out.print("职务:");
		
		System.out.println(post);
		
		System.out.print("签发工作证日期：");
		System.out.println(signDate);
	}
	
}
