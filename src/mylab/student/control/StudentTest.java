package mylab.student.control;
import mylab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Student minsu = new Student("100", "��μ�", "��ǻ�Ͱ���", 3);
		int gradeForChange = 5;
		
		try {
			System.out.println(minsu.getName() + " / " + minsu.getMajor() + " / " + minsu.getGrade() + "�г�");
			System.out.printf("%d�г����� ����\n", gradeForChange);
			minsu.setGrade(gradeForChange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
