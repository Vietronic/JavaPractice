package homework_3;
import homework_3.Person;
import homework_3.Teacher;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person stu = new Student( "������", 1, "19980101", 1, "�ƿ�", "201509", "��ע��");
		stu.getInfo();
		System.out.println();
		Person tea = new Teacher( "������", 1, "19770101", 1, "��ʦ", "201509");
		tea.getInfo();
	}

}
