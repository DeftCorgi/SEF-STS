package com.model;

import java.util.ArrayList;
import java.io.*;
import java.util.GregorianCalendar;
import java.util.Map;
import com.view.StudentProgressSystem;

public abstract class AdvancedUser extends User {


	public AdvancedUser(String id, String name, String password) {
		super(id, name, password);
	}
	
	public void editProgram() {
		boolean loop = true;
		String idInput;
		int selection;
		Program temp;
		
		while(loop) {
			System.out.println("Enter the ID of the program you would like to edit: ");
			idInput = StudentProgressSystem.scanner.next();
			
			temp = Storage.getProgram(idInput);
			
			if(temp == null) {
				System.out.println("No program with that ID code. Please try again: ");
				continue;
			}
			
			do {
				//show user menu how they can edit programs
				System.out.println("How would you like to edit \"" + temp.getProgramCode() + "\"");
				System.out.println("1 - Set credit points needed");
				System.out.println("2 - Set core courses");
				System.out.println("3 - Set specialization courses");
				System.out.println("4 - back");
				
				//get user input
				selection = StudentProgressSystem.scanner.nextInt();
				
				//run a method based on user's selection
				switch(selection) {
				case 1:
					setCreditPointsNeeded(temp);
					break;
				case 2:
					//setCoreCourses();
					break;
				case 3:
					setSpecializationCourses(temp);
					break;
				case 4:
					loop = false;
					break;
				default:
					System.out.println("That isn't an option, please try again.");
					break;
				}
			} while(loop);
		}
	}

	public void setCreditPointsNeeded(Program program) {
		int creditPoints;
		
		//prompt user for the credit points required
		System.out.println("How many credit points would you like " + program.getProgramCode() +" to require? ");
		creditPoints = StudentProgressSystem.scanner.nextInt();
		
		//set the credit points
		program.setRequiredCredits(creditPoints);
		
		//give user feedback
		System.out.println(program.getProgramCode() + "'s credit points have been set to " + creditPoints);
	}

	public void setCoreCourses(Program program, ArrayList<Course> course) {
		
	}

	public void setSpecializationCourses(Program program, ArrayList<Course> courses, String specialization, SpecializationMode mode) {

	}

	public void setSpecializationCourses(Program program) {

	}

	public void createStudentAccount() {
		System.out.println("Enter the student's ID");
		String inputId = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's password");
		String inputPassword = StudentProgressSystem.scanner.next();

		System.out.println("Enter the student's Name");
		String inputName = StudentProgressSystem.scanner.next();

		createStudentAccount(inputId, inputPassword, inputName);
	}

	protected void createStudentAccount(String userId, String password, String fullName) {
		System.out.println("Please enter the student's birthdate (day only)");
		StudentProgressSystem.scanner.useDelimiter("/");
		int day = StudentProgressSystem.scanner.nextInt();
		System.out.println("Please enter the student's birth month");
		int month = StudentProgressSystem.scanner.nextInt();
		System.out.println("Please enter the student's birth year");
		int year = StudentProgressSystem.scanner.nextInt();
		StudentProgressSystem.scanner.reset();

		System.out.println("Please enter the student's email.");
		String email = StudentProgressSystem.scanner.next();

		@SuppressWarnings("unused")
		Student student = new Student(userId, fullName, password, new GregorianCalendar(year, month, day), email);

		System.out.println("You have just created an account with the user name " + userId + "and password " + password + ".\n"
				+ "This account is now ready to be used.");
	}

	// Allows Advanced users to create bulk student accounts by uploading them in a file
	public void createStudentAccounts() {
		String fileName;
		String line;
		File file;
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader reader;
		int resultDay, resultMonth, resultYear;
		boolean loop = true;
		resultDay = 0;
		resultMonth = 0;
		resultYear = 0;
		
		System.out.println("What is the name of your file?");
		

		fileName = StudentProgressSystem.scanner.next();
		file = new File(fileName);

		try {
			fis = new FileInputStream(fileName);
			isr = new InputStreamReader(fis);
			reader = new BufferedReader(isr);
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				String [] resultMember = line.split(":");
				for (int j = 0; j < resultMember.length; j++){
						//objMember[i] = new StandardMember(resultMember[0], resultMember[1]);

				}
//				System.out.println(resultMember[0]);
//				System.out.println(resultMember[1]);
//				System.out.println(resultMember[2]);
//				System.out.println(resultMember[3]);
//				System.out.println(resultMember[4]);
			String [] birthdayString = resultMember[3].split("/");
			for (int k = 0; k < birthdayString.length; k++){
				resultDay = Integer.parseInt(birthdayString[0]);
				resultMonth = Integer.parseInt(birthdayString[1]);
				resultYear = Integer.parseInt(birthdayString[2]);
			}
			System.out.println(resultDay);
			System.out.println(resultMonth);
			System.out.println(resultYear);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found please try again. or enter 'q' to quit");
		} catch (IOException e) {
			System.out.println("error reading the file");
		}

		
		
	}

	public void uploadEnrolment(Student student, Map<Course, Double> enrolments) {

	}

	public void uploadEnrolment(Map<Student, Map<Course, Double>> enrolments) {

	}
}
