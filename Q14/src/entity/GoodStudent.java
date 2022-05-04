package entity;

import util.DateConverter;

import java.time.LocalDate;

public class GoodStudent extends Student{

    private Double gpa;
    private String bestRewardName;

    public GoodStudent() {
    }

    public GoodStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, Double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void showMyInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "GoodStudent{" +
                "fullName='" + fullName + '\'' +
                ", doB=" + DateConverter.dateToString(doB) +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                ", gpa=" + gpa + '\'' +
                ", bestRewardName='" + bestRewardName + '\'' +
                '}';
    }
}
