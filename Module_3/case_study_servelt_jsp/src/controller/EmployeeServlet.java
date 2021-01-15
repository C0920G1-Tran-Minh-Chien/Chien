package controller;

import exception.*;
import model.Customer;
import model.Employee;
import service.employee.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(request, response);
                getAllEmployee(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                getAllEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                getAllEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        employeeService.deleteEmployee(id);
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = true;

        String messageBirthday = null;
        String messageIdCard = null;
        String messagePhone = null;
        String messageEmail = null;

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = null;
        try {
            birthday = request.getParameter("birthday");
            Validate.regexDate(birthday);
        } catch (DateException e) {
            messageBirthday = e.getMessage();
            flag = false;
        }
        double salary = Double.parseDouble(request.getParameter("salary"));
        String idCard = null;
        try {
            idCard = request.getParameter("idCard");
            Validate.regexIdCard(idCard);
        } catch (IdCardException e) {
            messageIdCard = e.getMessage();
            flag = false;
        }
        String phoneNumber = null;
        try {
            phoneNumber = request.getParameter("phone");
            Validate.regexPhone(phoneNumber);
        } catch (NumberPhoneException e) {
            messagePhone = e.getMessage();
            flag = false;
        }
        String email = null;
        try {
            email = request.getParameter("email");
            Validate.regexEmail(email);
        } catch (EmailException e) {
            messageEmail = e.getMessage();
            flag = false;
        }
        String address = request.getParameter("address");
        String position = request.getParameter("position_id");
        String education_degree = request.getParameter("education_degree_id");
        String division = request.getParameter("division_id");
        String username = request.getParameter("user_name");

        if (!flag) {
            request.setAttribute("messageBirthday", messageBirthday);
            request.setAttribute("messageIdCard", messageIdCard);
            request.setAttribute("messagePhone", messagePhone);
            request.setAttribute("messageEmail", messageEmail);

            createJSP(request, response);

        } else {

            Employee employee = new Employee(id, name, birthday, idCard, salary,phoneNumber, email, address ,position, education_degree,division,username);
            employeeService.insertEmployee(employee);

        }
    }
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employeeList",employeeService.selectAllEmployee());
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String position = request.getParameter("position_id");
        String education_degree = request.getParameter("education_degree_id");
        String division = request.getParameter("division_id");
        String username = request.getParameter("user_name");
        Employee employee = new Employee(id, name, birthday, idCard,salary, phoneNumber, email, address ,position, education_degree,division,username);
        employeeService.updateEmployee(employee);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createJSP(request,response);
                break;
            case "find" :
                findJSP(request,response);
                break;
            default:
                getAllEmployee(request, response);
                break;
        }
    }

    private void findJSP(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.selectEmployeeByName(name);
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list_find.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createJSP(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        request.setAttribute("employeeList", employeeList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
