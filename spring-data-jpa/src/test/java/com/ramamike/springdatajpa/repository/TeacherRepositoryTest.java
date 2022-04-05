package com.ramamike.springdatajpa.repository;

import com.ramamike.springdatajpa.entity.Course;
import com.ramamike.springdatajpa.entity.Teacher;
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
    public void saveTeacher(){

        Course courseTMM= Course.builder()
                .title("TMM")
                .credit(5)
                .build();

        Course courseDM= Course.builder()
                .title("DM")
                .credit(4)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Zina")
                        .lastName("Zinkevich")
//                        .courses(List.of(courseTMM,courseDM))
                        .build();
        teacherRepository.save(teacher);
    }

}