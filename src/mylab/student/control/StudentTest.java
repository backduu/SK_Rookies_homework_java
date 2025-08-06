package mylab.student.control;
import mylab.student.entity.Student;

public class StudentTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Student minsu = new Student("100", "김민수", "컴퓨터공학", 3);
		int gradeForChange = 5;
		
		try {
			System.out.println(minsu.getName() + " / " + minsu.getMajor() + " / " + minsu.getGrade() + "학년");
			System.out.printf("%d학년으로 변경\n", gradeForChange);
			minsu.setGrade(gradeForChange);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
