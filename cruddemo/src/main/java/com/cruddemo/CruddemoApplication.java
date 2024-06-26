package com.cruddemo;

import com.cruddemo.dao.StudentDAO;
import com.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			// createStudent(studentDAO);

			 readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// findByLastname(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id=1;
		System.out.println("Following student is deleting..... with id : "+ id);
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1 ;
		System.out.println("Getting the student with id:" + id);

		Student updatingStudent = studentDAO.findById(id);

		System.out.println("Updating student : " + updatingStudent.getEmail());
		//updatingStudent.setFirstName("Rick");
		updatingStudent.setEmail("x@deneme.com");

		studentDAO.update(updatingStudent);

		System.out.println("Updated student :  " + updatingStudent.toString());

	}

	private void findByLastname(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastname("both");

		for (Student findedStudent:students){
			System.out.println(findedStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student findedStudent = studentDAO.findById(2);
		System.out.println(findedStudent.toString());
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object");
		Student student = new Student("Alex","Both","BothAlex@hotmail.com");

		System.out.println("Saving the student");
		studentDAO.save(student);

		System.out.println(student.getId());
		System.out.println(student.toString());
	}


}
