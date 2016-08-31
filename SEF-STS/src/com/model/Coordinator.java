package com.model;

import java.io.File;
import java.util.ArrayList;

public class Coordinator extends AdvancedUser {
	
	private boolean meetRequirements;
	
	public Coordinator(String id, String name, String password, boolean meetRequirements)
	{
		super(id, name, password);
		this.meetRequirements = meetRequirements;
	}
	
	public boolean getMeetRequirements()
	{
		return meetRequirements;
	}
	
	public void setMeetRequirements(boolean meetRequirements)
	{
		this.meetRequirements = meetRequirements;
          
	}
	
	public ArrayList<Student> meetsProgramRequirement(File file, boolean meetRequirements) 
	{
		//Commented textfile is filepath
		//Read each student from file
		Scanner student = new Scanner(new File("/*students.txt*/"));
		ArrayList<Student> students = new ArrayList<Student>();
		while (student.hasNext())
		{
			students.add(student.next());
		}
		student.close();
		//test - Student Ana = new Student(1, 12)
		//test - students.add(Ana);
		//tempo code to get an idea of what's going to happen in this block
		for (Student s:students)
		{
			if(s.getCredits() == 12)
			{
				System.out.println("The student meets the program requirements.");
			}
		}
		
		return students;

	}
}
