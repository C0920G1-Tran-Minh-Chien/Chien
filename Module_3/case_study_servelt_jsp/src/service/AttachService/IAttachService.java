package service.AttachService;

import model.AttachContract;
import model.Contract;
import model.Customer;

import java.util.List;

public interface IAttachService {
    List<AttachContract> selectAllAttachService();

    AttachContract selectAttachServiceById();

    void insertAttachService(AttachContract attachContract);

    void deleteAttachService(String id);

    void updateAttachService(Customer customer);

    List<AttachService> selectAttachServiceByName(String name);
}
