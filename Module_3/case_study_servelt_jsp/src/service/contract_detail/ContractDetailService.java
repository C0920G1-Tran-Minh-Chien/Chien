package service.contract_detail;

import model.Contract;
import model.ContractDetail;
import repository.contract_detail.ContractDetailReponsitory;

import java.util.List;

public class ContractDetailService implements IContractDetailService {
    ContractDetailReponsitory contractDetailReponsitory = new ContractDetailReponsitory();
    @Override
    public List<ContractDetail> selectAllContractDetail() {
        return contractDetailReponsitory.selectAllContractDetail();
    }

    @Override
    public Contract selectContractDetailById() {
        return null;
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        contractDetailReponsitory.insertContractDetail(contractDetail);
    }

    @Override
    public void deleteContractDetail(String id) {

    }

    @Override
    public void updateContractDetail(ContractDetail contractDetail) {

    }

    @Override
    public List<Contract> selectContractDetailByName(String name) {
        return null;
    }
}
