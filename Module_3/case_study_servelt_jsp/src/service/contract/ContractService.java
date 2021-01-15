package service.contract;

import model.Contract;
import model.Customer;
import repository.contract.ContractReponsitory;

import java.util.List;

public class ContractService implements IContractService {
    ContractReponsitory contractReponsitory = new ContractReponsitory();
    @Override
    public List<Contract> selectAllContract() {
        return contractReponsitory.sellectAllContract();
    }

    @Override
    public Contract selectContractById() {
        return null;
    }

    @Override
    public void insertContract(Contract contract) {
        contractReponsitory.insertContract(contract);
    }

    @Override
    public void deleteContract(String id) {

    }

    @Override
    public void updateContract(Customer customer) {

    }

    @Override
    public List<Contract> selectContractByName(String name) {
        return null;
    }
}
