package repository.contract;

import model.Contract;
import model.Customer;

import java.util.List;

public interface IContractReponsitory {
    List<Contract> sellectAllContract();

    Contract selectContractById();

    void insertContract(Contract contract);

    void deleteContract(String id);

    void updateContract(Customer customer);

    List<Contract> selectContractByName(String name);
}
