package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StudentRepository {

    static HashMap<String,Student>students;
    static HashMap<String,Teacher>teachers;
    HashMap<String, List<String>>teacherStudent;

    public StudentRepository(){
        students=new HashMap<>();
        teachers=new HashMap<>();
       teacherStudent=new HashMap<>();
    }

    public void addStudent(Student student){
        students.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }
    public void studentTeacherPair(String student,String teacher){
        if (!teacherStudent.containsKey(teacher)) {
            teacherStudent.put(teacher, new ArrayList<>());
        }
        teacherStudent.get(teacher).add(student);
    }
    public static Student getStudent(String name){
        return students.get(name);
    }

    public static Teacher getTeacher(String name){
        return teachers.get(name);
    }
    public List<String> allStudent(){
        return new ArrayList<>(students.keySet());
    }
    public void delAllTeacher(){
        for (String name : teacherStudent.keySet()) {
            for (String student : teacherStudent.get(name)) {
                students.remove(student);
            }
        }
      teacherStudent.clear();
        teachers.clear();
    }
    public void delTeacherByName(String teacher){
        for (String name : teacherStudent.get(teacher)) {
            students.remove(name);
        }
        teachers.remove(teacher);
        teacherStudent.remove(teacher);
    }
    public List<String> allStudendtByTeacherName(String teacher){
        return teacherStudent.get(teacher);
    }
}
