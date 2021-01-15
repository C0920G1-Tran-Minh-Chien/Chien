package service.customer_type;

import model.CustomerType;
import repository.customer_type.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService{
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> selectAllCustomerType() {
        return customerTypeRepository.selectAllCustomerType();
    }
}
