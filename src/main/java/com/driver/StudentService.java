package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.studentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacher(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.allStudendtByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.allStudent();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.delTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.delAllTeacher();
    }




}
