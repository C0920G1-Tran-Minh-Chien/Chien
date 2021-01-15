package service.contract_detail;

import model.Contract;
import model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> selectAllContractDetail();

    Contract selectContractDetailById();

    void insertContractDetail(ContractDetail contractDetail);

    void deleteContractDetail(String id);

    void updateContractDetail(ContractDetail contractDetail);

    List<Contract> selectContractDetailByName(String name);
}
