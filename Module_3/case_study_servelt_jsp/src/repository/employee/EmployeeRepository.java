package repository.employee;

import model.Employee;
import repository.connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
//    private static final String SELECT_ALL_EMPLOYEE = "SELECT employee_id," +
//            " employee_name," +
//            " employee_birthday," +
//            " employee_id_card," +
//            " employee_phone," +
//            " employee_salary," +
//            " employee_email," +
//            " employee_address," +
//            " position_name," +
//            " education_degree_name," +
//            " division_name," +
//            " user.username FROM employee " +
//            " LEFT JOIN positions on employee.position_id = positions.position_id " +
//            " LEFT JOIN education_degree on employee.education_degree_id = education_degree.education_degree_id " +
//            " LEFT JOIN division on employee.division_id = division.division_id " +
//            " LEFT JOIN user on employee.user_name = user.user_name;";
private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee ;";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (employee_id," +
            " employee_name," +
            " employee_birthday," +
            " employee_id_card," +
            " employee_salary," +
            " employee_phone," +
            " employee_email," +
            " employee_address," +
            " position_id," +
            " education_degree_id," +
            " division_id," +
            " user_name)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET employee_name = ?," +
            " employee_birthday = ?," +
            " employee_id_card = ?," +
            " employee_salary = ?," +
            " employee_phone = ?," +
            " employee_email = ?," +
            " employee_address = ?," +
            " position_id = ?," +
            " education_degree_id = ?," +
            " division_id = ?," +
            " user_name = ?" +
            " WHERE employee_id = ?;";

    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?";

    private static final String SELECT_EMPLOYEE_BY_NAME = "SELECT employee.employee_id,"+
            " employee_name," +
            " employee_birthday," +
            " employee_id_card," +
            " employee_salary," +
            " employee_phone," +
            " employee_email," +
            " employee_address," +
            " position_name," +
            " education_degree_name," +
            " division_name," +
            " user.username FROM employee " +
            " LEFT JOIN positions on employee.position_id = positions.position_id " +
            " LEFT JOIN education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            " LEFT JOIN division on employee.division_id = division.division_id " +
            " LEFT JOIN user on employee.user_name = user.user_name " +
            " WHERE employee_name LIKE ?;";

    @Override
    public List<Employee> selectAllEmployee() {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = "EP-" + resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                double salary = resultSet.getDouble("employee_salary");
                String position = resultSet.getString("position_id");
                String educationDegree = resultSet.getString("education_degree_id");
                String division = resultSet.getString("division_id");
                String username = resultSet.getString("user_name");

                employeeList.add( new Employee(id,name,birthday,idCard,salary,phone,email,address,position,educationDegree,division,username));
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
        return employeeList;
    }

    @Override
    public Employee selectEmployeeById() {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) {
        Connection connection =  DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
//        id,name,birthday,idCard,phone,email,address,salary,position,educationDegree,division,username
        try {
            preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1,Integer.parseInt(employee.getId().substring(3)));
            preparedStatement.setString(2,employee.getName());
            preparedStatement.setString(3,employee.getBirthday());
            preparedStatement.setString(4,employee.getIdCard());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setString(6,employee.getPhone());
            preparedStatement.setString(7,employee.getEmail());
            preparedStatement.setString(8,employee.getAddress());
            preparedStatement.setString(9,employee.getPosition());
            preparedStatement.setString(10,employee.getEducationDegree());
            preparedStatement.setString(11,employee.getDivision());
            preparedStatement.setString(12,employee.getUsername());

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
    public void deleteEmployee(String id) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);

            preparedStatement.setInt(1,Integer.parseInt(id.substring(3)));

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
    public void updateEmployee(Employee employee) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);

            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getBirthday());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setString(8,employee.getPosition());
            preparedStatement.setString(9,employee.getEducationDegree());
            preparedStatement.setString(10,employee.getDivision());
            preparedStatement.setString(11,employee.getUsername());
            preparedStatement.setInt(12,Integer.parseInt(employee.getId().substring(3)));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        DBconnection.close();
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) {
        Connection connection = DBconnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1,"%" + name +"%");
            resultSet =preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = "EP-" + resultSet.getInt("employee_id");
                name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                double salary = resultSet.getDouble("employee_salary");
                String position = resultSet.getString("position_id");
                String educationDegree = resultSet.getString("education_degree_id");
                String division = resultSet.getString("division_id");
                String username = resultSet.getString("user_name");

                employeeList.add( new Employee(id,name,birthday,idCard,salary,phone,email,address,position,educationDegree,division,username));
            }

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
        return employeeList;
    }

}
