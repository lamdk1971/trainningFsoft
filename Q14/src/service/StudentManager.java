package service;

import entity.GoodStudent;
import entity.NormalStudent;
import entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {

    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showNameAndPhoneNumber() {
        students.sort(Comparator.comparing(Student::getFullName).reversed()
                .thenComparing(Student::getPhoneNumber));
        students.forEach(s -> System.out.println("Name: " + s.getFullName() + " - Phone: " + s.getPhoneNumber()));
    }

    public List<Student> goodStudentList() {
        return students.stream()
                .filter(s -> s instanceof GoodStudent)
                .collect(Collectors.toList());
    }

    public List<Student> normalStudentList() {
        return students.stream()
                .filter(s -> s instanceof NormalStudent)
                .collect(Collectors.toList());
    }
}
