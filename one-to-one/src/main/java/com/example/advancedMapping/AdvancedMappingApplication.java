package com.example.advancedMapping;

import com.example.advancedMapping.dao.AppDAO;
import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

		int id=3;

		appDAO.deleteById(3);

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

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 6 ;

		appDAO.deleteInstructorDetailById(id);

	}



}
