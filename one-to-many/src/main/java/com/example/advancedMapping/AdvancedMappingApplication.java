package com.example.advancedMapping;

import com.example.advancedMapping.dao.AppDAO;
import com.example.advancedMapping.entity.Course;
import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return args ->{
		//	createInstructor(appDAO);

		//	findInstructor(appDAO);

		//	deleteInstructor(appDAO);

		//	findInstructorDetail(appDAO);

		//	deleteInstructorDetail(appDAO);

		//	createInstructorWithCourses(appDAO);

		//	findInstructorWithCourses(appDAO);

		//	findCoursesForInstructor(appDAO);

		//	findInstructorWithCoursesJoinFetch(appDAO);

		//	updateInstructor(appDAO);

		};
	}

/*
	public void createInstructor(AppDAO appDAO){


		Instructor instructor = new Instructor("Alex","J","alexJ@spring.com");
		InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/alexJ" , "read a book");

		Instructor instructor = new Instructor("Adrian", "Z","adrianZ@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/adrian","music");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving Instructor : " + instructor);

		appDAO.save(instructor);
	}
 */



	/*
	private void findInstructor(AppDAO appDAO) {

		int id=2;

		System.out.println("Finding ınstructor with ID : " + id);

		Optional<Instructor> tempInstructor = Optional.ofNullable(appDAO.findById(id));

		System.out.println("Finded instructor : " + tempInstructor.toString());

	}
	 */
    /*
	private void deleteInstructor(AppDAO appDAO) {

		int id=1;

		appDAO.deleteInstructorById(id);
	}
     */
	/*
	private void findInstructorDetail(AppDAO appDAO) {
		int id=3;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("tempInstructorDEtail : " + instructorDetail);

		System.out.println("the associated instructor : " + instructorDetail.getInstructor());
	}
	 */

	/*
	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 6 ;

		appDAO.deleteInstructorDetailById(id);

	}
	 */


	/*
	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Rick", "Bracco","Rick@bracco.com");
		InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/RickB","cook");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Cooking 101");
		Course course2 = new Course("Grilling 101");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("saving instructor : " + instructor);
		System.out.println("The courses : " + instructor.getCourses());
		appDAO.save(instructor);


		System.out.println("Done");
	}

	 */

	/*
	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Instructor id : " + theId);

		Instructor tempInstructor =appDAO.findById(theId);

		System.out.println("Instructor  : " + tempInstructor);

		System.out.println("Courses : " + tempInstructor.getCourses());

	}
	 */
/*
	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Instructor id : " + theId);

		Instructor tempInstructor =appDAO.findById(theId);

		System.out.println("Instructor : " + tempInstructor.getFirstName() + " " + tempInstructor.getLastName());

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		for(Course course: courses){
			System.out.println(course + "\n");
		}

	}
 */

	/*
	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor : " + tempInstructor);

		System.out.println("Instructor's Courses : " + tempInstructor.getCourses());
	}
	 */

	private void updateInstructor(AppDAO appDAO){

		int id=1;

		Instructor tempInstructor = appDAO.findById(id);

		tempInstructor.setLastName("Test");

		appDAO.update(tempInstructor);

		System.out.println(tempInstructor.toString() );

	}









}
