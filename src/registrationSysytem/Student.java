package registrationSysytem;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<Registration> courseList;
	private Scanner scan = new Scanner(System.in);
	
	
	
	public Student(String studentName, int studentId) {
		super();
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		courseList = new ArrayList<Registration>();
	}
	
	public void registerForCourse(CourseCatalogue cat, String courseName, int courseNumber, int secNumber ) {
		Course myCourse = cat.searchCat(courseName, courseNumber);
		if(myCourse==null) {
			return;
		}else {
			// if course exists we look at the section
			CourseOffering theOffering = myCourse.getOfferingList().get(secNumber-1);
			if(theOffering==null) {
				System.out.println("This section does not exist. ");
				return;
			}else {
				ArrayList<Registration> newRegList = courseList;
				for (Registration r : newRegList) {
					if (r.getGrade() == 'N') {
						newRegList.remove(r);
					}
				}
				if (newRegList.size() >= 6) { // only Registration with Grade = N is counted
					System.out.println("The cap of courses allowed has been reached for this student.\n");
				} else if (checkPreReq(theOffering) == false) {
					System.out.println("Do not meet pre-requisites.");
				} else {
					Registration reg = new Registration(this, theOffering);
					
				}
			}
			
			
		}
			
	}
	
	
	
	public void dropCourse(CourseCatalogue cat, String courseName, int courseNumber, int secNumber) {
		Course myCourse = cat.searchCat(courseName, courseNumber);
		if (myCourse == null) {
			System.out.println("The selected course does not exist.");
			return;
		} else {
			CourseOffering theOffering = myCourse.getOfferingList().get(secNumber - 1);
			if (theOffering == null) {
				System.out.println("The selected section does not exist. ");
				return;
			} else {
				for (Registration r : courseList) {
					if (r.getTheOffering().equals(theOffering)) {
						r.deleteRegistration(this, theOffering);
						deleteRegistration(r);
						return;
					}
				}
			}
		}
	}
	// check if all pre-requisites passed
	private boolean checkPreReq(CourseOffering theOffering) {
		int count = 0;
		for (Course c : theOffering.getCourse().getPreReq()) {
			for (Registration r : courseList) {
				Course matchCourse = r.getTheOffering().getCourse();
				if (c.equals(matchCourse) && r.getGrade() < 'F') {
					count++;
				}
			}
		}
		if (count < theOffering.getCourse().getPreReq().size())
			return false;
		else
			return true;
	}

	
	
	public void addRegistration(Registration reg) {
		courseList.add(reg);
	}
	
	
	public void deleteRegistration(Registration reg) {
		// TODO Auto-generated method stub
		courseList.remove(reg);
	}
	
	
	public void printRegList() {
		for (Registration r : courseList) {
			System.out.println(r.toString());
		}
	}
	
	

	

	public ArrayList<Registration> getCourseList() {
		return courseList;
	}

	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

}
