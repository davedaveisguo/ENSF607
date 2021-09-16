package registrationSysytem;


public class Registration {
	
    private Student student;
    private CourseOffering theOffering;
    private char grade = 'N';
	
    
    
    public Registration(Student student, CourseOffering theOffering) {
		super();
		this.student = student;
		this.theOffering = theOffering;
		addRegistration();
		System.out.println(
				"Student " + student.getStudentName() + " has been registered: " + theOffering.courseInfo());
	}



	private void addRegistration() {
		// TODO Auto-generated method stub
		student.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	public void deleteRegistration(Student theStudent, CourseOffering theOffering) {
		theStudent.deleteRegistration(this);
		theOffering.deleteRegistration(this);
		System.out.println("Student " + theStudent.getStudentName() + " has been dropped to this section.");
	}




	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public CourseOffering getTheOffering() {
		return theOffering;
	}



	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}



	public char getGrade() {
		return grade;
	}



	public void setGrade(char grade) {
		this.grade = grade;
	}



	@Override
	public String toString() {
		return theOffering.courseInfo() + ". Grade is: " + grade;
	}
	
    

}
