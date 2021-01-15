package controller;

import exception.DateException;
import exception.Validate;
import model.*;
import repository.attachService.AttachServiceReponsitoyry;
import service.contract.ContractService;
import service.contract_detail.ContractDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet" , urlPatterns = "/contract-details")
public class ContractDetailServlet extends HttpServlet {
    ContractService contractService = new ContractService();
    AttachServiceReponsitoyry attachContract = new AttachServiceReponsitoyry();
    ContractDetailService contractDetailService = new ContractDetailService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action){
            case "create" :
                createContractDetails(request,response);
                getAllContractDetail(request,response);
                break;
            default:
                break;
        }
    }

    private void createContractDetails(HttpServletRequest request, HttpServletResponse response) {
        boolean flag = true;
        String message = "";
        int id = 0;
        int quantity = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            Validate.regexNumberInt(quantity);
        }catch (NumberFormatException e) {
            message += "Number > 0";
            flag= false;
        }
        int contract = Integer.parseInt(request.getParameter("contract"));
        int attachService = Integer.parseInt(request.getParameter("attachContract"));
        if (!flag){
            request.setAttribute("id",id);
            request.setAttribute("quantity", quantity);
            request.setAttribute("message",message);
            createJSP(request,response);
        }
        ContractDetail contractDetail = new ContractDetail(id ,contract ,attachService,quantity);
        contractDetailService.insertContractDetail(contractDetail);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action ="";
        }

        switch (action){
            case "create":
                createJSP(request,response);
                break;
            default:
                getAllContractDetail(request,response);
        }
    }

    private void getAllContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList = contractDetailService.selectAllContractDetail();

        request.setAttribute("contractDetailList", contractDetailList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract_detail/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createJSP(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.selectAllContract();
        List<AttachContract> attachContracts = attachContract.sellectAllAttachService();
        request.setAttribute("contractList",contractList );
        request.setAttribute("attachContracts",attachContracts );
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contract_detail/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
