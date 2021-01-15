package vn.codegym.model;

public class Student {
    private int id;
    private String[] languages;
    private int gender;
    private String name;

    public Student(int id, String[] languages, int gender, String name) {
        this.id = id;
        this.languages = languages;
        this.gender = gender;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object obj) {
        //neu doi tuong so sanh bi null, hoac doi tuong khong phai la Student
        if(obj == null || !(obj instanceof Student)){
            return false;
        }

        Student otherStudent = (Student) obj;
        if(otherStudent.getId() == this.id){
            return true;
        }
        return false;
    }
}
