package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return  runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// finding the course
		System.out.println("Finding course id:  "+theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Programming Pathsala Master Data Structure and Algorithms");
		appDAO.update(tempCourse);
		System.out.println("Done!");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		//find instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("SIJAPATI Baduwal");
		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("The associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associate courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// Create the Instructor
		Instructor tempInstructor =
				new Instructor(
						"Khagendra", "Baduwal",
						"mbaduwal@luv2code.com");


		// Create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.bajcode.com/kbaduwal",
						"OM Shanti !!!");



		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//Create some courses
		Course tempCourse1 = new Course("Master Data Structures and Algorithms");
		Course tempCourse2 = new Course("Master Java Backend Developer");

		// Add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will save the courses
		// Because of CascadeType.PERSIST
		//
		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("The course: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("DONE!!!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: "+theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);

		// print the associated instructor
		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding the instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructionDetail only: "+ tempInstructor.getInstructorDetail() );
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// Create the Instructor
		Instructor tempInstructor =
				new Instructor(
						"Chad", "Darby",
						"darby@luv2code.com");


		// Create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code !!!");
		*/

		// Create the Instructor
		Instructor tempInstructor =
				new Instructor(
						"Manoj", "Baduwal",
						"mbaduwal@luv2code.com");


		// Create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/mbaduwal",
						"Luv 2 sing !!!");



		// associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will also save the detail object
		// Because of CascadeType.ALL
		//
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");


	}

}









