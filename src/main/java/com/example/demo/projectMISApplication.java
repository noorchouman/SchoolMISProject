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

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
@SpringBootApplication
public class projectMISApplication {

	public static void main(String[] args) {
		SpringApplication.run(projectMISApplication.class, args);
	}
	@Bean
	OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("School System").description("School MGMT System API").version("v1.0.0"))
				.components(new Components()
		            .addSecuritySchemes("bearerAuth",
		                new SecurityScheme()
		                    .type(SecurityScheme.Type.HTTP)
		                    .scheme("bearer")
		                    .bearerFormat("JWT")));
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
	        // 1. Grade Level
	        GradeLevel grade1 = new GradeLevel();
	        grade1.setLevel(1);
	        grade1.setName("Grade 1");
	        grade1 = gradeLevelRepo.save(grade1);

	        // 2. Staff
	        Staff staff = new Staff();
	        staff.setName("Alice Admin");
	        staff.setAddress("Admin Street");
	        staff.setSalary(3000L);
	        staff.setRole("Registrar");
	        staff = staffRepo.save(staff);

	        // 3. Department, with staff as head
	        Department department = new Department();
	        department.setName("Science");
	        department.setHead(staff);
	        department = departmentRepo.save(department);

	        department=departmentRepo.save(department);
	        staff.setDepartment(department);
	        staffRepo.save(staff);

	        // Link staff back to department
	        staff.setDepartment(department);
	        staff = staffRepo.save(staff);


	        // 4. Teacher (belongs to department)
	        Teacher teacher = new Teacher();
	        teacher.setName("John Doe");
	        teacher.setAddress("Teacher Avenue");
	        teacher.setSalary(5000L);
	        teacher.setRole("Science Teacher");
	        teacher.setSubject("Biology");
	        teacher.setDepartment(department);
	        teacher = teacherRepo.save(teacher);

	        // 5. Course (with teacher, gradeLevel)
	        Course course = new Course();
	        course.setCourseName("Intro to Biology");
	        course.setTeacher(teacher);
	        course.setGradeLevel(grade1);
	        course = courseRepo.save(course);

	        // 6. Exam (with course, teacher)
	        Exam exam = new Exam();
	        exam.setCourse(course);
	        exam.setTeacher(teacher);
	        exam.setCourseName("Midterm Biology");
	        exam = examRepo.save(exam);

	        // 7. Parent
	        Parent parent = new Parent();
	        parent.setName("Sarah Parent");
	        parent.setAddress("Parent Rd");
	        parent.setPhoneNumber("123456789");
	        parent = parentRepo.save(parent);

	        // 8. Student (with gradeLevel)
	        Student student = new Student();
	        student.setName("Tommy Student");
	        student.setAddress("Student Lane");
	        student.setClassroomId("C1");
	        student.setGradeLevel(grade1);
	        student = studentRepo.save(student);

	        // 9. Club (no members yet)
	        Club club = new Club();
	        club.setName("Science Club");
	        club = clubRepo.save(club);

	        // Now set up club membership (student joins club)
	        club.setMembers(Set.of(student));
	        club = clubRepo.save(club);

	        // Student joins club
	        student.setClubs(Set.of(club));
	        student = studentRepo.save(student);

	        // 10. Parent-Student relationship
	        parent.setChildren(List.of(student));
	        parent = parentRepo.save(parent);

	        student.setParents(Set.of(parent));
	        student = studentRepo.save(student);

	        // 11. Registration (ties student, staff, parent, gradeLevel)
	        Registration reg = new Registration();
	        reg.setStudent(student);
	        reg.setStaff(staff);
	        reg.setParent(parent);
	        reg.setGradeLevel(grade1);
	        reg = registrationRepo.save(reg);

	        // 12. Result (ties student, exam)
	        Result result = new Result();
	        result.setStudent(student);
	        result.setExam(exam);
	        result.setScore(88.5);
	        result.setGradeLetter("B+");
	        result = resultRepo.save(result);

	        // Attach result to exam (optional, for bi-directional)
	        exam.setResult(result);
	        exam = examRepo.save(exam);
	    };
	}

}
