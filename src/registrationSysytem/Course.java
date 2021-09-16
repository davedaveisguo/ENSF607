package registrationSysytem;

import java.util.ArrayList;

public class Course {
	
	private String courseName;
	private int courseNumber;
	private ArrayList<Course> preReq;
	private ArrayList<CourseOffering> offeringList;
	
	
	public Course(String courseName, int courseNumber) {
		super();
		this.courseName = courseName;
		this.courseNumber = courseNumber;
		preReq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
		
	}
	
	public void addOffering(CourseOffering theOffering) {
		offeringList.add(theOffering);
	}


	public ArrayList<Course> getPreReq() {
		return preReq;
	}


	public void setPreReq(ArrayList<Course> preReq) {
		this.preReq = preReq;
	}


	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}


	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}


	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	
	
	@Override
	public String toString() {
		String st = "";
		st += courseName + " " + courseNumber + "\n";
		for (CourseOffering offering : offeringList)
			st += offering; // I need to have a toString in Offering
		return st;
	}


    
	
	
	
	

}
