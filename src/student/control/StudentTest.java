package student.control;
import exception.InvalidSettingException;
import student.entity.Student;

public class StudentTest {

	public static void main(String[] args) throws InvalidSettingException {
		// TODO Auto-generated method stub
		Student backduu = new Student("100", "백두현", "컴퓨터공학과", 4);
		
		backduu.setGrade(5);
	}

}
