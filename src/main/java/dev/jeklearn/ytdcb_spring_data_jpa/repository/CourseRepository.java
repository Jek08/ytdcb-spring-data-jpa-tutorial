package dev.jeklearn.ytdcb_spring_data_jpa.repository;

import dev.jeklearn.ytdcb_spring_data_jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByCourseTitleContaining(String title, Pageable pageRequest);
}
