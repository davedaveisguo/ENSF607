package registrationSysytem;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {
	
	private Scanner scan;
	private CourseCatalogue cat = new CourseCatalogue();
	
	public FrontEnd() {
		scan = new Scanner(System.in);
	}
	
	
	
	public void printHeader() {
		System.out.println("------------------------------------------------------");
		System.out.println("\nPlease choose from one of the following options:\n" + "1. Search Catalogue Courses\n"
				+ "2. Add course to student courses\n" + "3. Remove course from student courses\n"
				+ "4. View All courses in catalogue\n" + "5. View all courses taken by student\n" + "6. Quit System\n"
				+ "Please enter option number: \n");
		System.out.println("------------------------------------------------------");
	}
	
	
	public boolean mainMenu() {
		while (true) {
			printHeader();

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				searchCat();
				break;
			case 2:
				registerForCourse();
				break;
			case 3:
				dropCourse();
				break;
			case 4:
				getCourseList();
				break;
			case 5:
				printRegList();
				break;
			case 6:
				System.out.println("System Logged out.");
				return false;
			default:
				System.out.println("Invalid selection. Please try again.\n");
				break;
			}
		}
	}
	
	private void checkCourseRunnable() {
		System.out.println("Please enter course name:\n");
		String courseName = scan.next();
		System.out.println("Enter course number:\n");
		int courseNum = scan.nextInt();
		Course foundCourse = cat.searchCat(courseName, courseNum);
		foundCourse.getOfferingList();
	}
	
	
	private void searchCat() {
		System.out.println("Please enter course name:\n");
		ArrayList<Course> foundCourse = cat.searchCat(scan.next());
		printSearchedCourseList(foundCourse);
	}
	
	private void printSearchedCourseList(ArrayList<Course> foundCourse) {
		System.out.println("The following courses are the ones match your criteria: \nCourse Name\tCourse ID");
		for (Course c : foundCourse) {
			System.out.println(c.getCourseName() + "\t\t" + c.getCourseNumber());
		}
	}
	
	
	private void registerForCourse() {
		// get specific student
		Student userStudent = searchForStudent();

		System.out.println("Enter course name:\n");
		String courseName = scan.next();
		System.out.println("Enter course number:\n");
		int courseNum = scan.nextInt();
		System.out.println("Enter section number:\n");
		int sectionNum = scan.nextInt();

		userStudent.registerForCourse(cat, courseName, courseNum, sectionNum);
		
	}
	
	private Student searchForStudent() {
		System.out.println("Enter student ID:\n");
		int studentId = scan.nextInt();
		Student st = cat.searchForStudent(studentId);
		if (st == null) {
			System.out.println("Enter student name: \n");
			st = new Student(scan.next(), studentId);
		}
		System.out.println(st.toString());
		return st;
	}
	
	private void dropCourse() {
		Student userStudent = searchForStudent();

		System.out.println("Enter course name:\n");
		String courseName = scan.next();
		System.out.println("Enter course number:\n");
		int courseNum = scan.nextInt();
		System.out.println("Enter section number:\n");
		int sectionNum = scan.nextInt();

		userStudent.dropCourse(cat, courseName, courseNum, sectionNum);
	}
	
	private void getCourseList() {
		cat.printCourseList();
	}
	
	private void printRegList() {
		Student userStudent = searchForStudent();
		System.out.println("Complete registration history of this student:");
		userStudent.printRegList();
	}
	
	
	private void createTestingObjects() {

		cat.createOffering(cat.getCourseList().get(0), 1, 100);
		cat.createOffering(cat.getCourseList().get(1), 1, 100);
		cat.createOffering(cat.getCourseList().get(2), 1, 100);
		cat.createOffering(cat.getCourseList().get(3), 1, 100);

		Student st1 = new Student("Student1", 00001); // no registration history
		Student st2 = new Student("Student2", 00002); // finished 591 and 592
		st2.registerForCourse(cat, "ENSF", 591, 1);
		st2.getCourseList().get(0).setGrade('A');
		st2.registerForCourse(cat, "ENSF", 592, 1);
		st2.getCourseList().get(1).setGrade('A');
		Student st3 = new Student("Student3", 00003); // registered 591 and 592, but failed 591
		st3.registerForCourse(cat, "ENSF", 591, 1);
		st3.getCourseList().get(0).setGrade('F');
		st3.registerForCourse(cat, "ENSF", 592, 1);
		st3.getCourseList().get(1).setGrade('B');
		Student st4 = new Student("Student4", 00004); // only finished 591
		st4.registerForCourse(cat, "ENSF", 591, 1);
		st4.getCourseList().get(0).setGrade('A');
	}
	
	
	public static void main(String[] args) {
		
		
		FrontEnd app = new FrontEnd();
		app.createTestingObjects();
		app.mainMenu();
		
		
	}

}
