package homework_3;
import homework_3.Person;
import homework_3.Teacher;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person stu = new Student( "王力立", 1, "19980101", 1, "计科", "201509", "已注册");
		stu.getInfo();
		System.out.println();
		Person tea = new Teacher( "喵喵喵", 1, "19770101", 1, "讲师", "201509");
		tea.getInfo();
	}

}
