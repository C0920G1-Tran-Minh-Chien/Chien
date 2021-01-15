package CaseStudy.models;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Date;
import java.util.List;

public class Customers implements Comparable<Customers>{
    private  String typeServices;
    private List<String> typeServices2;
    int id;
    String nameCustomer ;
    String birthday;
    String cmnd;
    String phoneNumber;
    String email;
    String typeCustomer;
    String address;
    Services services;

    public Customers(int id, String nameCustomer, String birthday, String cmnd, String phoneNumber, String email, String typeCustomer, String address, String typeServices) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.typeServices = typeServices;
    }
    public Customers(int id, String nameCustomer, String birthday, String cmnd, String phoneNumber, String email, String typeCustomer, String address, List<String> typeServices2) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
        this.typeServices2 = typeServices2;
    }
    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Customers(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(String typeServices) {
        this.typeServices = typeServices;
    }

    public List<String> getTypeServices2() {
        return typeServices2;
    }

    public void setTypeServices2(List<String> typeServices2) {
        this.typeServices2 = typeServices2;
    }

    public String showInfor(){
        return this.toString();
    }

    @Override
    public String toString() {
        return
                " Id : " + id + "\n" +
                        " Name Customer : " + nameCustomer + '\n' +
                        " birthday : " + birthday + '\n' +
                        " cmnd : " + cmnd + '\n' +
                        " phoneNumber : " + phoneNumber + '\n' +
                        " email : " + email + '\n' +
                        " typeCustomer : " + typeCustomer + '\n' +
                        " address : " + address + "\n" +
                        " typeServices : "+ typeServices +
                        " \n -----------------------------------------------";

    }
    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date datetime) {
        this.dateTime = datetime;
    }
    @Override
    public int compareTo(Customers o) {
        if (getDateTime() == null || o.getDateTime() == null)
            return 0;
        return getDateTime().compareTo(o.getDateTime());
    }
}
