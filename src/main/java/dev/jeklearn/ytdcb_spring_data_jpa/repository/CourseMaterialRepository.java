package dev.jeklearn.ytdcb_spring_data_jpa.repository;

import dev.jeklearn.ytdcb_spring_data_jpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
