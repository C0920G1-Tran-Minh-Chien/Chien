package service.AttachService;

import model.AttachContract;
import model.Customer;
import repository.attachService.AttachServiceReponsitoyry;

import java.util.List;

public class AttachService implements IAttachService {
    AttachServiceReponsitoyry attachServiceReponsitoyry = new AttachServiceReponsitoyry();
    @Override
    public List<AttachContract> selectAllAttachService() {
        return attachServiceReponsitoyry.sellectAllAttachService();
    }

    @Override
    public AttachContract selectAttachServiceById() {
        return null;
    }

    @Override
    public void insertAttachService(AttachContract attachContract) {

    }

    @Override
    public void deleteAttachService(String id) {

    }

    @Override
    public void updateAttachService(Customer customer) {

    }

    @Override
    public List<AttachService> selectAttachServiceByName(String name) {
        return null;
    }
}
