package com.example.demo.student;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getId() {
        // Arrange
        Student student = new Student();
        student.setId(1L);

        // Act
        Long id = student.getId();

        // Assert
        assertEquals(1L, id, "ID-ul ar trebui să fie 1");
    }

    @Test
    void setId() {
        // Arrange
        Student student = new Student();

        // Act
        student.setId(2L);

        // Assert
        assertEquals(2L, student.getId(), "ID-ul ar trebui să fie 2 după setare");
    }

    @Test
    void getName() {
        // Arrange
        Student student = new Student();
        student.setName("John");

        // Act
        String name = student.getName();

        // Assert
        assertEquals("John", name, "Numele ar trebui să fie 'John'");
    }

    @Test
    void setName() {
        // Arrange
        Student student = new Student();

        // Act
        student.setName("Jane");

        // Assert
        assertEquals("Jane", student.getName(), "Numele ar trebui să fie 'Jane' după setare");
    }

    @Test
    void getAge() {
        // Arrange
        LocalDate dob = LocalDate.of(2000, 1, 1);
        Student student = new Student("John", "john.doe@example.com", dob);

        // Act
        int age = student.getAge();

        // Assert
        int expectedAge = LocalDate.now().getYear() - dob.getYear();
        assertEquals(expectedAge, age, "Vârsta ar trebui să fie corect calculată");
    }

    @Test
    void getDob() {
        // Arrange
        LocalDate dob = LocalDate.of(1995, 5, 15);
        Student student = new Student();
        student.setDob(dob);

        // Act
        LocalDate resultDob = student.getDob();

        // Assert
        assertEquals(dob, resultDob, "Data de naștere ar trebui să fie '1995-05-15'");
    }

    @Test
    void setDob() {
        // Arrange
        Student student = new Student();
        LocalDate dob = LocalDate.of(2001, 12, 20);

        // Act
        student.setDob(dob);

        // Assert
        assertEquals(dob, student.getDob(), "Data de naștere ar trebui să fie '2001-12-20' după setare");
    }

    @Test
    void getEmail() {
        // Arrange
        Student student = new Student();
        student.setEmail("test@example.com");

        // Act
        String email = student.getEmail();

        // Assert
        assertEquals("test@example.com", email, "Email-ul ar trebui să fie 'test@example.com'");
    }

    @Test
    void setEmail() {
        // Arrange
        Student student = new Student();

        // Act
        student.setEmail("new.email@example.com");

        // Assert
        assertEquals("new.email@example.com", student.getEmail(), "Email-ul ar trebui să fie 'new.email@example.com' după setare");
    }

    @Test
    void testToString() {
        // Arrange
        LocalDate dob = LocalDate.of(1990, 10, 10);
        Student student = new Student(1L, "Alice", dob, "alice@example.com");

        // Act
        String result = student.toString();

        // Assert
        assertTrue(result.contains("Alice"), "toString ar trebui să includă numele 'Alice'");
        assertTrue(result.contains("alice@example.com"), "toString ar trebui să includă email-ul 'alice@example.com'");
        assertTrue(result.contains("1990-10-10"), "toString ar trebui să includă data de naștere '1990-10-10'");
    }
}
