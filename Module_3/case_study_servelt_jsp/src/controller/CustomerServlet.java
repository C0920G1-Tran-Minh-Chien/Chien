package controller;

import exception.*;
import model.Customer;
import service.customer.CustomerService;
import service.customer_type.CustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    CustomerTypeService customerTypeService = new CustomerTypeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request, response);
                getAllCustomer(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                getAllCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                getAllCustomer(request, response);
                break;
            default:
                break;
        }
    }


    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = true;
        String messageId = null;
        String messageBirthday = null;
        String messageIdCard = null;
        String messagePhone = null;
        String messageEmail = null;

        String id = null;
        try {
            id = request.getParameter("id");
            Validate.regexCustomerId(id);
        } catch (IdException e) {
            messageId = e.getMessage();
            flag = false;
        }
        String name = request.getParameter("name");
        System.out.println(name);
        String birthday = null;
        try {
            birthday = request.getParameter("birthday");
            Validate.regexDate(birthday);
        } catch (DateException e) {
            messageBirthday = e.getMessage();
            flag = false;
        }
        String gender = request.getParameter("gender");
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
        String customerType = request.getParameter("customerType");

        if (!flag) {
            request.setAttribute("messageId", messageId);
            request.setAttribute("messageBirthday", messageBirthday);
            request.setAttribute("messageIdCard", messageIdCard);
            request.setAttribute("messagePhone", messagePhone);
            request.setAttribute("messageEmail", messageEmail);

            createJSP(request, response);

        } else {

            Customer customer = new Customer(id, name, birthday, idCard, phoneNumber, email, address, gender, customerType);
            customerService.insertCustomer(customer);

        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String customerType = request.getParameter("customerType");
        Customer customer = new Customer(id, name, birthday, gender, idCard, phoneNumber, email, address ,customerType);

        customerService.updateCustomer(customer);
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        customerService.deleteCustomer(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createJSP(request, response);
                break;
            case "find":
                findJSP(request, response);
                break;
            default:
                getAllCustomer(request, response);
        }
    }

    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeService.selectAllCustomerType());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void findJSP(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.selectCustomerByName(name);
        request.setAttribute("customerList", customerList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list_find.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createJSP(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerTypeList", customerTypeService.selectAllCustomerType());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
