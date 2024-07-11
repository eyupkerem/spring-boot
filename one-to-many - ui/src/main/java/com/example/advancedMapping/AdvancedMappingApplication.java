package com.example.advancedMapping;

import com.example.advancedMapping.dao.AppDAO;
import com.example.advancedMapping.entity.Course;
import com.example.advancedMapping.entity.Instructor;
import com.example.advancedMapping.entity.InstructorDetail;
import com.example.advancedMapping.entity.Review;
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

		//	createCourseAndReviews(appDAO);

			retrieveCourseAndReviews(appDAO);


		};
	}


	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse = new Course("Spring 101");

		tempCourse.addReview(new Review("Great Course"));
		tempCourse.addReview(new Review("Zero to hero course"));
		tempCourse.addReview(new Review("what a dumb course"));

		appDAO.saveCourse(tempCourse);

	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int id=10;

		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(tempCourse.toString());

		System.out.println(tempCourse.getReviews());

	}








}
