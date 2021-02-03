package com.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @FutureOrPresent
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date endDate;

    @NotNull
    private double deposit;

    @NotNull
    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        Date dateInput1 = contract.startDate;
        Date dateInput2 = contract.endDate;


        if (dateInput1 == null || dateInput2 == null) {
            errors.rejectValue("startDate", "DateNotNull");
            errors.rejectValue("startDate", "DateNotNull");
        }   else {
            if (dateInput2.before(dateInput1)) {
                errors.rejectValue("endDate", "EndDateMustAfterOrEqualStartDate");
            }
        }

    }
}
