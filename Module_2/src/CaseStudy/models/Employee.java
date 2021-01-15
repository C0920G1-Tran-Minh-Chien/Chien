package CaseStudy.models;

public class Employee {
    private String name;
    private String dateOfBirth;
    private String address;
    public  Employee(){}

    public Employee(String name, String dateOfBirth,String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return " Name Employee : " + name + "\n" +
                " ID Employee : " + dateOfBirth + "\n" +
                " Address Employee : " + address + "\n"+
                "-------------------------------------------------";
    }
}
