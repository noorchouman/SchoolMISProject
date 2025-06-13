package com.example.demo;


import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.Club;
import com.example.demo.entities.Course;
import com.example.demo.entities.Department;
import com.example.demo.entities.Exam;
import com.example.demo.entities.GradeLevel;
import com.example.demo.entities.Parent;
import com.example.demo.entities.Registration;
import com.example.demo.entities.Result;
import com.example.demo.entities.Staff;
import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ExamRepository;
import com.example.demo.repository.GradeLevelRepository;
import com.example.demo.repository.ParentRepository;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.ResultRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TeacherRepository;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@SpringBootApplication
public class projectMISApplication {

	public static void main(String[] args) {
		SpringApplication.run(projectMISApplication.class, args);
	}
	@Bean
	OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Correspondence Service").description("Correspondence MGMT Service API").version("v1.0.0"));
	}
	@Bean
	CommandLineRunner seedData(
	        ClubRepository clubRepo,
	        CourseRepository courseRepo,
	        DepartmentRepository departmentRepo,
	        ExamRepository examRepo,
	        GradeLevelRepository gradeLevelRepo,
	        ParentRepository parentRepo,
	        RegistrationRepository registrationRepo,
	        ResultRepository resultRepo,
	        StaffRepository staffRepo,
	        StudentRepository studentRepo,
	        TeacherRepository teacherRepo
	) {
	    return args -> {
	        // Grade Levels
	        GradeLevel grade1 = gradeLevelRepo.save(GradeLevel.builder().level(1).name("Grade 1").build());

	        // Staff
	        Staff staff = new Staff();
	        staff.setName("Alice Admin");
	        staff.setAddress("Admin Street");
	        staff.setSalary(3000L);
	        staff.setRole("Registrar");
	        staff = staffRepo.save(staff);

	        // Department
	        Department department = new Department();
	        department.setName("Science");
	        department.setHead(staff);
	        department=departmentRepo.save(department);
	        staff.setDepartment(department);
	        staff=staffRepo.save(staff);

	        // Teacher
	        Teacher teacher = new Teacher();
	        teacher.setName("John Doe");
	        teacher.setAddress("Teacher Avenue");
	        teacher.setSalary(5000L);
	        teacher.setRole("Science Teacher");
	        teacher.setSubject("Biology");
	        teacher.setDepartment(department);
	        teacherRepo.save(teacher);

	        // Course
	        Course course = new Course();
	        course.setCourseName("Intro to Biology");
	        course.setTeacher(teacher);
	        course.setGradeLevel(grade1);
	        courseRepo.save(course);

	        // Exam
	        Exam exam = new Exam();
	        exam.setCourse(course);
	        exam.setTeacher(teacher);
	        exam.setCourseName("Midterm Biology");
	        examRepo.save(exam);

	        // Parent
	        Parent parent = new Parent();
	        parent.setName("Sarah Parent");
	        parent.setAddress("Parent Rd");
	        parent.setPhoneNumber("123456789");
	        parentRepo.save(parent);

	        // Student
	        Student student = new Student();
	        student.setName("Tommy Student");
	        student.setAddress("Student Lane");
	        student.setClassroomId("C1");
	        student.setGradeLevel(grade1);
	        studentRepo.save(student);

	        // Club
	        Club club = new Club();
	        club.setName("Science Club");
	        clubRepo.save(club);
	        club.setMembers(Set.of(student));
	        club = clubRepo.save(club);
	        student.setClubs(Set.of(club));
	        studentRepo.save(student);

	        // Parent-Student relationship
	        parent.setChildren(List.of(student));
	        parentRepo.save(parent);
	        student.setParents(Set.of(parent));
	        studentRepo.save(student);

	        // Registration
	        Registration reg = new Registration();
	        reg.setStudent(student);
	        reg.setStaff(staff);
	        reg.setParent(parent);
	        reg.setGradeLevel(grade1);
	        registrationRepo.save(reg);

	        // Result
	        Result result = new Result();
	        result.setStudent(student);
	        result.setExam(exam);
	        result.setScore(88.5);
	        result.setGradeLetter("B+");
	        resultRepo.save(result);

	        exam.setResult(result);
	        examRepo.save(exam);
	    };
	}
}
