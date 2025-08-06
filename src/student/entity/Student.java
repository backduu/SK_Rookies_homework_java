package student.entity;
import student.exception.*;

public class Student{
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String studentId, String name, String major, int grade) {
		// TODO Auto-generated constructor stub
		this.studentId = studentId;
		this.major = major;
		this.name = name;
		this.grade = grade;
	}
	
	public String getStudentId() { return studentId;}
	public String getName() { return name; }
	public String getMajor() { return major; }
	public int getGrade() { return grade; }
	
	public void setGrade(int grade) throws InvalidSettingException
	{ 
		if(grade > 4) {
			throw new InvalidSettingException("학년은 1~4 사이여야 합니다.");
		} else {
			this.grade = grade; 
		}
	}
}
