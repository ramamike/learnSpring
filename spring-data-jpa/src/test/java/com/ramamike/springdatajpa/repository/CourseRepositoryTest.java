package com.ramamike.springdatajpa.repository;

import com.ramamike.springdatajpa.entity.Course;
import com.ramamike.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList =
                courseRepository.findAll();

        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacherObject(){

        Teacher teacher=Teacher.builder()
                .firstName("Phil")
                .lastName("Philov")
                .build();

        Course course= Course.builder()
                .title("Philosophy")
                .credit(2)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}