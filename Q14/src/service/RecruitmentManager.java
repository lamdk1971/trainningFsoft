package service;

import entity.GoodStudent;
import entity.NormalStudent;
import entity.Student;
import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidInputException;
import exception.InvalidPhoneNumberException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecruitmentManager {

    private StudentManager studentManager;
    private int n;

    public RecruitmentManager() {
        this.studentManager = new StudentManager();
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }

    public void menu() {
        System.out.println("MENU:");
        System.out.println("1. Number of students to recruit:");
        System.out.println("2. Add student");
        System.out.println("3. Show students info");
        System.out.println("4. Show candidates");
        System.out.println("5. Exit");
        int i = new Scanner(System.in).nextInt();

        switch (i) {
            case 1: {
                System.out.println("Number of student to recruit:");
                int s = new Scanner(System.in).nextInt();
                try {
                    InputValidator.numberOfRecruitmentCheck(s);
                } catch (InvalidInputException e) {
                    e.printStackTrace();
                }
                n = s;
                break;
            }
            case 2: {
                insertStudent();
                break;
            }
            case 3: {
                System.out.println("Show students info");
                studentManager.showNameAndPhoneNumber();
                break;
            }
            case 4: {
                System.out.println("Show candidates");
                showCandidates();
                break;
            }
            case 5: {
                System.err.println("Exiting...");
                System.exit(0);
            }
            default: {
                System.err.println("Wrong input");
                break;
            }
        }
    }

    private void insertStudent() {
        System.out.println("Type of student:");
        System.out.println("a) Good student");
        System.out.println("b) Normal student");
        Student student = null;
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();

        if (t.equals("a")) {
            try {
                student = createGoodStudent(scanner);
            }
            catch (InvalidFullNameException | InvalidDOBException | InvalidPhoneNumberException e) {
                e.printStackTrace();
                insertStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (t.equals("b")) {
            try {
                student = createNormalStudent(scanner);
            }
            catch (InvalidFullNameException | InvalidPhoneNumberException | InvalidDOBException e) {
                e.printStackTrace();
                insertStudent();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else System.err.println("Wrong input");
        studentManager.addStudent(student);
    }

    private void showCandidates() {
        List<Student> candidates = new ArrayList<>();
        List<Student> goodStudents = studentManager.goodStudentList();
        List<Student> normalStudents = studentManager.normalStudentList();
        if (goodStudents.size() >= n) {
            candidates.addAll(
                    goodStudents.stream()
                    .map(s -> (GoodStudent) s)
                    .sorted(Comparator.comparing(GoodStudent::getGpa).reversed()
                            .thenComparing(GoodStudent::getFullName))
                    .limit(n)
                    .collect(Collectors.toList())
            );
        }
        else {
            candidates.addAll(goodStudents);
            candidates.addAll(
                    normalStudents.stream()
                            .map(s -> (NormalStudent) s)
                            .sorted(Comparator.comparing(NormalStudent::getEntryTestScore).reversed()
                                    .thenComparing(NormalStudent::getEnglishScore).reversed()
                                    .thenComparing(NormalStudent::getFullName))
                            .limit(n - goodStudents.size())
                            .collect(Collectors.toList())
            );
        }
        candidates.forEach(Student::showMyInfo);
    }

    private Student createNormalStudent(Scanner scanner) {
        System.out.println("Adding normal student:");
        System.out.println("Full Name:");
        String name = scanner.nextLine();
        InputValidator.nameCheck(name);
        System.out.println("Date of Birth (dd/MM/yyyy):");
        String dobStr = scanner.nextLine();
        LocalDate dob = InputValidator.dobCheck(dobStr);
        System.out.println("Sex:");
        String sex = scanner.nextLine();
        System.out.println("Phone numner:");
        String phone = scanner.nextLine();
        InputValidator.phoneNumberCheck(phone);
        System.out.println("University:");
        String university = scanner.nextLine();
        System.out.println("Grade level:");
        String gradeLevel = scanner.nextLine();
        System.out.println("English Score:");
        Integer engScore = new Scanner(System.in).nextInt();
        System.out.println("Entry test score:");
        Double entryScore = new Scanner(System.in).nextDouble();
        return new NormalStudent(name, dob, sex, phone, university, gradeLevel, engScore, entryScore);
    }

    private Student createGoodStudent(Scanner scanner) {
        System.out.println("Adding good student:");
        System.out.println("Full Name:");
        String name = scanner.nextLine();
        InputValidator.nameCheck(name);
        System.out.println("Date of Birth (dd/MM/yyyy):");
        String dobStr = scanner.nextLine();
        LocalDate dob = InputValidator.dobCheck(dobStr);
        System.out.println("Sex:");
        String sex = scanner.nextLine();
        System.out.println("Phone numner:");
        String phone = scanner.nextLine();
        InputValidator.phoneNumberCheck(phone);
        System.out.println("University:");
        String university = scanner.nextLine();
        System.out.println("Grade level:");
        String gradeLevel = scanner.nextLine();
        System.out.println("Gpa:");
        Double gpa = new Scanner(System.in).nextDouble();
        System.out.println("Best Reward Name:");
        String bestReward = scanner.nextLine();
        return new GoodStudent(name, dob, sex, phone, university, gradeLevel, gpa, bestReward);
    }


}
