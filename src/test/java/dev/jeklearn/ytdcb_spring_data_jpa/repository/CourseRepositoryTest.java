package dev.jeklearn.ytdcb_spring_data_jpa.repository;

import dev.jeklearn.ytdcb_spring_data_jpa.entity.Course;
import dev.jeklearn.ytdcb_spring_data_jpa.entity.Student;
import dev.jeklearn.ytdcb_spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Teacher2")
                .lastName("Teacher")
                .build();

        Course course = Course.builder()
                .courseTitle("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPagewithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPagewithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPagewithTwoRecords)
                        .getTotalElements();
        long totalPages = courseRepository.findAll(secondPagewithTwoRecords)
                        .getTotalPages();

        System.out.println(courses);
        System.out.println(totalElements);
        System.out.println(totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleCreditDesc = PageRequest.of(0, 2, Sort.by("courseTitle")
                .descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> course = courseRepository.findByCourseTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println(course);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Teacher2")
                .lastName("Teacher")
                .build();

        Student student = Student.builder()
                .firstName("Student3")
                .lastName("Student")
                .emailId("stud3@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("IntroComp")
                .credit(5)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}