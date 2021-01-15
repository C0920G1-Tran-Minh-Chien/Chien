package repository.contract_detail;

import model.Contract;
import model.ContractDetail;
import repository.connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailReponsitory implements IContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL = "SELECT * from contract_detail;";
    private static final String INSERT_CONTRACT_DETAIL = "INSERT INTO contract_detail VALUES (?,?,?,?);";

    @Override
    public List<ContractDetail> selectAllContractDetail() {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("contract_detail_id");
                int contractId = resultSet.getInt("contract_id");
                int attachService = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetailList.add(new ContractDetail(id,contractId,attachService,quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBconnection.close();
        }
        return contractDetailList;
    }

    @Override
    public Contract selectContractDetailById() {
        return null;
    }

    @Override
    public void insertContractDetail(ContractDetail contractDetail) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1,contractDetail.getId());
            preparedStatement.setInt(2,contractDetail.getContractId());
            preparedStatement.setInt(3,contractDetail.getAttachService());
            preparedStatement.setInt(4,contractDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBconnection.close();
        }
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
