package com.ramamike.springdatajpa.repository;

import com.ramamike.springdatajpa.entity.Course;
import com.ramamike.springdatajpa.entity.Student;
import com.ramamike.springdatajpa.entity.Teacher;
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

    @Test
    public void findAllPagiation(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTqoRecords =
                PageRequest.of(1,2);
        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords).getContent();

        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title").descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "M",
                        firstPageTenRecords
                ).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Sasha")
                .lastName("Strach")
                .build();

        Student student = Student.builder()
                .firstName("Miha")
                .lastName("Ra")
                .emailId("@gmail")
                .build();

        Course course= Course.builder()
                .title("Java")
                .credit(22)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}