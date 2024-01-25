package dev.jeklearn.ytdcb_spring_data_jpa.repository;

import dev.jeklearn.ytdcb_spring_data_jpa.entity.Guardian;
import dev.jeklearn.ytdcb_spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("stud1@gmail.com")
                .firstName("Stud1")
                .lastName("Student")
//                .guardianName("Guard1 Guardian")
//                .guardianEmail("guard1@gmail.com")
//                .guardianMobile("089089833")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("guard2@gmail.com")
                .name("Guard2 Guardian")
                .mobile("098374643")
                .build();

        Student student = Student.builder()
                .firstName("Stud2")
                .lastName("Student")
                .emailId("stud2@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Stud2");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Stud");
        System.out.println(studentList);
    }

    @Test
    public void pringStudentByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Guard2 Guardian");
        System.out.println(studentList);
    }
}