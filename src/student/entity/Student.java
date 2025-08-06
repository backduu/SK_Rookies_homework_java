package student.entity;

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
	public void setGrade(int grade) 
	{ 
		if(grade > 4) {
			System.out.println("[error] grade는 1 ~ 4에서만 허용됩니다.");
		} else {
			this.grade = grade; 
		}
	}
}
