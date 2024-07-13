package com.example.advancedMapping;

import com.example.advancedMapping.dao.AppDAO;
import com.example.advancedMapping.entity.*;
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

		//	createCourseAndStudents(appDAO);

		//	findCourseAndStudents(appDAO);

			findCourseAndStudentsByStudentId(appDAO);





		};
	}

	private void findCourseAndStudentsByStudentId(AppDAO appDAO) {
		int id=1;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Student : " + student);

		System.out.println("Student courses : " + student.getCourses());

	}

	/*
	private void findCourseAndStudents(AppDAO appDAO) {

		int id=10;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Course Name : " + tempCourse.getTitle());
		System.out.println("Students : " + tempCourse.getStudents());

	}
	 */

	/*
	private void createCourseAndStudents(AppDAO appDAO) {

		Course course = new Course("Java 102");

		Student student1=new Student("Alex","Doe","alexdoe@test.com");
		Student student2=new Student("Chaby","Darby","chaby@test.com");
		Student student3=new Student("Mary","Jo","maryJoe@test.com");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		System.out.println("Course : " + course.toString());
		System.out.println("Students : " + student1.toString() + student2.toString() + student3.toString());

		appDAO.saveCourse(course);
	}
	 */



}
