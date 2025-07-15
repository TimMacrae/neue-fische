package com.ecosystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentService studentService = new StudentService();

    @Test
    void getStudentById_ShouldThrowException_WhenIdIsNotFound() {
        assertThrows(NoStudentFoundException.class, () -> studentService.getStudentById("notfound"));
    }

    @Test
    void getStudentById_ShouldThrowException_WhenIdIsNull() {
        assertThrows(NoStudentFoundException.class, () -> studentService.getStudentById(null));
    }

    @Test
    void getStudentById_ShouldThrowException_WhenIdIsEmpty() {
        assertThrows(NoStudentFoundException.class, () -> studentService.getStudentById(""));
    }

    @Test
    void getStudentById_ShouldThrowException_WhenIdIsBlank() {
        assertThrows(NoStudentFoundException.class, () -> studentService.getStudentById(" "));
    }


}