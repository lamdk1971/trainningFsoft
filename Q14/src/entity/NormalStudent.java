package entity;

import util.DateConverter;

import java.time.LocalDate;

public class NormalStudent extends Student{

    private Integer englishScore;
    private Double entryTestScore;

    public NormalStudent() {
    }

    public NormalStudent(String fullName, LocalDate doB, String sex, String phoneNumber, String universityName, String gradeLevel, Integer englishScore, Double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public Double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(Double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void showMyInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "NormalStudent{" +
                "fullName='" + fullName + '\'' +
                ", doB=" + DateConverter.dateToString(doB) +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                ", englishScore=" + englishScore + '\'' +
                ", entryTestScore=" + entryTestScore + '\'' +
                '}';
    }
}
