package repository.attachService;

import model.AttachContract;
import model.Contract;
import model.Customer;
import service.AttachService.AttachService;

import java.util.List;

public interface IAttachServiceReponsitor {
    List<AttachContract> sellectAllAttachService();

    AttachService selectAttachServicetById();

    void insertAttachService(AttachService attachService);

    void deleteAttachService(String id);

    void updateAttachService(AttachService attachService);

    List<AttachContract> selectAttachServiceByName(String name);
}
