package registrationSysytem;

import java.util.ArrayList;
import java.util.List;

public class CourseOffering {
	
	private int sectionNum;
	private int sectionCap;
	private Course course;
	private ArrayList<Registration> studentList;
	
	
	
	public CourseOffering(int sectionNum, int sectionCap) {
		this.sectionNum = sectionNum;
		this.sectionCap = sectionCap;
		studentList = new ArrayList<Registration>();
	}
	
	
	
	public void addRegistration(Registration reg) {
		studentList.add(reg);
	}
	
	public void deleteRegistration(Registration reg) {
		// TODO Auto-generated method stub
		studentList.remove(reg);
	}
	
	
    

	public int getSectionNum() {
		return sectionNum;
	}



	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}



	public int getSectionCap() {
		return sectionCap;
	}



	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}



	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	public String courseInfo() {
		String s = course.getCourseName() + " " + course.getCourseNumber() + ", Section " + sectionNum;
		return s;
	}



	public ArrayList<Registration> getStudentList() {
		return studentList;
	}
	
	








	
	
	
	

}
