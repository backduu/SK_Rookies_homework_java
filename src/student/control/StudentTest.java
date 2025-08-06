package student.control;
import exception.InvalidSettingException;
import student.entity.Student;

public class StudentTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Student backduu = new Student("100", "백두현", "컴퓨터공학과", 4);
		
		try {
			backduu.setGrade(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
