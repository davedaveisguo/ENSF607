package registrationSysytem;

import java.util.ArrayList;

public class CourseCatalogue {
	

	private ArrayList<Course> courseList;
	
	
	public CourseCatalogue() {
		courseList = loadFromDB();
	}
	

	// course cat initialization
	private static ArrayList<Course> loadFromDB() {
		
		ArrayList<Course> imaginaryDB = new ArrayList<Course>();
		
		Course course591 = new Course("ENSF", 591);
		Course course592 = new Course("ENSF", 592);
		Course course607 = new Course("ENSF", 607);
		course607.getPreReq().add(course591);
		course607.getPreReq().add(course592);
		
		
		Course course609 = new Course("ENSF", 609);
		course609.getPreReq().add(course592);
		course609.getPreReq().add(course591);
		
		
		imaginaryDB.add(course592);
		imaginaryDB.add(course591);
		imaginaryDB.add(course607);
		imaginaryDB.add(course609);
		
		return imaginaryDB;
		
	}
	


	
	public void listCourses() {
		for (Course c: courseList) {
			System.out.println(c);
		}
	}
	
	
    //	cat list search
	public ArrayList<Course> searchCat(String courseName) {
		ArrayList<Course> foundedCourses = new ArrayList<Course>();
		for(Course c: courseList) {
			if(c.getCourseName().equals(courseName))
			{
				foundedCourses.add(c);
			}
		}
		return foundedCourses;
	}
	
	// cat search
	public Course searchCat(String courseName, int courseNum) {
		for (Course c : courseList) {
			if (c.getCourseNumber()==courseNum && c.getCourseName().equals(courseName)) {
				return c;
			}
		}
		System.err.println("Couse " + courseName + " " + courseNum + " does NOT exist!");
		return null;
	}
	
	
	
	public void createOffering(Course theCourse, int secNum, int secCap) {
		if (theCourse != null) {
			CourseOffering theOffering = new CourseOffering(secNum, secCap);
			theOffering.setCourse(theCourse); // I set theCourse object reference in the Course
			theCourse.addOffering(theOffering);
		}
	}
	
	
	public void printCourseList() {
		for (Course c : courseList) {
			System.out.println(c.toString());
		}
	}
	
	public Student searchForStudent(int studentId) {
		for (Course c : courseList) {
			for (CourseOffering o : c.getOfferingList()) {
				for (Registration r : o.getStudentList()) {
					if (r.getStudent().getStudentId() == studentId) {
						return r.getStudent();
					}
				}
			}
		}
		return null;
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	

	
	@Override
	public String toString() {
    	String tempString = "";
    	for (Course c: courseList) {
    		tempString+=c;
		}
		return "CourseCatalogue "+ tempString;
	}



	

}
