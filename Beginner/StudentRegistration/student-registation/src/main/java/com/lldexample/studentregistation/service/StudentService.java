package com.lldexample.studentregistation.service;

import com.lldexample.studentregistation.dto.Student;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    private Set<Student> students = new HashSet<>();

    private int id = 1;

    public Student getStudentById(int id) {
        if(!students.isEmpty()) {
            for (Student student : students) {
                if (student.getId() == id) {
                    return student;
                }
            }
        }
        return new Student();
    }

    public Set<Student> getAllStudents() {
        return students;
    }

    public Student createStudent(Student student) {
        Student studentObject = new Student();
        studentObject.setId(id);
        studentObject.setName(student.getName());
        studentObject.setEmail(student.getEmail());
        students.add(studentObject);
        id++;
        return studentObject;
    }

    public Student updateStudentById(Student student, int id) {
        if(!students.isEmpty()) {
            for (Student studentObject : students) {
                if (studentObject.getId() == id) {
                    studentObject.setName(student.getName());
                    studentObject.setEmail(student.getEmail());
                    return studentObject;
                }
            }
        }
        return new Student();
    }

    public String deleteStudentById(int id) {
        if(!students.isEmpty()) {
            for (Student studentObject : students) {
                if (studentObject.getId() == id) {
                    students.remove(studentObject);
                    return "Removed student with id " + id;
                }
            }
        }
        return "Student with id " + id + " does not exist.";
    }

    public String deleteAllStudents() {
        students = new HashSet<>();
        return "Removed all students.";
    }
}