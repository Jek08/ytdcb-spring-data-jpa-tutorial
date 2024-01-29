package dev.jeklearn.ytdcb_spring_data_jpa.repository;

import dev.jeklearn.ytdcb_spring_data_jpa.entity.Course;
import dev.jeklearn.ytdcb_spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Teacher1")
                .lastName("Teacher")
//                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}