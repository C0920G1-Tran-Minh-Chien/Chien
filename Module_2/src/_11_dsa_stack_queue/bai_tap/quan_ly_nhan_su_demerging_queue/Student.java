package _11_dsa_stack_queue.bai_tap.quan_ly_nhan_su_demerging_queue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student implements Comparable<Student> {
        private String name;
        private String gender;
        private String dateOfBirth;

    public Student() {
    }

    public Student(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int compareTo(Student o) {
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return f.parse(this.getDateOfBirth()).compareTo(f.parse(o.getDateOfBirth()));
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
    }
}
