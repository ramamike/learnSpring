package com.ramamike.springdatajpa.repository;

import com.ramamike.springdatajpa.entity.Guardian;
import com.ramamike.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student=Student.builder()
                .emailId("test@gmail.com")
                .firstName("Mike")
                .lastName("Rama")
//                .guardianName("GuardName")
//                .guardianEmail("guard@gmail.com")
//                .guardianMobile("9591234")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardians(){

        Guardian guardian=Guardian.builder()
                .email("guardPasha@gmail.com")
                .mobile("93193122")
                .name("GuardPasha")
                .build();

        Student student = Student.builder()
                .firstName("Pasha")
                .emailId("pasha@gmail.com")
                .lastName("Rama")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }


    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testFindByFirstName() {
        List<Student> studentList =
                studentRepository.findByFirstName("Mike");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testFindByFirstNameContaining() {
        List<Student> studentList =
                studentRepository.findByFirstNameContaining("Mi");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testFindByLastNameNotNull() {
        List<Student> studentList =
                studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testFindByGuardianName() {
        List<Student> studentList =
                studentRepository.findByGuardianName("GuardPasha");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testQueryfindByEmailId() {
        Student student =
                studentRepository.getStudentByEmailAddress("test@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public  void testQueryFindFirstNamefByEmailId() {
        String firstName = studentRepository.getFirstNameStudentByEmailAddress("test@gmail.com");
        System.out.println("firstName = " + firstName);
    }
    
    @Test
    public void testNativeQueryFindByEmailId() {
        Student student =
                studentRepository.getStudentByEmailAddressNative("test@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void testNativeNameParamQueryFindByEmailId() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNameParam("test@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateFirstNameByEmailId() {
                studentRepository.updateStudentNameByEmailId("Mihal","test@gmail.com");
    }

}