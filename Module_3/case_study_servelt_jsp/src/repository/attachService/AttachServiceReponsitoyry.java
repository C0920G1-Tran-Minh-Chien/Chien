package repository.attachService;

import model.AttachContract;
import repository.connection.DBconnection;
import service.AttachService.AttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceReponsitoyry implements IAttachServiceReponsitor {
    private static final String SELECT_ALL_ATTACH = "select * from attach_service";
    @Override
    public List<AttachContract> sellectAllAttachService() {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<AttachContract> attachServiceList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("attach_service_id");
                String attachName = resultSet.getString("attach_service_name");
                int cost = resultSet.getInt("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                attachServiceList.add(new AttachContract(id,attachName,cost,unit,status));
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
        return attachServiceList;
    }

    @Override
    public AttachService selectAttachServicetById() {
        return null;
    }

    @Override
    public void insertAttachService(AttachService attachService) {

    }

    @Override
    public void deleteAttachService(String id) {

    }

    @Override
    public void updateAttachService(AttachService attachService) {

    }

    @Override
    public List<AttachContract> selectAttachServiceByName(String name) {
        return null;
    }
}
