package student.control;
import exception.InvalidSettingException;
import student.entity.Student;

public class StudentTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Student backduu = new Student("100", "�����", "��ǻ�Ͱ��а�", 4);
		
		try {
			backduu.setGrade(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
