package com;

import java.util.Scanner;

import com.model.Coordinator;
import com.model.FacAdmin;
import com.model.Storage;
import com.model.Student;
import com.model.SysAdmin;
import com.model.User;

public class StudentProgressSystem {

	User currentUser;
	Scanner logInScanner;

	public StudentProgressSystem() {
		logInScanner = new Scanner(System.in);
	}

	private void fancyAdminMode() {
		@SuppressWarnings("unused")
		SysAdmin fancyAdmin = new SysAdmin("temp", "temp", "temp");
		System.out.println("fancy admin mode activated");
	}

	public void run() {
		System.out.println("Welcome to this thing. Press Enter to begin.");
		if (logInScanner.nextLine().equals("UpUpDownDownLeftRightLeftRightBA"))
			fancyAdminMode();

		validate();
		logInScanner.close();
		menu();
	}

	private void validate() {
		boolean isLoggedIn = false;
		User tempUser;

		System.out.println("Please enter your account details");
		while (!isLoggedIn) {
			System.out.println("User Name: ");
			tempUser = Storage.getUser(logInScanner.nextLine());
			if (tempUser == null) {
				System.out.println("The User Name you entered does not exist. Please try again");
				continue;
			}

			System.out.println("Pasword: ");
			String passwordEntry = logInScanner.nextLine();
			if (!tempUser.getPassword().equals(passwordEntry)) {
				System.out.println("The Password you entered does not match the user name. Please try again");
				continue;
			}

			currentUser = tempUser;
			System.out.println("Logging in...");
			isLoggedIn = true;
		}
	}

	private void menu() {
		String userId = currentUser.getId();

		if (userId.startsWith("S"))
			displayStudentMenu();
		else if (userId.startsWith("F"))
			displayFacAdminMenu();
		else if (userId.startsWith("C"))
			displayCoordinatorMenu();
		else if (userId.startsWith("A"))
			displaySysAdminMenu();
	}

	private void displayStudentMenu() {
		System.out.println("Here are your results...");
		currentUser.checkStudentResults((Student) currentUser);

	}

	private void displayFacAdminMenu() {
		System.out.println("Here are your students' results...");
		// currentUser.checkStudentResults();

	}

	private void displayCoordinatorMenu() {
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		System.out.println("1.) Check student results\n" + "2.) Create a student account\n" + "3.) Upload enrolment");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			// currentUser.checkStudentResults();
			break;
		case 2:
			// currentUser.createStudentAccount();
			break;
		case 3:
			// currentUser.uploadEnrolment();
			break;
		}
	}

	private void displaySysAdminMenu() {
		System.out.println("Hello, ." + currentUser.getId() + "What would you like to do?");
		System.out.println("1.) Set up roles\n" + "2.Set up a new program\n" + "3.) Create a student account\n" + "4.) Upload enrolment");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			// currentUser.setUpRoles();
		case 2:
			// currentUser.setUpNewProgram();
		case 3:
			// currentUser.creatStudentAccount();
		case 4:
			// currentUser.uploadEnrolment();
		}
	}

}
