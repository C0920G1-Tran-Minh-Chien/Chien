package repository.service;


import model.Customer;
import model.Service;
import repository.connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {

    private static final String SELECT_ALL_SERVICE = "SELECT service_id,"+
            " service_name,"+
            " service_area,"+
            " service_cost,"+
            " service_max_people,"+
            " rent_type_name,"+
            " service_type_name,"+
            " standard_room,"+
            " description_other_convenience,"+
            " pool_area,"+
            " number_of_floors FROM service "+
            " JOIN service_type on service.service_type_id = service_type.service_type_id "+
            " JOIN rent_type on service.rent_type_id = rent_type.rent_type_id;";

    private static final String INSERT_SERVICE = "INSERT INTO service VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    @Override
    public List<Service> selectAllService() {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Service> serviceList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = "SV-" + resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                double area = resultSet.getDouble("service_area");
                double cost = resultSet.getDouble("service_cost");
                int maxPeople = resultSet.getInt("service_max_people");
                String serviceType = resultSet.getString("service_type_name");
                String rentType = resultSet.getString("rent_type_name");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFools = resultSet.getInt("number_of_floors");


                serviceList.add(new Service(id,name,area,cost,maxPeople,standardRoom,description,poolArea,numberOfFools,serviceType,rentType));
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
        return serviceList;
    }

    @Override
    public Customer selectServiceById() {
        return null;
    }

    @Override
    public void insertService(Service service) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement(INSERT_SERVICE);

            preparedStatement.setInt(1,Integer.parseInt(service.getId().substring(3)));
            preparedStatement.setString(2,service.getName());
            preparedStatement.setDouble(3,service.getArea());
            preparedStatement.setDouble(4,service.getCost());
            preparedStatement.setInt(5,service.getServiceMaxPeople());
            preparedStatement.setInt(6,Integer.parseInt(service.getRentType()));
            preparedStatement.setInt(7,Integer.parseInt(service.getServiceType()));
            preparedStatement.setString(8,service.getStandardRoom());
            preparedStatement.setString(9,service.getDescription());
            preparedStatement.setDouble(10,service.getPoolArea());
            preparedStatement.setInt(11,service.getNumberOfFloor());

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
    public void deleteService(String id) {

    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public List<Service> selectServiceByName(String name) {
        return null;
    }
}
