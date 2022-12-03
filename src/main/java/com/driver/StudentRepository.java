package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StudentRepository {

    static HashMap<String,Student>students=new HashMap<>();
    static HashMap<String,Teacher>teachers=new HashMap<>();
    HashMap<String, List<String>>teacherStudent=new HashMap<>();

    public void addStudent(Student student){
        students.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getName(), teacher);
    }
    public void studentTeacherPair(String student,String teacher){
        if(students.containsKey(student) && teachers.containsKey(teacher)){
            students.put(student, students.get(student));
            teachers.put(teacher, teachers.get(teacher));
            List<String> curr = new ArrayList<String>();
            if(teacherStudent.containsKey(teacher)){
                curr = teacherStudent.get(teacher);
            }
            curr.add(student);
            teacherStudent.put(teacher, curr);
        }

    }
    public static Student getStudent(String name){
        return students.get(name);
    }

    public static Teacher getTeacher(String name){
        return teachers.get(name);
    }
    public List<String> allStudent(){
        List<String> list = new ArrayList<>();
        for(String i: students.keySet()){
            list.add(i);
        }
        return list;
    }
    public void delAllTeacher(){
        teachers.clear();
        teacherStudent.clear();
    }
    public void delTeacherByName(String teacher){
        List<String> studentList = new ArrayList<String>();
        if(teacherStudent.containsKey(teacher)){
            studentList = teacherStudent.get(teacher);
            for(String movie: studentList){
                if(students.containsKey(movie)){
                    students.remove(movie);
                }
            }

            teacherStudent.remove(teacher);
        }

        if(teachers.containsKey(teacher)){
            teachers.remove(teacher);
        }
    }
    public List<String> allStuendtByTeacherName(String teacher){
        List<String> studentList = new ArrayList<String>();
        if(teacherStudent.containsKey(teacher)) {
            studentList = teacherStudent.get(teacher);
        }
        return studentList;
    }
}
